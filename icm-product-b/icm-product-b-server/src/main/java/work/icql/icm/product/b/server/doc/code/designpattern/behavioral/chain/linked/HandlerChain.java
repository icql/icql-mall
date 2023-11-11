package work.icql.icm.product.b.server.doc.code.designpattern.behavioral.chain.linked;

public class HandlerChain {

    private Handler head = null;
    private Handler tail = null;

    public void addHandler(Handler handler) {
        handler.setSuccessor(null);
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle(Object o) {
        if (head != null) {
            head.handle(o);
        }
    }
}