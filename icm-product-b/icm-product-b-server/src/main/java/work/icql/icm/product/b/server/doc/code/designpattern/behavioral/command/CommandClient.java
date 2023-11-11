package work.icql.icm.product.b.server.doc.code.designpattern.behavioral.command;

import java.util.LinkedList;
import java.util.Queue;

public class CommandClient {

    private static final Queue<Command> QUEUE = new LinkedList<>();

    public static void main(String[] args) {

        Command gotDiamondCommand = new GotDiamondCommand(new Object());
        QUEUE.add(gotDiamondCommand);
        Command gotStartCommand = new GotStartCommand(new Object());
        QUEUE.add(gotStartCommand);
        for (Command command : QUEUE) {
            command.execute();
        }
    }
}
