### 设计

### 版本1:

#### 功能

1. 从前端获取修改单报文, 解析后获取MdfInfo
2. 将MdfInfo保存到数据库, 后续用于增删改查
   - 增: 插入时使用meger into, 只插入数据库中没有的修改单号.同时生成文件用于记录修改单修改的内容
   - 查: 使用tableView
     - 搜索: 
   - 删: 实际不需要,暂定不实现
   - 改: 暂定不实现

#### 界面:





### 待办

- [x] SQL提取
- [x] 修改单文件生成 貌似没什么用
- [x] 置顶按钮 20220404
- [ ] 添加 clear 按钮
- [ ] todo list, 使用tabview, 参考https://www.jianshu.com/p/dc99fba6933c
- [ ] SQL美化



### todo

yyMMddHHmmss

```sql
task(task_id, task_name, deadline, create_time, mdf_time, task_desc, progress)
progress: 进度，先给0或1
select * from todo;
drop table todo;
create table todo(
                     todo_id int primary key auto_increment,
                     todo_name varchar(50) not null,
                     deadline int null,
                     mdf_time char(13) not null,
                     todo_desc VARCHAR(255) null,
                     complete char(1) not null default '0'
);

insert into todo(todo_name, deadline, mdf_time, todo_desc) values ( '123', 21313, 23123, '222');

yyyyMMddHHmmss 8+6 = 14


create table tbwork(
    mdf_no varchar(25) primary key ,
    mdf_reason varchar(255),
    mdf_detail varchar(65535),
    version varchar(25),
    require_no varchar(20),
    create_date date,
    tag varchar(25),
    file_path varchar(255) comments ""
);
```



### java版本更替为 Java11
java11需要添加如下内容
```xml
<properties>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
    <javafx.version>11.0.14</javafx.version>
</properties>


<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>11.0.2</version>
</dependency>
```
VM Options
```aidl
--module-path "D:\Java\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml
```
