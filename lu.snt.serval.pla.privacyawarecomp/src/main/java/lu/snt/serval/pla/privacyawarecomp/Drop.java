package lu.snt.serval.pla.privacyawarecomp;

import lu.snt.serval.pla.model.Answer;
import lu.snt.serval.pla.model.Query;

/**
 * Created with IntelliJ IDEA.
 * User: assaad.moawad
 * Date: 11/09/13
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 */
public class Drop {
    // Message sent from producer
    // to consumer.
    private Query message;
    // True if consumer should wait
    // for producer to send message,
    // false if producer should wait for
    // consumer to retrieve message.
    private boolean empty = true;

    public synchronized Query take() {
        // Wait until message is
        // available.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        // Toggle status.
        empty = true;
        // Notify producer that
        // status has changed.
        notifyAll();
        return message;
    }

    public synchronized void put(Query message) {
        // Wait until message has
        // been retrieved.
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        // Toggle status.
        empty = false;
        // Store message.
        this.message = message;
        // Notify consumer that status
        // has changed.
        notifyAll();
    }
}
