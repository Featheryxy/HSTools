package ind.milo.demo.javafxdemo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.Data;

public class LoginDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        Label labelUser = new Label("账号");
        Label labelPass = new Label("密码");
        TextField textField = new TextField();
        PasswordField passwordField = new PasswordField();
        passwordField.setText("213213");
        Button button = new Button("登录");

        gridPane.add(labelUser,0,0);
        gridPane.add(labelPass, 0, 1);
        gridPane.add(textField, 1, 0);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(button, 1, 2);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(30);
        gridPane.setVgap(20);

        button.setOnAction(event -> {
            if ("213213".equals(passwordField.getText())) {
                System.out.println("成功");

                SuccessWindow window = new SuccessWindow("Milo", "213213");
                primaryStage.close();
            }
        });

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(450);
        primaryStage.show();
    }
}

@Data
class SuccessWindow {
    private Stage successStage = new Stage();
    private String username;
    private String password;

    public SuccessWindow(String username, String password) {
        this.username = username;
        this.password = password;
        initStage();
    }

    private void initStage() {
        System.out.println("登录成功");
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #FFC0CB");
        Label label = new Label("Hello: " + username);

        borderPane.setCenter(label);
        Scene scene = new Scene(borderPane);
        successStage.setScene(scene);
        successStage.show();
    }

}