package lu.snt.serval.pla.framework.sensors;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 06/12/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/

public interface TempProvider {
    void setSensingPeriod(long periodInMillis);
    void setLocation(String location);
    void registerTempListener(TempListener listener);
    void unregisterTempListener(TempListener listener);
    void setTime(int day);
}
