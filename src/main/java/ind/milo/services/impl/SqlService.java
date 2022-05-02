package ind.milo.services.impl;

import ind.milo.services.iterfaces.ISqlService;
import ind.milo.util.RegUtil;
import ind.milo.util.StringUtil;

public class SqlService implements ISqlService {

    @Override
    public String getSqlByPat(String pat, String input) {
        String cleanData = StringUtil.cleanData(input);
//        String pat = "(当前SQL:)(.*)(当前参数:)(.*)";

        String resut1 = RegUtil.findRex(pat, cleanData, 2);
        String resut2 = RegUtil.findRex(pat, cleanData, 4);

        String[] split = resut2.split(",");
        String replacemet;
        for (int i = 0; i < split.length; i++) {
            replacemet = "'"+split[i].trim()+"'";
            resut1 = resut1.replaceFirst("\\?", replacemet);
        }

        return resut1;
    }
}
