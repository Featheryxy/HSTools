package ind.milo.demo.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Date 2022/12/13 13:24
 * @Created by Milo
 */
public class RegxDemo {
    public static void main(String[] args) {
        // group：将一个正则表达式分成多个group, group(0)为匹配到的字符
        // groupCount()不包含group(0)，
        String regex = "(\\d{3})(\\d{3})(\\d{4})";

        // 通过Pattern类的静态方法static Pattern.compile() 编译正则表达式，
        // 利用Pattern的*matcher()*方法生产Matcher对象。根据Matcher对象提供的API完成相应的操作
        Pattern p = Pattern.compile(regex);
        String source = "1234567890, 12345,  and  9876543210";

        Matcher m = p.matcher(source);

        while (m.find()) {
            int i = m.groupCount();
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < i+1; j++) {
                stringBuilder.append(j).append(": ").append(m.group(j)).append("\t");
            }
            System.out.println(stringBuilder);
        }
        // 0: 1234567890	1: 123	2: 456	3: 7890
        // 0: 9876543210	1: 987	2: 654	3: 3210

    }
}
