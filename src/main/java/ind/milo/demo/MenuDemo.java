package ind.milo.demo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuDemo extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("menu1");
        Menu menu2 = new Menu("menu2");
        Menu menu3 = new Menu("menu3");
        MenuItem item1 = new MenuItem("item1");
        MenuItem item2 = new MenuItem("item2");
        MenuItem item3 = new MenuItem("item3");
        menu1.getItems().addAll(item1, item2, item3);
        boolean b = menuBar.getMenus().addAll(menu1, menu2, menu3);

        menu1.setOnShowing(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.out.println("menu1.setOnShowing");
            }
        });

        menu1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("menu1.setOnAction");
            }
        });

        item1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("item1.setOnAction");
            }
        });

        // menu下面有item才行，不然不行
        menu2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("menu2.setOnAction");
            }
        });

        anchorPane.getChildren().addAll(menuBar);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(450);
        primaryStage.show();

        menuBar.setPrefWidth(anchorPane.getWidth());



        anchorPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                menuBar.setPrefWidth(newValue.doubleValue());
            }
        });
    }
}
