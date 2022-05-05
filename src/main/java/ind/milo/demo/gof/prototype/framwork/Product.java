package ind.milo.demo.gof.prototype.framwork;

public interface Product extends Cloneable{
    public abstract void use(String s);
    public abstract Product createClone();
}
