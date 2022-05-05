package ind.milo.panes;

import ind.milo.framework.AbstractTab;
import ind.milo.framework.UIFactory;
import ind.milo.util.StringUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ind.milo.services.impl.SqlService;

import java.util.List;

public class SqlTab extends AbstractTab {
    private Tab sqlTab = new Tab("SQL");
    private VBox vBox = new VBox();
    private HBox hBox = new HBox();

    private TextArea inputTextArea = new TextArea();
    private TextArea outputTextArea = new TextArea();

//    private Group buttons = UIFactory.getButton("clean", "sql");

    private Button transferBtn = new Button("提取");
    private Button cleanBtn = new Button("clean");

    private final String pat1 = "(当前SQL:)(.*)(当前参数:)(.*)";
    private SqlService sqlService = new SqlService();


    @Override
    public void init() {
        sqlTab.setClosable(false);
//        hBox.getChildren().addAll(buttons);
        hBox.getChildren().addAll(transferBtn, cleanBtn);
        vBox.getChildren().addAll(inputTextArea, hBox, outputTextArea);
        sqlTab.setContent(vBox);
    }

    @Override
    public void action() {
//        for (buttons.)


        transferBtn.setOnAction( event -> {
            String sqlByPat = sqlService.getSqlByPat(pat1, inputTextArea.getText());
            outputTextArea.setText(sqlByPat);
        });

        cleanBtn.setOnAction(event -> {
            String cleanData = StringUtil.cleanData(inputTextArea.getText());
            outputTextArea.setText(cleanData);
        });
    }


    @Override
    public Tab getTab() {
        return sqlTab;
    }
}
