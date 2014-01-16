package lu.snt.serval.pla.blurring;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 06/12/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/

public interface TempProvider {
    void setSensingPeriod(long periodInMillis);
    void registerTempListener(TempListener listener);
    void unregisterTempListener(TempListener listener);
    void setTime(int day);
    void setStep(int step);
}
