package ind.milo.demo.gof.proxy;

/**
 * 本人
 * Printer类不知道 PrinterProxy类 的存在
 * 即 Printer类 并不知道自己时通过PrinterProxy被调用的还是直接被调用的
 */
public class Printer implements Printable {
    private String name;

    // 制造本人忙碌的情景
    public Printer() {
        heavyJob("正在生成Printer的实例");
    }

    public Printer(String name) {
        this.name = name;
        heavyJob(String.format("正在生成Printer的实例 %s", name));
    }

    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println("End");
    }

    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return this.name;
    }

    @Override
    public void print(String string) {
        System.out.println(String.format("=== %s ===", name));
        System.out.println(string);
    }
}
