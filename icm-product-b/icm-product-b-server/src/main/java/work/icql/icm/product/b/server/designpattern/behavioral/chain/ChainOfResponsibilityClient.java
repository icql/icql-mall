package work.icql.icm.product.b.server.designpattern.behavioral.chain;

import work.icql.java.designpattern.behavioral.chain.array.HandlerA;
import work.icql.java.designpattern.behavioral.chain.array.HandlerB;
import work.icql.java.designpattern.behavioral.chain.array.HandlerChain;

/**
 * 职责链模式
 * 2种实现方式：链表和数组，数组相对简单易用
 */
public class ChainOfResponsibilityClient {

    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle(new Object());
    }
}