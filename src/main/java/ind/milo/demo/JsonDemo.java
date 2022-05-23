package ind.milo.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonDemo {
    private static String mdf = "{\n" +
            "  \"success\": true,\n" +
            "  \"resultBOList\": [\n" +
            "    {\n" +
            "      \"auditor\": \"25236\",\n" +
            "      \"completedStatus\": \"1\",\n" +
            "      \"createDate\": \"2022-05-05T00:00:00\",\n" +
            "      \"customername\": \"华鑫国际信托有限公司(67379)\",\n" +
            "      \"deleteStatus\": \"A\",\n" +
            "      \"desinger\": \"25236\",\n" +
            "      \"directIntegrate\": false,\n" +
            "      \"director\": \"36122|黄生晟\",\n" +
            "      \"emailNoticeUsers\": \"36122\",\n" +
            "      \"expectedReleaseDate\": \"2022-05-31T00:00:00\",\n" +
            "      \"extTxt2\": \"发送人：方浩\\n原状态：新增\\n操作动作：新增\\n最后更新：2022-5-5 8:52:18\",\n" +
            "      \"extTxt3\": \"0\",\n" +
            "      \"extTxt6\": \"1\",\n" +
            "      \"extTxt7\": \"0\",\n" +
            "      \"firstModifyDate\": \"2022-05-20T00:00:00\",\n" +
            "      \"integationCallbackCount\": 0,\n" +
            "      \"integationCount\": 0,\n" +
            "      \"integationMan\": \"04961\",\n" +
            "      \"isProgramArchive\": \"0\",\n" +
            "      \"isSmokeTesting\": \"2\",\n" +
            "      \"lastUpdateBy\": \"25236\",\n" +
            "      \"lastUpdateDttm\": \"2022-05-06T14:36:35\",\n" +
            "      \"modifier\": \"36122\",\n" +
            "      \"modifierGroup\": \"信托TA6.0团队\",\n" +
            "      \"modifyDate\": \"2022-05-11T00:00:00\",\n" +
            "      \"modifyDifficulty\": \"2\",\n" +
            "      \"modifyId\": \"20220505085218812201024108402205\",\n" +
            "      \"modifyIds\": [\n" +
            "        \"20220505085218812201024108402205\"\n" +
            "      ],\n" +
            "      \"modifyNum\": \"M202205050017\",\n" +
            "      \"modifyReason\": \"【分配方案】<div>执行分配方案之后tbtrustprofdtlcontract的REG_DATE为0<\\/div><br><br>修复该缺陷<br><br>修复该缺陷\",\n" +
            "      \"modifyStatus\": \"0\",\n" +
            "      \"modifyType\": \"1\",\n" +
            "      \"moduleIds\": \"20200928103619718189742912839867\",\n" +
            "      \"moduleNames\": \"信托子系统\",\n" +
            "      \"phase\": \"0\",\n" +
            "      \"productId\": \"20200809\",\n" +
            "      \"promiseDate\": \"2022-05-31T00:00:00\",\n" +
            "      \"promiseDateStr\": \"2022-05-31\",\n" +
            "      \"publicPortion\": \"2\",\n" +
            "      \"receiver\": \"36122\",\n" +
            "      \"reqIds\": \"20220428140734380174019217894166\",\n" +
            "      \"reqIdsArr\": [\n" +
            "        \"20220428140734380174019217894166\"\n" +
            "      ],\n" +
            "      \"reqNums\": \"202204280504\",\n" +
            "      \"requireSendMessage\": false,\n" +
            "      \"returnCount\": 0,\n" +
            "      \"taskAssigner\": \"25236\",\n" +
            "      \"taskId\": \"20220505085218562242295189490460\",\n" +
            "      \"taskNum\": \"T202205050005-1\",\n" +
            "      \"taskType\": \"0\",\n" +
            "      \"testStyle\": \"1\",\n" +
            "      \"testSuggestion\": \"【涉及子系统】：&nbsp;<div>【功能入口】：&nbsp;<\\/div><div>【测试准备】：&nbsp;<\\/div><div>【测试场景及预期结果】：&nbsp;<\\/div><div>【影响范围】：&nbsp;<\\/div><div>【单元测试数据库】：&nbsp;<\\/div><div>【是否增值业务】：&nbsp;<\\/div><div>【是否个性化】：<\\/div>\",\n" +
            "      \"testType\": \"2\",\n" +
            "      \"tester\": \"28310,34325,07673,28149\",\n" +
            "      \"timestamp\": 1651818995406,\n" +
            "      \"version\": \"20220426195101541209550243810135\",\n" +
            "      \"versionNO\": \"TA6.0V202202.01.007\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"auditor\": \"25236\",\n" +
            "      \"completedStatus\": \"1\",\n" +
            "      \"createDate\": \"2022-05-05T00:00:00\",\n" +
            "      \"customername\": \"华鑫国际信托有限公司(67379)\",\n" +
            "      \"deleteStatus\": \"A\",\n" +
            "      \"desinger\": \"25236\",\n" +
            "      \"directIntegrate\": false,\n" +
            "      \"director\": \"36122|黄生晟\",\n" +
            "      \"emailNoticeUsers\": \"36122\",\n" +
            "      \"expectedReleaseDate\": \"2022-05-31T00:00:00\",\n" +
            "      \"extTxt2\": \"发送人：方浩\\n原状态：新增\\n操作动作：新增\\n最后更新：2022-5-5 8:52:18\",\n" +
            "      \"extTxt3\": \"0\",\n" +
            "      \"extTxt6\": \"1\",\n" +
            "      \"extTxt7\": \"0\",\n" +
            "      \"firstModifyDate\": \"2022-05-20T00:00:00\",\n" +
            "      \"integationCallbackCount\": 0,\n" +
            "      \"integationCount\": 0,\n" +
            "      \"integationMan\": \"04961\",\n" +
            "      \"isProgramArchive\": \"0\",\n" +
            "      \"isSmokeTesting\": \"2\",\n" +
            "      \"lastUpdateBy\": \"25236\",\n" +
            "      \"lastUpdateDttm\": \"2022-05-06T14:36:35\",\n" +
            "      \"modifier\": \"36122\",\n" +
            "      \"modifierGroup\": \"信托TA6.0团队\",\n" +
            "      \"modifyDate\": \"2022-05-11T00:00:00\",\n" +
            "      \"modifyDifficulty\": \"2\",\n" +
            "      \"modifyId\": \"20220505085218734502874940172695\",\n" +
            "      \"modifyIds\": [\n" +
            "        \"20220505085218734502874940172695\"\n" +
            "      ],\n" +
            "      \"modifyNum\": \"M202205050016\",\n" +
            "      \"modifyReason\": \"【分配方案】<div>执行分配方案之后tbtrustprofdtlcontract的REG_DATE为0<\\/div><br><br>修复该缺陷<br><br>修复该缺陷\",\n" +
            "      \"modifyStatus\": \"0\",\n" +
            "      \"modifyType\": \"1\",\n" +
            "      \"moduleIds\": \"20200928103619718189742912839867\",\n" +
            "      \"moduleNames\": \"信托子系统\",\n" +
            "      \"phase\": \"0\",\n" +
            "      \"productId\": \"20200809\",\n" +
            "      \"promiseDate\": \"2022-05-31T00:00:00\",\n" +
            "      \"promiseDateStr\": \"2022-05-31\",\n" +
            "      \"publicPortion\": \"2\",\n" +
            "      \"receiver\": \"36122\",\n" +
            "      \"reqIds\": \"20220428140734380174019217894166\",\n" +
            "      \"reqIdsArr\": [\n" +
            "        \"20220428140734380174019217894166\"\n" +
            "      ],\n" +
            "      \"reqNums\": \"202204280504\",\n" +
            "      \"requireSendMessage\": false,\n" +
            "      \"returnCount\": 0,\n" +
            "      \"taskAssigner\": \"25236\",\n" +
            "      \"taskId\": \"20220505085218515843324087469162\",\n" +
            "      \"taskNum\": \"T202205050005\",\n" +
            "      \"taskType\": \"0\",\n" +
            "      \"testStyle\": \"1\",\n" +
            "      \"testSuggestion\": \"【涉及子系统】：&nbsp;<div>【功能入口】：&nbsp;<\\/div><div>【测试准备】：&nbsp;<\\/div><div>【测试场景及预期结果】：&nbsp;<\\/div><div>【影响范围】：&nbsp;<\\/div><div>【单元测试数据库】：&nbsp;<\\/div><div>【是否增值业务】：&nbsp;<\\/div><div>【是否个性化】：<\\/div>\",\n" +
            "      \"testType\": \"2\",\n" +
            "      \"tester\": \"28310,34325,07673,28149\",\n" +
            "      \"timestamp\": 1651818995437,\n" +
            "      \"version\": \"20220120112653589826733940119949\",\n" +
            "      \"versionNO\": \"TA6.0V202202.05.000\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"recordsCount\": 2\n" +
            "}";
    public static void main(String[] args) {
        Object parse = JSON.parse(mdf);
        System.out.println(parse);
        JSONArray resultBOList = (JSONArray) ((JSONObject) parse).get("resultBOList");

        for (Object obj : resultBOList) {
            JSONObject jsonObj = (JSONObject) obj;
            System.out.println("版本号："+jsonObj.get("versionNO").toString());
            System.out.println("修改单号："+jsonObj.get("modifyNum").toString());
            System.out.println("修改原因"+jsonObj.get("modifyReason").toString());
            System.out.println("需求号："+jsonObj.get("reqNums").toString());
            System.out.println("任务号："+jsonObj.get("taskNum").toString());
            System.out.println("要求完成时间："+jsonObj.get("promiseDateStr").toString());
            System.out.println();
        }
    }
}
