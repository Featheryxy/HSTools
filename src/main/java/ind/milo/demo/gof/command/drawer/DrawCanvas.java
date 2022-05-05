package ind.milo.demo.gof.command.drawer;

import ind.milo.demo.gof.command.command.MacroCommand;

import java.awt.*;

/**
 *
 */
public class DrawCanvas extends Canvas implements Drawable{
    private Color color = Color.red;
    private int radius = 6;
    // 命令的历史记录
    private MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    @Override
    public void draw(int x, int y) {
        Graphics graphics = getGraphics();
        graphics.setColor(color);
        graphics.fillOval(x-radius, y-radius, radius*2, radius*2);
    }

    public void paint(Graphics graphics) {
        history.execute();
    }
}
