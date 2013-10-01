package lu.snt.serval.pla.framework;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 10/09/13
 * Time: 12:00
 * To change this template use File | Settings | File Templates.
 */
public class Answer {
    private Query query;
    private AnswerBody answerBody;

    public Answer(Query query, AnswerBody answerBody) {
        this.answerBody = answerBody;
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }

    public AnswerBody getAnswerBody() {
        return answerBody;
    }
}
