package ind.milo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegUtil {
    private String pattern;
    private static Logger logger = LoggerFactory.getLogger(RegUtil.class);
    private static final String versionPat = "^B?TA6.0V.{13}$";
    private static final String requirePat = "^\\d{12}$";
    private static  final String mdfPat = "^M\\d{12}$";
    private static final String [] SubmitInfoRexPatArr = new String[] {versionPat, requirePat, mdfPat};

    private static final String versionDesc = "[当前可提交版本] ";
    private static final String requireDesc = "[需求编号] ";
    private static final String mdfDesc = "[修改单编号] ";
    private static final String mdfReason = "[修改原因] ";
    private static final String [] SubmitInfoArr = new String[]{versionDesc, requireDesc, mdfDesc, mdfReason};

    private RegUtil() {

    }

    /**
     * 在文本中查找满足正则表达式的子字符串
     *
     * @param pat
     *        正则表达式
     * @param input
     *        文本
     * @return 满足正则表达式的子字符串，若没有，返回空字符串
     */
    public static String findRex(String pat, String input){
        logger.debug("正则表达式: {}, 文本:{}", pat, input);
        Pattern pattern = Pattern.compile(pat, Pattern.DOTALL | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            logger.debug("结果: {}", matcher.group());
            return matcher.group();
        }
        logger.debug("结果: {}", "");
        return "";
    }

    public static String findRex(String pat, String input, int group){
        logger.debug("正则表达式: {}, 文本:{}", pat, input);
        Pattern pattern = Pattern.compile(pat, Pattern.DOTALL | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            logger.debug("结果: {}", matcher.group());
            return matcher.group(group);
        }
        logger.debug("结果: {}", "");
        return "";
    }


    // 在文本中查找满足正则表达式的子字符串
    public static String getSubmitInfo(String input, String reason) {

        String mdfNumber = "MMMMMMMMMM";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < SubmitInfoRexPatArr.length; i++) {
            String rex = findRex(SubmitInfoRexPatArr[i], input);

            if (i == 2) {
                mdfNumber = rex;
            }
            if (rex.length() != 0) {
                stringBuilder.append(SubmitInfoArr[i]).append(rex).append("\n");
            } else {
                stringBuilder.append(SubmitInfoArr[i]).append("\n");
            }
        }
        stringBuilder.append(SubmitInfoArr[SubmitInfoArr.length-1]).append(reason);


        Date date = new Date();
        // 日期yyyyMMdd中的MM一定要大写，否则会认为是分钟mm
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String todayDate = formatter.format(date);

        stringBuilder.append("\n\n\n");

        StringBuilder temStr = new StringBuilder();
        // todo 工号改成配置
        if (reason.trim().length() == 0){
            reason = "修改原因";
        }
        stringBuilder.append("【涉及子系统】：信托\n" +
                "【功能入口】： \n" +
                "【测试准备】： \n" +
                "【测试场景及预期结果】： \n" +
                "     \n" +
                "【影响范围】： \n" +
                "【单元测试数据库】： \n" +
                "【是否增值业务】： \n" +
                "【是否个性化】：");
        stringBuilder.append("\n\n");


        temStr.append("/* ").append(todayDate).append(" yexy34716 ").append(mdfNumber).append(" ").append(reason);

        stringBuilder.append(temStr).append(" beg */");
        stringBuilder.append("\n");
        stringBuilder.append(temStr).append(" end */");

        
        return stringBuilder.toString();
    }
}
