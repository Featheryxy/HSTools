package ind.milo.scenes;

public class SqlBuautifier {
//    private
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("select * from ( \n");
        String tabName = "tbtrustsharechg";
        for (int i = 1; i <= 16; i++) {
            stringBuilder.append("select * from ").append(tabName).append(i).append("\n");
            if (i !=16) {
                stringBuilder.append("union all\n");
            }
        }
        stringBuilder.append(") t;");
        System.out.println(stringBuilder);
    }
}
