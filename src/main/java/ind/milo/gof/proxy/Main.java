package ind.milo.gof.proxy;

public class Main {
    public static void main(String[] args) {
        Printable printable = new PrinterProxy("Alice");
        System.out.println(String.format("现在的名字是 %s", printable.getPrinterName()));
        printable.setPrinterName("Bob");
        System.out.println(String.format("现在的名字是 %s", printable.getPrinterName()));
        printable.print("Hello, world");
    }
}
