package ind.milo.services.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ind.milo.services.iterfaces.JsonService;

/**
 * @Date 2022/5/22 11:45
 * @Created by Milo
 */
public class JsonServiceImpl implements JsonService {
    @Override
    public void parseJson(String str) {
        Object parse = JSON.parse(str);
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
