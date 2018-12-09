public class CommandLesson {
    public static void main(String[] args) {
        Invoker click = new Invoker(new MouseClick());
        Invoker roll = new Invoker(new MouseRoll());
        click.run();
        roll.run();
    }
}

interface Command {
    void execute();
}

class MouseClick implements Command {
    @Override
    public void execute() {
        System.out.println("Click mouse");
    }
}

class MouseRoll implements Command {

    @Override
    public void execute() {
        System.out.println("Roll mouse");
    }
}

class Invoker {
    Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    void run() {
        command.execute();
    }
}
