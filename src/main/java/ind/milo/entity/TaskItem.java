package ind.milo.entity;

import lombok.Data;

/**
 * @Date 2022/9/29 15:47
 * @Created by Milo
 */
@Data
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

}
