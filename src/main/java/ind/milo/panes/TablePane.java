package ind.milo.panes;

import freemarker.template.TemplateException;
import ind.milo.entity.TaskItem;
import ind.milo.framework.AbstractTab;
import ind.milo.framework.UIFactory;
import ind.milo.util.FreemarkerUtil;
import ind.milo.util.JsonUtil;
import ind.milo.util.StringUtil;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @Date 2022/10/10 11:59
 * @Created by Milo
 */
public class TablePane extends AbstractTab {
    private Tab tableTab;

    private VBox vBox;

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
        column3.setCellFactory(this::getTaskItemTaskItemTableCell);

        tableView.getColumns().addAll(column1, column2, column3);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private TableCell<TaskItem, TaskItem> getTaskItemTaskItemTableCell(TableColumn<TaskItem, TaskItem> param) {
        Button copyBtn = new Button("Copy");
        Button deleteBtn = new Button("Delete");
        HBox hBox = new HBox(10, copyBtn, deleteBtn);

        TableCell<TaskItem, TaskItem> cell = new TableCell<TaskItem, TaskItem>() {
            @Override
            protected void updateItem(TaskItem item, boolean empty) {
                super.updateItem(item, empty);
                if (!empty) {
                    setGraphic(hBox);
                } else {
                    setGraphic(null);
                }
            }
        };
        deleteBtn.setOnAction(e -> onDelete(cell));
        copyBtn.setOnAction(event -> onCopy(cell));
        return cell;
    }

    private void onDelete(TableCell<TaskItem, TaskItem> cell) {
        ObservableList<TaskItem> items = cell.getTableView().getItems();
        TaskItem item = cell.getItem();
        if (null == item) {
            return;
        }
        items.remove(item);
    }

    private void onCopy(TableCell<TaskItem, TaskItem> cell) {
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
        String mdfStr = null;
        try {
            mdfStr = freemarkerUtil.exce(stringMap);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }

        UIFactory.setContent2Clipboard(mdfStr);
    }


    public void set() {
        vBox.getChildren().addAll(inputTextArea, button, tableView);
        tableTab.setClosable(false);
        tableTab.setContent(vBox);
    }

    @Override
    public void action() {
        button.setOnAction((event) -> {
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
