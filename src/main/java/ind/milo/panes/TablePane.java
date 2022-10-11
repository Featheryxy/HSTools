package ind.milo.panes;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import ind.milo.framework.AbstractTab;
import ind.milo.framework.UIFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
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
    private

    @Override
    public void init() {
        tableTab = new Tab("修改单");
        inputTextArea = new TextArea();
        vBox = new VBox(10);
        button = UIFactory.getSingleButton("生成");

        set();
    }

    public void set() {
        vBox.getChildren().addAll(inputTextArea, button);
        tableTab.setClosable(false);
        tableTab.setContent(vBox);
    }

    @Override
    public void action() {
        button.setOnAction((event)->{

        });
    }

    @Override
    public Tab getTab() {
        return tableTab;
    }
}
