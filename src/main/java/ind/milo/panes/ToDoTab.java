package ind.milo.panes;

import ind.milo.framework.AbstractTab;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ToDoTab extends AbstractTab {
    private Tab toDoTab;
    private TextField textField;
    private CheckBox checkBox;
    private Button button;

    private VBox vBox = new VBox();
    private HBox hBox = new HBox();

    public ToDoTab(){

    }


    @Override
    public void init() {
        textField = new TextField();
        toDoTab = new Tab("ToDo");
        checkBox = new CheckBox("代办1");
        button = new Button("确认");

        Group group = new Group();
        hBox.getChildren().addAll(textField, button);

        group.getChildren().addAll(checkBox);

        textField.setPromptText("Enter what you want to do next!");
        vBox.getChildren().addAll(hBox, group);
        toDoTab.setContent(vBox);
        toDoTab.setClosable(false);
    }

    @Override
    public void action() {
        // 创建快捷键，enter,
        // 1. 获取textfield的内容，清空textfield，
        // 2. 创建组件 check_box+label
        // 3. 在 vbok 中添加
        button.setOnAction(event -> {
            if (0 != textField.getText().length()) {
                CheckBox checkBox = new CheckBox(textField.getText());
                vBox.getChildren().addAll(checkBox);
            }
        });


    }

    @Override
    public Tab getTab() {
        this.display();
        return toDoTab;
    }
}
