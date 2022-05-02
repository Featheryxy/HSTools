package ind.milo.panes;

import ind.milo.util.NIOUtil;
import ind.milo.util.RegUtil;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MdfTab {
    private Tab mdfTab = new Tab("修改单");
    private VBox vBox = new VBox();

    private TextField resonTextField = new TextField();
    private TextArea inputTextArea = new TextArea();
    private TextArea outputTextArea = new TextArea();

    private Button transferBtn = new Button("转换");
    private Button fileBtn = new Button("生成文件");

    private HBox hBox = new HBox();
    private Group buttonGroup = new Group();

    public MdfTab(){
        init();
        action();
    }

    public Tab getMdfTab() {
        return mdfTab;
    }


    private void init() {
        mdfTab.setClosable(false);
        hBox.getChildren().addAll(transferBtn, fileBtn);
        vBox.getChildren().addAll(inputTextArea, resonTextField, hBox, outputTextArea);
        mdfTab.setContent(vBox);
    }

    private void action() {
        // todo 后续改成线程监听
        transferBtn.setOnAction(actionEvent -> {
            String submitInfo = RegUtil.getSubmitInfo(inputTextArea.getText(), resonTextField.getText());
            outputTextArea.setText(submitInfo);
        });

        fileBtn.setOnAction(actionEvent -> {
            String submitInfo = RegUtil.getSubmitInfo(inputTextArea.getText(), resonTextField.getText());
            NIOUtil.makeFile("nihao, 中国人", "修改单1.txt");
        });
    }

}
