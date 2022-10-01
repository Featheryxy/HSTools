package ind.milo.services.iterfaces;

import ind.milo.entity.TaskItem;

import java.util.List;

/**
 * @Date 2022/9/29 17:18
 * @Created by Milo
 */
public interface ITaskItemService {
    List<TaskItem> listTaskItem(String text);
}
