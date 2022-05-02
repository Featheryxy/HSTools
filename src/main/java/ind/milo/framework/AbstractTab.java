package ind.milo.framework;

import javafx.scene.control.Tab;

public abstract class AbstractTab {
    public abstract void init();

    public abstract void action();

    public final void display() {
        init();
        action();
    }

    public abstract Tab getTab();
}
