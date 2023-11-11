package work.icql.icm.product.b.server.doc.code.designpattern.behavioral.chain.array;

import java.util.ArrayList;
import java.util.List;

public class HandlerChain {

    private List<IHandler> handlers = new ArrayList<>();

    public void addHandler(IHandler handler) {
        this.handlers.add(handler);
    }

    public void handle(Object o) {
        for (IHandler handler : handlers) {
            boolean handled = handler.handle(o);
            if (handled) {
                break;
            }
        }
    }
}