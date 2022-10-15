package ind.milo.demo.javafxdemo;

import java.util.function.Function;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TableViewWithEditButton extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. 创建tableview;
        TableView<Person> table = new TableView<>();
        // 2. 为tableview设置列
        table.getColumns().add(column("First Name", Person::firstNameProperty, 150));
        table.getColumns().add(column("Last Name", Person::lastNameProperty, 150));
        table.getColumns().add(column("Email", Person::emailProperty, 200));

        TableColumn<Person, Person> editColumn = column("Edit", ReadOnlyObjectWrapper<Person>::new, 60);

        table.getColumns().add(editColumn);

        editColumn.setCellFactory(col -> {
            Button editButton = new Button("Edit");
            TableCell<Person, Person> cell = new TableCell<Person, Person>() {
                @Override
                public void updateItem(Person person, boolean empty) {
                    super.updateItem(person, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(editButton);
                    }
                }
            };

            editButton.setOnAction(e -> edit(cell.getItem(), primaryStage));

            return cell ;
        });

        table.getItems().addAll(
                new Person("Jacob", "Smith", "jacob.smith@example.com"),
                new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                new Person("Ethan", "Williams", "ethan.williams@example.com"),
                new Person("Emma", "Jones", "emma.jones@example.com"),
                new Person("Michael", "Brown", "michael.brown@example.com")
        );

        primaryStage.setScene(new Scene(new BorderPane(table)));
        primaryStage.show();
    }

    private void edit(Person person, Stage primaryStage) {
        TextField firstNameTextField = boundTF(person.firstNameProperty());
        TextField lastNameTextField = boundTF(person.lastNameProperty());
        TextField emailTextField = boundTF(person.emailProperty());

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(16));


        grid.addRow(0, new Label("First name:"), firstNameTextField);
        grid.addRow(1, new Label("Last name:"), lastNameTextField);
        grid.addRow(2, new Label("Email:"), emailTextField);

        Button okButton = new Button("OK");

        grid.add(okButton, 0, 3, 2, 1);

        ColumnConstraints leftCol = new ColumnConstraints();
        leftCol.setHgrow(Priority.NEVER);
        leftCol.setHalignment(HPos.RIGHT);
        ColumnConstraints rightCol = new ColumnConstraints();
        rightCol.setHgrow(Priority.SOMETIMES);
        grid.getColumnConstraints().addAll(leftCol, rightCol);
        GridPane.setHalignment(okButton, HPos.CENTER);

        Scene scene = new Scene(grid);
        Stage stage = new Stage();

        okButton.setOnAction(e -> stage.hide());
        firstNameTextField.setOnAction(e -> stage.hide());
        lastNameTextField.setOnAction(e -> stage.hide());
        emailTextField.setOnAction(e -> stage.hide());

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(primaryStage);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    private TextField boundTF(StringProperty binding) {
        TextField textField = new TextField();
        textField.textProperty().bindBidirectional(binding);
        textField.setMinWidth(80);
        return textField ;
    }

    private <S,T> TableColumn<S,T> column(String title, Function<S, ObservableValue<T>> property, double width) {
        TableColumn<S,T> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        col.setPrefWidth(width);
        return col ;
    }

    public static class Person {
        private final StringProperty firstName = new SimpleStringProperty();
        private final StringProperty lastName = new SimpleStringProperty();
        private final StringProperty email = new SimpleStringProperty();

        public Person(String firstName, String lastName, String email) {
            setFirstName(firstName);
            setLastName(lastName);
            setEmail(email);
        }

        public final StringProperty firstNameProperty() {
            return this.firstName;
        }

        public final java.lang.String getFirstName() {
            return this.firstNameProperty().get();
        }

        public final void setFirstName(final java.lang.String firstName) {
            this.firstNameProperty().set(firstName);
        }

        public final StringProperty lastNameProperty() {
            return this.lastName;
        }

        public final java.lang.String getLastName() {
            return this.lastNameProperty().get();
        }

        public final void setLastName(final java.lang.String lastName) {
            this.lastNameProperty().set(lastName);
        }

        public final StringProperty emailProperty() {
            return this.email;
        }

        public final java.lang.String getEmail() {
            return this.emailProperty().get();
        }

        public final void setEmail(final java.lang.String email) {
            this.emailProperty().set(email);
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}