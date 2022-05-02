package ind.milo;

import ind.milo.panes.ToDoTab;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ind.milo.panes.MdfTab;
import ind.milo.panes.SqlTab;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TabPane tabPane = new TabPane();

        MdfTab mdfTab = new MdfTab();
        SqlTab sqlTab = new SqlTab();
        ToDoTab toDoTab = new ToDoTab();
        sqlTab.display();
        tabPane.getTabs().addAll(mdfTab.getMdfTab(), sqlTab.getTab(), toDoTab.getTab());

        Separator hSeparator = new Separator(Orientation.HORIZONTAL);


        HBox hBox = new HBox();
        hBox.setMinHeight(20);

        CheckBox c1 = new CheckBox("置顶");

//        ToggleGroup toggleGroup = new ToggleGroup();
//        RadioButton radioButton = new RadioButton("置顶");
//        radioButton.setToggleGroup(toggleGroup);

        hBox.getChildren().add(c1);

        VBox vBox = new VBox(2);
        vBox.getChildren().addAll(hBox, hSeparator, tabPane);

        c1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    primaryStage.setAlwaysOnTop(true);
                }
                if (!newValue) {
                    primaryStage.setAlwaysOnTop(false);
                }
            }
        });

        Scene scene = new Scene(vBox, 300, 300);
        scene.getStylesheets().add("css/bootstrap3.css");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(450);
        primaryStage.show();
    }

    private void action() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
