package lu.snt.serval.pla.framework.sensors;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 06/12/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/


import lu.snt.serval.pla.model.TempRecord;

public interface TempListener {
    void temperatureUpdated(TempRecord record);

}
