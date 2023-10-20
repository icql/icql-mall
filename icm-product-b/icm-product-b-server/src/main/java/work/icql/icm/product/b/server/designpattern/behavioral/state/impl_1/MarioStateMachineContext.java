package work.icql.icm.product.b.server.designpattern.behavioral.state.impl_1;

public class MarioStateMachineContext implements IMarioState {

    private int score;

    private IMarioState currentState;

    public MarioStateMachineContext() {
        this.score = 0;
        this.currentState = new SmallMarioState(this);
    }

    public MarioStateMachineContext(IMarioState currentState) {
        this.score = 0;
        this.currentState = currentState;
    }

    public int getScore() {
        return this.score;
    }

    public IMarioState getCurrentState() {
        return this.currentState;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentState(IMarioState currentState) {
        this.currentState = currentState;
    }


    @Override
    public void obtainMushRoom() {
        this.currentState.obtainMushRoom();
    }

    @Override
    public void obtainFireFlower() {
        this.currentState.obtainFireFlower();
    }

    @Override
    public void meetMonster() {
        this.currentState.meetMonster();
    }
}
