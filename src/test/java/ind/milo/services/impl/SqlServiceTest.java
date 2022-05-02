package ind.milo.services.impl;

import ind.milo.util.RegUtil;
import org.junit.jupiter.api.Test;

class SqlServiceTest {

    @Test
    void getSqlByPat() {
        String pat = "(当前SQL:)(.*)(当前参数:)(.*)";
        String input = "SQL执行错误,当前SQL:insert into tbtrusttasharedtlexp (ta_code,use_vol, tot_vol, cfm_date, prd_code, branch_no, cfm_no, back_fee, share_class, detail_flag, account_status, register_date, income_onway, incomeonway_flag, guaranteed_amount, source_type, div_mode, allow_red_date ) SELECT ?,        b.tot_vol-b.frozen_vol use_vol,         b.tot_vol,         ? cfm_date,         b.prd_code,         b.ta_client,         b.seller_code,         b.asset_acc,         b.frozen_vol,         b.seller_code branch_no,         b.cfm_no,         0 back_fee,         'A' share_class,         '1' detail_flag,         ' ' account_status,         b.regist_date register_date,         b.income_onway income_onway,         '0' incomeonway_flag,         0 guaranteed_amount,         b.source_flag source_type,         b.div_mode,         b.allow_red_date       FROM (select  * from tbtrustshare1   union all select  * from tbtrustshare2  union all select  * from tbtrustshare3  union all select  * from tbtrustshare4  union all select  * from tbtrustshare5  union all select  * from tbtrustshare6  union all select  * from tbtrustshare7  union all select  * from tbtrustshare8  union all select  * from tbtrustshare9  union all select  * from tbtrustshare10  union all select  * from tbtrustshare11  union all select  * from tbtrustshare12  union all select  * from tbtrustshare13  union all select  * from tbtrustshare14  union all select  * from tbtrustshare15  union all select  * from tbtrustshare16 ) a , (select  * from tbtrustsharedetail1   union all select  * from tbtrustsharedetail2  union all select  * from tbtrustsharedetail3  union all select  * from tbtrustsharedetail4  union all select  * from tbtrustsharedetail5  union all select  * from tbtrustsharedetail6  union all select  * from tbtrustsharedetail7  union all select  * from tbtrustsharedetail8  union all select  * from tbtrustsharedetail9  union all select  * from tbtrustsharedetail10  union all select  * from tbtrustsharedetail11  union all select  * from tbtrustsharedetail12  union all select  * from tbtrustsharedetail13  union all select  * from tbtrustsharedetail14  union all select  * from tbtrustsharedetail15  union all select  * from tbtrustsharedetail16) b       WHERE a.c_agencyno = ?              and a.c_fundcode=?             and a.contract_no = b.contract_no             and (                  ( 0 = '0'                     and (( a.tot_vol>0 AND (case when a.last_date = 0 then a.last_exp_date else a.last_date end) < = ? )                         or (a.tot_vol=0 AND (case when a.last_date = 0 then a.last_exp_date else a.last_date end) = ? ))                   )                   or 0 = '1' and (case when a.last_date = 0 then a.last_exp_date else a.last_date end) = ?                 )   当前参数:XT60,20220314,400,jzdx01,20220314,20220314,20220314\n";

        // 1. 将换行符替换为空格字符串
        input = input.replaceAll("\n", " ");
        System.out.println(input);
        // 2. 删除多余的空格字符串
        input = input.replaceAll("\\s+", " ");
        System.out.println(input);

        String resut1 = RegUtil.findRex(pat, input, 2);
        String resut2 = RegUtil.findRex(pat, input, 4);



        String[] split = resut2.split(",");
        String replacemet;
        for (int i = 0; i < split.length; i++) {
            replacemet = "'"+split[i].trim()+"'";
            resut1 = resut1.replaceFirst("\\?", replacemet);
        }
        System.out.println(resut1);

    }

    @Test
    void test1(){
        String pat1 = "\n";
        String input1 = "1122\n";
//        Pattern pattern = Pattern.compile(pat1, Pattern.DOTALL | Pattern.MULTILINE);
//        Matcher matcher = pattern.matcher(input1);
//
//        System.out.println(matcher.find());
//        System.out.println(matcher.group());
        String s = input1.replaceAll("\n", "#");
        System.out.println(s);
//        if (matcher.find()) {
//            int i = matcher.groupCount();
//            System.out.println(i);
//            for (int j = 0; j < i+1; j++) {
//                System.out.println(j+" "+matcher.group(j));
//            }
//            System.out.println("end");
//        }
    }
}