package ind.milo.demo.generate;


/**
 * @Date 2023/2/3 14:53
 * @Created by Milo
 */
class Test {
    public static void main(String[] args) {
        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);
        show(gNumber);
        show(gInteger);
    }

    public static void show(Generic<?> generic){
        System.out.println(generic.getT());
    }


}
