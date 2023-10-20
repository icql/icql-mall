package work.icql.icm.product.b.server.designpattern.behavioral.command;

public class GotDiamondCommand implements Command {

    /**
     * 数据
     */
    private Object object;

    public GotDiamondCommand(Object o) {
        this.object = o;
    }

    @Override
    public void execute() {
        //执行具体的逻辑
    }
}
