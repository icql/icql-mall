package work.icql.icm.product.b.server.designpattern.behavioral.state.impl_1;

public class FireMarioState implements IMarioState {

    private MarioStateMachineContext stateMachine;

    public FireMarioState(MarioStateMachineContext stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void obtainMushRoom() {

    }

    @Override
    public void obtainFireFlower() {

    }

    @Override
    public void meetMonster() {

    }
}
