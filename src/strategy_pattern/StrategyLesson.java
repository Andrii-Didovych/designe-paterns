package strategy_pattern;

import java.util.ArrayList;
import java.util.List;

public class StrategyLesson {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234", 24);
        Item item2 = new Item("3456", 54);
        Item item3 = new Item("6788", 278);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);

        cart.pay(new CreditCardStrategy("Andrii Didovych", "1234 5678 234 4567", "345", "12/11"));

        cart.pay(new PaypalStrategy("andrii.didovych@mail.ua","1234578"));
    }
}

interface PaymentStrategy {
    void pay(double price);
}

class CreditCardStrategy implements PaymentStrategy{

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
        this.name=nm;
        this.cardNumber=ccNum;
        this.cvv=cvv;
        this.dateOfExpiry=expiryDate;
    }

    @Override
    public void pay(double price) {
        System.out.println(price+" paid with credit card");
    }
}

class PaypalStrategy implements PaymentStrategy {

    private String emailId;
    private String password;

    public PaypalStrategy(String email, String pwd){
        this.emailId=email;
        this.password=pwd;
    }

    @Override
    public void pay(double price) {
        System.out.println(price + " paid with Paypal");
    }
}

class Item {

    private String upcCode;
    private int price;

    public Item(String upc, int cost){
        this.upcCode=upc;
        this.price=cost;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public int getPrice() {
        return price;
    }
}

class ShoppingCart {

    //List of items
    List<Item> items;

    public ShoppingCart(){
        this.items=new ArrayList<Item>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public int calculateTotal(){
        int sum = 0;
        for(Item item : items){
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentMethod){
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}