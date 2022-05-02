package ind.milo.gof.singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("Begin");
        Singleton obj1 = Singleton.getSingleton();
        Singleton obj2 = Singleton.getSingleton();
        if(obj1 == obj2){
            System.out.println("obj1 == obj2");
        }else {
            System.out.println("obj1 <> obj2");
        }
        System.out.println("End.");
    }
}
