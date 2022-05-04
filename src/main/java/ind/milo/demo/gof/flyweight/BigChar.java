package ind.milo.demo.gof.flyweight;

import ind.milo.util.NIOUtil;

public class BigChar {
    private char charname;
    private String fontdate;

    public BigChar(char charName) {
        String path = "F:\\JavaFX\\HSTools\\src\\main\\java\\ind\\milo\\gof\\flyweight\\bigchar\\";
        String file = path+"big" + charName + ".txt";
        fontdate = NIOUtil.read(file);
    }

    public void print() {
        System.out.print(fontdate);
    }

    public static void main(String[] args) {
        BigChar bigChar = new BigChar('0');
        bigChar.print();
    }
}
