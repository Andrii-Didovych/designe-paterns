public class FactoryMethod {
    public static void main(String[] args) {
        Person person = Person.create();
        System.out.println(person);

        person.setName("Bill");
        System.out.println(person.getName());

        Person person1 = Person.create();
        System.out.println(person1.getName());
    }
}

class Person {

    private String name;

//    factory method
    public static Person create() {
        return new Person();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
