package work.icql.icm.product.b.server.designpattern.behavioral.chain.linked;

public abstract class Handler {

    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle(Object o) {
        boolean handled = doHandle(o);
        if (successor != null && !handled) {
            successor.handle(o);
        }
    }

    protected abstract boolean doHandle(Object o);
}