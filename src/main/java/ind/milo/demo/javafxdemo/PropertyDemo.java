package ind.milo.demo.javafxdemo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PropertyDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        Circle circle = new Circle();
        circle.setCenterX(250);
        circle.setCenterY(250);
        circle.setRadius(100);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        anchorPane.getChildren().addAll(circle);

        Scene scene = new Scene(anchorPane);
        // 属性绑定
        circle.centerXProperty().bind(scene.widthProperty().divide(2));
        circle.centerYProperty().bind(scene.heightProperty().divide(2));
        // 事件监听器
        circle.centerXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(String.format("old x: %s, new x %s", oldValue, newValue));
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        primaryStage.show();
    }

}
