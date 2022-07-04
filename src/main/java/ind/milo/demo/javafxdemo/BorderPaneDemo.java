package ind.milo.demo.javafxdemo;

import ind.milo.framework.UIFactory;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button top = UIFactory.getSingleButton("Top");
        Button bottom = UIFactory.getSingleButton("Bottom");
        Button left = UIFactory.getSingleButton("Left");
        Button rigth = UIFactory.getSingleButton("Rigth");
        Button center = UIFactory.getSingleButton("Center");

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(top);
        borderPane.setBottom(bottom);
        borderPane.setLeft(left);
        borderPane.setRight(rigth);
        borderPane.setCenter(center);

        BorderPane.setAlignment(top, Pos.CENTER);
        BorderPane.setAlignment(bottom, Pos.CENTER);
        BorderPane.setAlignment(left, Pos.CENTER);
        BorderPane.setAlignment(rigth, Pos.CENTER);
        BorderPane.setAlignment(center, Pos.CENTER);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
