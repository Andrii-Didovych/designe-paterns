public class TemplateLesson {
    public static void main(String[] args) {
        Game poker = new Poker();
        poker.run();
        Footbull footbull = new Footbull();
        footbull.run();
    }
}

abstract class Game {
    abstract void start();
    abstract void play();
    abstract void finish();

    void run() {
        start();
        play();
        finish();
    }
}

class Poker extends Game{

    @Override
    void start() {
        System.out.println("get cards");
    }

    @Override
    void play() {
        System.out.println("play");
    }

    @Override
    void finish() {
        System.out.println("loos money");
    }
}

class Footbull extends Game {

    @Override
    void start() {
        System.out.println("Start game");
    }

    @Override
    void play() {
        System.out.println("Play for 45m");
    }

    @Override
    void finish() {
        System.out.println("finish the game");
    }
}
