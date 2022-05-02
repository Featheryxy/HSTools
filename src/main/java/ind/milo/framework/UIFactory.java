package ind.milo.framework;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;


import java.util.*;

/**
 * @Date 2022/4/11 21:15
 * @Created by Milo
 */
public class UIFactory {
    private UIFactory() {

    }

    public static Group getButton(String ... btnNames){
//        ArrayList<Button> buttons = new ArrayList<>();
        Group group = new Group();
        for (String btnName: btnNames) {
            group.getChildren().add(getSingleButton(btnName));
        }
        return group;
    }

    public static Button getSingleButton(String text){
        return new Button(text);
    }
}
