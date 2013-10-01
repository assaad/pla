package lu.snt.serval.pla.sensors;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 06/12/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/



//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Generates temperature values
 */
public class TempGenerator implements TempProvider, Runnable {

   // private static Logger logger = LoggerFactory.getLogger(TempGenerator.class);

    /**
     * CONSTANTS
     */
    private static final int MINUTES_IN_DAY = 24 * 60;
    private static final int DAY_IN_YEAR = 365;

    /**
     * Step, in minutes, between to generations (how far forward in the day the next generation will concern)
     */
    private static int STEP = 70;

    /**
     * Singleton
     */
    private static TempGenerator INSTANCE;

    /**
     * Listeners
     */
    private List<TempListener> listeners = new ArrayList<TempListener>();

    /**
     * Thread executor
     */
    private ScheduledExecutorService schedulingService;

    /**
     * Sleeping period of the threads (delay between two generations)
     */
    private long period = 2000;
    private int currentDay= 0, currentMinutes = 0;

    private TempGenerator() {
        /**
         * Starts the generation as soon as the instance is constructed
         */

    }

    public static TempProvider getInstance() {
        /**
         * Singleton pattern, creates the instance if it does not already exists.
         */
        if(INSTANCE == null) {
            INSTANCE = new TempGenerator();
        }
        return INSTANCE;
    }

    @Override
    public void registerTempListener(TempListener listener) {
        listeners.add(listener);
        if(listeners.size()!=0)
        {
            schedulingService = Executors.newSingleThreadScheduledExecutor();
            schedulingService.scheduleWithFixedDelay(this,period,period, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public void unregisterTempListener(TempListener listener) {
        listeners.remove(listener);
        if(listeners.size()==0)
        {
            schedulingService.shutdownNow();
        }
    }

    /**
     * Changes the delay between to generations
     * @param periodInMillis the delay between two generations, in Milliseconds
     */
    @Override
    public void setSensingPeriod(long periodInMillis) {

        if(periodInMillis > 0) {// If the value is valid
            period = periodInMillis;
            schedulingService.shutdown(); // shutdowns the current generation thread
            schedulingService = Executors.newSingleThreadScheduledExecutor();
            //starts a new one with the new delay
            schedulingService.scheduleWithFixedDelay(this,period,period, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * Generates a temp value for the asked time of the day
     * @param minute the minute of the day
     * @param moyenneJour the average temp value for this day (see #tempMoyPerDay)
     * @param amplitude the maximum difference between min and max values over the day
     * @return a generated value for the temp of this minute
     */
    private double tempPerMinute(int minute, double moyenneJour, int amplitude) {
        double decalagePhase = Math.PI / 6d;
        return moyenneJour + ((amplitude / 2) * (-Math.sin((minute * ((2 * Math.PI) / MINUTES_IN_DAY)) + decalagePhase)));
    }

    /**
     * Generates an average value for the day.
     * @param day the day of the year
     * @param moyenneAnnee the average temp over the year
     * @param amplitude the maximum difference between min and max values over the year
     * @return a generated double value
     */
    private double tempMoyPerDay(int day, int moyenneAnnee, int amplitude) {
        double decalagePhase = Math.PI / 6d;
        return moyenneAnnee + ((amplitude / 2) * (-Math.sin((day * ((2 * Math.PI) / DAY_IN_YEAR)) + decalagePhase)));
    }

    public void run(){

        // computes a value for the temp of the current day (average temp over the year: 15, max diff between min and max: 25)
        double dayAverage = tempMoyPerDay(currentDay, 15, 25);
        int amplitude = (int) (8 + (Math.random() * 5));
        // computes a value for the temp of the current minute, with an amplitude between 8 and 13.
        float value = (float)tempPerMinute(currentMinutes, dayAverage, amplitude);

        // Goes forward in the year :-)
        if(currentMinutes + STEP >= MINUTES_IN_DAY) {
            currentDay = (++currentDay % DAY_IN_YEAR);
        }
        currentMinutes = (currentMinutes + STEP) % MINUTES_IN_DAY;

        //creates the tempRecord
        TempRecord record = new TempRecord();
        record.setDayNumber(currentDay);
        record.setHour(currentMinutes);
        record.setTempValue(value);

     //   logger.debug("Generated: " + record.getTempValue() + " Listsners:" + listeners.size());

        //Gives the temp record to the registered listeners
        for(TempListener l : listeners) {
            l.temperatureUpdated(record);
        }
    }



}
