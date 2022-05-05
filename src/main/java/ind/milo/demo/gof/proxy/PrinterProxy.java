package ind.milo.demo.gof.proxy;

// 代理人
public class PrinterProxy implements Printable{
    private String name; // 代理人名字
    private Printer real; // 本人

    public PrinterProxy() {

    }

    public PrinterProxy(String name) {
        this.name = name;
    }

    @Override
    public synchronized void setPrinterName(String name) {
        // 当本人存在时，同时为本人和代理人设置姓名
        if (real != null) {
            real.setPrinterName(name);
        }
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    // 超出代理人工作范围，唤醒本人
    @Override
    public void print(String string) {
        realize();
        real.print(string); // 委托
    }

    private synchronized void realize() {
        if (real == null) {
            real = new Printer(name);
        }
    }

}
