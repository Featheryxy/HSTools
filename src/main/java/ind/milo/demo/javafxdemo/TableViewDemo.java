package ind.milo.demo.javafxdemo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @Date 2022/10/10 11:42
 * @Created by Milo
 */
public class TableViewDemo extends Application{
        /**
         * 启动
         *
         * @param args 参数
         */
        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage primaryStage) {
            // 创建一个表格视图
            TableView<Person> tableView = new TableView<>();

            // 创建列
            TableColumn<Person, String> column1 = new TableColumn<>("姓名");
            column1.setCellValueFactory(new PropertyValueFactory<>("Name"));
            TableColumn<Person, String> column2 = new TableColumn<>("年龄");
            column2.setCellValueFactory(new PropertyValueFactory<>("age"));

            // 设置列宽
            column1.setPrefWidth(120.0d);
            column2.setPrefWidth(200.0d);

            // 添加列
            tableView.getColumns().add(column1);
            tableView.getColumns().add(column2);
            // tableView.getColumns().addAll(column1, column2);

            // 无行数据显示时的占位符
            tableView.setPlaceholder(new Label("空白"));

            Button addLine = new Button("添加行");
            addLine.setOnMouseClicked((event) -> {
                // 添加行数据
                tableView.getItems().add(new Person("张三", 15));
                tableView.getItems().add(new Person("李四", 22));
            });
            Button singleSelect = new Button("单选模式");
            singleSelect.setOnMouseClicked((event) -> {
                // 设置选择模式为单行
                tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            });
            Button multiSelect = new Button("多选模式");
            multiSelect.setOnMouseClicked((event) -> {
                // 设置多行选择模式
                tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            });

            // 界面
            HBox topBar = new HBox();
            topBar.getChildren().addAll(addLine, singleSelect, multiSelect);
            VBox body = new VBox(tableView);
            VBox vbox = new VBox();
            vbox.getChildren().addAll(topBar, body);
            Scene scene = new Scene(vbox);
            primaryStage.setScene(scene);
            primaryStage.setWidth(480.0d);
            primaryStage.setHeight(320.0d);
            primaryStage.show();
        }

        public class Person {
            private String name;
            private int age;

            public Person(String name, int age) {
                this.setName(name);
                this.setAge(age);
            }

            /**
             * Get age value
             *
             * @return the age
             */
            public int getAge() {
                return age;
            }

            /**
             * Set age to age
             *
             * @param age the age to set
             */
            public void setAge(int age) {
                this.age = age;
            }

            /**
             * Get name value
             *
             * @return the name
             */
            public String getName() {
                return name;
            }

            /**
             * Set name to name
             *
             * @param name the name to set
             */
            public void setName(String name) {
                this.name = name;
            }
        }
    }

