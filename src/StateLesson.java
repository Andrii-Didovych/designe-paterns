public class StateLesson {
    public static void main(String[] args) {
        Context context = new Context("John", new LowerCaseState());
        context.doAction();
        context.setStatus(new UpperCaseState());
        context.doAction();

    }
}

interface State {
    void doAction(Context context);
}

class LowerCaseState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toLowerCase());
    }
}

class UpperCaseState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toUpperCase());
    }
}

class Context {
     String name;
     State state;

    public Context(String name, State state) {
        this.name = name;
        this.state = state;
    }

    void setStatus(State state) {
        this.state = state;
    }

    void doAction() {
        state.doAction(this);
    }
}
