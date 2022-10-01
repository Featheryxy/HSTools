package ind.milo.services.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.ParserConfig;
import ind.milo.entity.TaskItem;
import ind.milo.services.iterfaces.ITaskItemService;

import java.util.List;

/**
 * @Date 2022/9/29 17:17
 * @Created by Milo
 */
public class TaskItemService implements ITaskItemService {
    @Override
    public List<TaskItem> listTaskItem(String text) {
        ParserConfig.getGlobalInstance().propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
        String jsonArray = JSONObject.parseObject(text).getJSONObject("data").getString("items");
        return JSONArray.parseArray(jsonArray, TaskItem.class);
    }
}
