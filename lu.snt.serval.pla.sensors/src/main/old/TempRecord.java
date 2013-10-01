package lu.snt.serval.pla.sensors;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 06/12/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/

public class TempRecord {

    private int dayNumber;
    private int hour;
    private float tempValue;
    private String level;
    //private Direction orientation;

    public TempRecord(){}

    public TempRecord(TempRecord source) {
        dayNumber = source.getDayNumber();
        hour = source.getHour();
        tempValue = source.getTempValue();
        level = source.getLevel();
     //   orientation = source.getOrientation();
    }


    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public float getTempValue() {
        return tempValue;
    }

    public void setTempValue(float tempValue) {
        this.tempValue = tempValue;
    }


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String print()
    {
        String s="";
        s="Day: "+ dayNumber + " Hour: "  +hour+ " Value: "+ tempValue+ " Level: "+level;
        return s;
    }

  /*  public Direction getOrientation() {
        return orientation;
    }

    public void setOrientation(Direction orientation) {
        this.orientation = orientation;
    }      */
}
