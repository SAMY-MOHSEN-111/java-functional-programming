package finalSection;

import java.util.function.Consumer;

public class CallBacks {
    public static void main(String[] args) {
        hello("samy", null, str -> System.out.printf("No last name was provided for %s%n", str));
        hello2("samy", null, () -> System.out.println("No last name provided"));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (!(lastName == null)) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (!(lastName == null)) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
    /*function hello(firstName,lastName,callback){
        console.log(firstName);
        if(lastName){
            console.log(lastName);
        }else{
            callback();
        }
    }*/
}
