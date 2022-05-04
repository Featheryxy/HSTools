package ind.milo.demo.gof.iterator;

/**
 * 迭代器具有的行为
 */
public interface Iterator {
    public abstract boolean hasNext();
    public abstract Object next();
}
