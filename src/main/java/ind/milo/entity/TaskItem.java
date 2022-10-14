package ind.milo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2022/9/29 15:47
 * @Created by Milo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskItem {
    // 当前可提交版本
    String sprintVersion;
    // 任务描述
    String description;
    // 需求编号
    String storyNumbers;

    // 修改单编号
    String taskNumber;

    // 标题,修改原因
    String name;

    public TaskItem(String sprintVersion, String name){
        this.sprintVersion = sprintVersion;
        this.name = name;
    }

}
