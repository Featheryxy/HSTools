package ind.milo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class StringUtil {
    private static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    private StringUtil() {

    }

    public static String cleanData(String input) {
        logger.debug("0. 文本输入: %s", input);
        // 1. 将换行符替换为空格字符串
        input = input.replaceAll("\n", " ");
        logger.debug("1. 将换行符替换为空格字符串: %s", input);
        // 2. 删除多余的空格字符串
        input = input.replaceAll("\\s+", " ");
        logger.debug("2. 删除多余的空格字符串: %s", input);
        // 3. 小写
        input = input.toLowerCase(Locale.ROOT);

        return input;
    }
}
