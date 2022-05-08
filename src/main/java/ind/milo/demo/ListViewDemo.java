package ind.milo.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Stage;

public class ListViewDemo extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<String> data = FXCollections.observableArrayList(
                "January", "February", "March", "April",
                "May", "June", "July", "August", "September",
                "October", "November", "December"
        );
        final ListView<String> listView1 = new ListView<>();
        // 单选模式
//        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView1.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView1.setItems(data);
//        listView1.setPrefWidth(150);
//        listView1.setPrefHeight(100);
//        listView1.setOrientation(Orientation.VERTICAL);
//        listView1.setEditable(true);
//        listView1.setCellFactory(TextFieldListCell.forListView());

        Scene scene = new Scene(listView1);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
