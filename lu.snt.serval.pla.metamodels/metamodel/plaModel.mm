
class pla.Domain  {
    name : String
    @contained
    sensors : pla.SensorKind[0,*]
    @contained
    blurrings : pla.Blurring[0,*]
    @contained
    architecture : pla.Architecture
}

class pla.SensorKind  {
    @id
    id : String
    type : String
    @contained
    risks : pla.Risk[0,*] oppositeOf sensors
}

class pla.Risk  {
    @id
    id : String
    description : String
    weight : Int
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

class pla.Blurring  {
    name : String
    paramName : String
    paramValue : Double
    paramMin : Double
    paramMax : Double
    isDouble : Bool
    execTimeMin : Int
    execTimeMax : Int
    utilMin : Double
    utilMax : Double
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

class pla.Architecture  {
    @contained
    chains : pla.Chain[0,*]
}
