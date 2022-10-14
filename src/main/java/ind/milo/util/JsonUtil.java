package ind.milo.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.ParserConfig;
import ind.milo.entity.TaskItem;

import java.util.List;

/**
 * @Date 2022/10/12 23:03
 * @Created by Milo
 */
public class JsonUtil {
    private JsonUtil() {

    }

    public static List<TaskItem>  listTaskItem(String text){
        ParserConfig.getGlobalInstance().propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
        String jsonArrayStr = JSONObject.parseObject(text).getJSONObject("data").getString("items");
        List<TaskItem> taskItems = JSONArray.parseArray(jsonArrayStr, TaskItem.class);
        return taskItems;
    }
}
