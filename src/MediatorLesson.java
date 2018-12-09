import java.util.ArrayList;
import java.util.List;

public class MediatorLesson {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();
        User user1 = new UserImpl(mediator, "John");
        User user2 = new UserImpl(mediator, "Bill");
        User user3 = new UserImpl(mediator, "Fill");
        User user4 = new UserImpl(mediator, "Stew");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);

        user1.send("Hello guys!");

    }
}

interface ChatMediator {
    void sendMessage(String msg, User user);

    void addUser(User user);
}

abstract class User {
    ChatMediator mediator;
    String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    abstract void send(String msg);

    abstract void receive(String msg);
}

class ChatMediatorImpl implements ChatMediator {

    List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, User user) {
        for (User u: users) {
            if (u!=user) u.receive(msg);
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

}

class UserImpl extends User {

    public UserImpl(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    void send(String msg) {
        System.out.println(this.name+" sent a message: "+msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    void receive(String msg) {
        System.out.println(this.name+" receive a message: "+msg);
    }
}