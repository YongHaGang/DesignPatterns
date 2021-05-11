public class StatePatternExample {
    public static void main(String[] args) {

        Bird bird = new Bird();
        bird.setState(Bird.BirdState.SLEEP);
        bird.fly();
        bird.run();
        bird.setState(Bird.BirdState.AWAKE);
        bird.fly();
        bird.run();

    }
}

class Bird {
    BirdState state;
    enum BirdState {
        AWAKE(new Awake()),
        SLEEP(new Sleep());
        private State state;
        BirdState(State state) {
            this.state = state;
        }

        public State getState() {
            return state;
        }
    }

    public void setState(BirdState state) {
        this.state = state;
    }

    public void fly() {
        state.getState().fly();
    }

    public void run() {
        state.getState().run();
    }

}

interface State {
    void fly();
    void run();
}

class Sleep implements State {

    @Override
    public void fly() {
        System.out.println("can not fly");
    }

    @Override
    public void run() {
        System.out.println("can not run");
    }
}

class Awake implements State {

    @Override
    public void fly() {
        System.out.println("fly");
    }

    @Override
    public void run() {
        System.out.println("run");
    }
}
