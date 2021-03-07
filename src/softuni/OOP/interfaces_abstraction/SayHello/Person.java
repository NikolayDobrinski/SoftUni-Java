package softuni.OOP.interfaces_abstraction.SayHello;

public interface Person {

    String getName();

    default String sayHello() {
        return "Hello";
    };



}
