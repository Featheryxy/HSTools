package ind.milo.demo.basic;

/**
 * @Date 2022/11/8 17:21
 * @Created by Milo
 */
public class SwithcDemo {
    public static void main(String[] args) {
        String ch = "H";
        switch (ch) {
            case "H":
                System.out.println("Hello");
            case "g":
            case "G":
                System.out.println("Good morning");
            default:
                System.out.println("Bye_Bye");
        }
        //Hello
        //Good morning
        //Bye_Bye
    }
}
