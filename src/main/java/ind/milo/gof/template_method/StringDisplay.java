package ind.milo.gof.template_method;

public class StringDisplay extends AbstractDisplay{
    private String string;
    private int width;
    public StringDisplay(String string){
        this.string = string;
        this.width = string.getBytes().length;
    }

    @Override
    public void open() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i<width; i++){
            System.out.print("-");
        }
        System.out.println("+");
    }

    @Override
    public void print() {
        System.out.println("|"+string+"|");
    }

    @Override
    public void close() {
        printLine();
    }
}
