package ind.milo.demo.gof.chain_of_responsibility;

public class NoSupport extends Support {
    public NoSupport(String name){
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
