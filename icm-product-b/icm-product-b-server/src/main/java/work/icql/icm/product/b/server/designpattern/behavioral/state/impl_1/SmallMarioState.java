package work.icql.icm.product.b.server.designpattern.behavioral.state.impl_1;

/**
 * 小马里奥
 */
public class SmallMarioState implements IMarioState {

    private MarioStateMachineContext stateMachine;

    public SmallMarioState(MarioStateMachineContext stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void obtainMushRoom() {
        stateMachine.setCurrentState(new SuperMarioState(stateMachine));
        stateMachine.setScore(stateMachine.getScore() + 100);
    }

    @Override
    public void obtainFireFlower() {

    }

    @Override
    public void meetMonster() {

    }
}
