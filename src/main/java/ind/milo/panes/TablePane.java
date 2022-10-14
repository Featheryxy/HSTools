package ind.milo.panes;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import ind.milo.demo.javafxdemo.TableViewDemo;
import ind.milo.entity.TaskItem;
import ind.milo.framework.AbstractTab;
import ind.milo.framework.UIFactory;
import ind.milo.util.JsonUtil;
import ind.milo.util.StringUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date 2022/10/10 11:59
 * @Created by Milo
 */
public class TablePane extends AbstractTab {
    private Tab tableTab ;

    private VBox vBox ;

    private TextArea inputTextArea;
    private Button button;
    private TableView<TaskItem> tableView;

    @Override
    public void init() {
        tableTab = new Tab("修改单");
        inputTextArea = new TextArea();
        vBox = new VBox(10);
        button = UIFactory.getSingleButton("生成");
        tableView = new TableView<>();
        setTableView();
        set();
    }

    private void setTableView() {
        // 创建列
        TableColumn<TaskItem, String> column1 = new TableColumn<>("版本");
//        column1.setCellValueFactory(new PropertyValueFactory<>("sprintVersion"));
        column1.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getSprintVersion()));
        TableColumn<TaskItem, String> column2 = new TableColumn<>("修改原因");
//        column2.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getName()));
        TableColumn column3 = new TableColumn("操作");
        // 添加列
        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public void set() {
        vBox.getChildren().addAll(inputTextArea, button,tableView);
        tableTab.setClosable(false);
        tableTab.setContent(vBox);
    }

    @Override
    public void action() {
        button.setOnAction((event)->{
            if (StringUtil.isNullStr(inputTextArea.getText())) {
                return;
            }

            List<TaskItem> taskItems = JsonUtil.listTaskItem(inputTextArea.getText());
            // todo 改成stream
            tableView.getItems().clear();
            tableView.getItems().addAll(taskItems);
//            for (TaskItem taskItem : taskItems) {
//                tableView.getItems().add(new TaskItem(taskItem.getSprintVersion(), taskItem.getName()));
//            }
        });
    }

    @Override
    public Tab getTab() {
        return tableTab;
    }
}
