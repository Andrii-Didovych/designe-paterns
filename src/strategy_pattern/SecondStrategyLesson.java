package strategy_pattern;

public class SecondStrategyLesson {
    public static void main(String[] args) {
        Strategy strategy = new Strategy(new ChipPrice());
        strategy.price(45);
    }
}

interface PriceStrategy {
    double getPrice(double price);
}

class FullPrice implements PriceStrategy {
    @Override
    public double getPrice(double price) {
        return price;
    }
}

class ChipPrice implements PriceStrategy {
    @Override
    public double getPrice(double price) {
        return price * 0.5;
    }
}

class Strategy {
    private PriceStrategy priceStrategy;

    public Strategy(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public void price(double price) {
        System.out.println("Price - "+priceStrategy.getPrice(price));
    }
}