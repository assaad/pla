package lu.snt.serval.pla.blurring;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 06/12/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/



//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
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
    private  int step = 5;


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
    private Date initDate;



    private int currentDay= 0, currentMinutes = 0;

    public TempGenerator() {
        /**
         * Starts the generation as soon as the instance is constructed
         */
        initDate=new Date();


    }

    public void setStep(int step) {
        this.step = step;
    }


    public void setTime (int startingDate)
    {
        initDate.setTime(initDate.getTime()-startingDate*24*60*60*1000);
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
     * Generates a temp value for the asked period of the day
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
        double value = tempPerMinute(currentMinutes, dayAverage, amplitude);

        // Goes forward in the year :-)
        if(currentMinutes + step >= MINUTES_IN_DAY) {
            currentDay = (++currentDay % DAY_IN_YEAR);
        }
        currentMinutes = (currentMinutes + step) % MINUTES_IN_DAY;

        //creates the tempRecord

        Date now = new Date();
        now.setTime(initDate.getTime()+  currentDay* 24 * 60 * 60 * 1000+  currentMinutes* 60 * 1000);

      /*  record.setDayNumber(currentDay);
        record.setHour(currentMinutes);  */
        SensorValue s = new SensorValue();

        s.setTime(now.getTime());
        s.setValue(value);


        //record.setName("Temperature");
        //record.setLocation(location);

     //   logger.debug("Generated: " + record.getTempValue() + " Listsners:" + listeners.size());

        //Gives the temp record to the registered listeners
        for(TempListener l : listeners) {
            l.temperatureUpdated(s);
        }
    }



}
