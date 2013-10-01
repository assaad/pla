package lu.snt.serval.pla.framework;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 11/09/13
 * Time: 18:06
 * To change this template use File | Settings | File Templates.
 */
public class AnswerDataType extends AnswerBody {
    public Object getAnswer() {
        return answer;
    }

    Object answer;

    AnswerDataType(Object answer )
    {
        this.answer=answer;
    }

}
