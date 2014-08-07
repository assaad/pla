
class pla.Domain  {
    name : java.lang.String
    @contained
    sensors : pla.SensorKind[0,*]
    @contained
    blurrings : pla.Blurring[0,*]
    @contained
    architecture : pla.Architecture
}

class pla.SensorKind  {
    @id
    id : java.lang.String
    type : java.lang.String
    @contained
    risks : pla.Risk[0,*] oppositeOf sensors
}

class pla.Blurring  {
    name : java.lang.String
    paramName : java.lang.String
    paramValue : java.lang.Double
    paramMin : java.lang.Double
    paramMax : java.lang.Double
    isDouble : java.lang.Boolean
    execTimeMin : Integer
    execTimeMax : Integer
    utilMin : java.lang.Double
    utilMax : java.lang.Double
}

class pla.Architecture  {
    @contained
    chains : pla.Chain[0,*]
}

class pla.Risk  {
    @id
    id : String
    description : String
    weight : Integer
    sensors : pla.SensorKind[0,*] oppositeOf risks
    @contained
    counterMeasures : pla.CounterMeasure[0,*] oppositeOf risk
}

class pla.CounterMeasure  {
    @id
    id : String
    description : String
    risk : pla.Risk oppositeOf counterMeasures
    blurring : pla.Blurring
    @contained
    setting : pla.RiskReductionProfile
}

class pla.RiskReductionProfile  {
    paramName : String
    paramValue0 : Double
    impact0 : Double
    paramValue1 : Double
    impact1 : Double
    profile : pla.Profile
}

class pla.Chain  {
    sensor : pla.SensorKind
    blurringList : pla.Blurring[0,*]
}
