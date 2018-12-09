public class ChainOfResponsibilityLesson {
    public static void main(String[] args) {
        MessagePrinter consoleMessagePrinter = new ConsoleMessagePrinter();
        FileMessagePrinter fileMessagePrinter = new FileMessagePrinter();
        DbMessagePrinter dbMessagePrinter = new DbMessagePrinter();

        consoleMessagePrinter.setNextMessagePrinter(fileMessagePrinter);
        fileMessagePrinter.setNextMessagePrinter(dbMessagePrinter);

        consoleMessagePrinter.print(" Test");
    }
}

abstract class MessagePrinter {
    MessagePrinter nextMessagePrinter;

    void setNextMessagePrinter(MessagePrinter messagePrinter) {
        nextMessagePrinter = messagePrinter;
    }

    void print(String message) {
        printMessage(message);
        if (nextMessagePrinter != null) {
            nextMessagePrinter.print(message);
        }
    }

    abstract void printMessage(String msg);
}

class ConsoleMessagePrinter extends MessagePrinter {

    @Override
    void printMessage(String msg) {
        System.out.println("Hello from console" + msg);
    }
}

class DbMessagePrinter extends MessagePrinter {
    @Override
    void printMessage(String msg) {
        System.out.println("Hello from db" + msg);

    }
}

class FileMessagePrinter extends MessagePrinter {

    @Override
    void printMessage(String msg) {
        System.out.println("Hello from file"  + msg);
    }
}
