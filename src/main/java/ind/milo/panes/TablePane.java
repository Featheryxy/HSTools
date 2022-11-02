package ind.milo.panes;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import ind.milo.demo.javafxdemo.TableViewDemo;
import ind.milo.entity.TaskItem;
import ind.milo.framework.AbstractTab;
import ind.milo.framework.UIFactory;
import ind.milo.util.FreemarkerUtil;
import ind.milo.util.JsonUtil;
import ind.milo.util.StringUtil;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.apache.commons.beanutils.BeanUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
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
    private List<TaskItem> taskItems;

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

        TableColumn<TaskItem, TaskItem> column3 = new TableColumn<>("操作");
        column3.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(p.getValue()));
        // 添加列
        column3.setCellFactory(new Callback<TableColumn<TaskItem, TaskItem>, TableCell<TaskItem, TaskItem>>() {
            @Override
            public TableCell<TaskItem, TaskItem> call(TableColumn param) {
                Button copyBtn = new Button("Copy");
                TableCell<TaskItem, TaskItem> cell = new TableCell<TaskItem, TaskItem>() {
                    @Override
                    protected void updateItem(TaskItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!empty) {
                            setGraphic(copyBtn);
                        }
                    }
                };
                copyBtn.setOnAction(event -> {
                    String ftlPath = "F:\\JavaFX\\HSTools\\src\\main\\resources\\ftl";
                    String ftlName = "mdf.ftl";
                    FreemarkerUtil freemarkerUtil = new FreemarkerUtil(ftlPath, ftlName);
                    Map<String, String> stringMap = null;
                    try {
                        stringMap = BeanUtils.describe(cell.getItem());
                    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    stringMap.put("date", LocalDate.now().toString());
                    stringMap.put("jobId", "yexy34716");
                    String mdfStr=null;
                    try {
                        mdfStr = freemarkerUtil.exce(stringMap);
                    } catch (IOException | TemplateException e) {
                        e.printStackTrace();
                    }

                    Clipboard clipboard = Clipboard.getSystemClipboard();
                    ClipboardContent clipboardContent = new ClipboardContent();
                    clipboardContent.put(DataFormat.PLAIN_TEXT, mdfStr);
                    clipboard.setContent(clipboardContent);
                });
                return cell;
            }
        });

        tableView.getColumns().addAll(column1, column2, column3);
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

            taskItems = JsonUtil.listTaskItem(inputTextArea.getText());
            // todo 改成stream
            tableView.getItems().clear();
            tableView.getItems().addAll(taskItems);
        });


    }

    @Override
    public Tab getTab() {
        return tableTab;
    }
}
