package lu.snt.serval.kmf;
import org.kevoree.modeling.api.aspect;
public aspect trait GeneratedAspect_TempRecord : lu.snt.serval.pla.model.TempRecord {
	override fun print() : String {
        var s : String = ""
        s = "Date: " + dateTime?.toString() + " Temperature: " + value
        return s;
	}
}
