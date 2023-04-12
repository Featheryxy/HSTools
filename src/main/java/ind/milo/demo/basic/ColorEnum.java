package ind.milo.demo.basic;

/**
 * @Date 2023/4/12 14:46
 * @Created by Milo
 */
public enum ColorEnum {
    red("红色"),
    yellow("黄色"),
    blue("蓝色");

    private String comment;
    ColorEnum(String comment){
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ColorEnum{" +
                "comment='" + comment + '\'' +
                '}';
    }

    public static void main(String[] args) {
        for (ColorEnum tmp : ColorEnum.values()) {
            System.out.println(tmp.name()+" "+tmp.ordinal()+" "+ tmp.comment);
        }
    }
}
