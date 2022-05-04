package ind.milo.demo.gof.command.command;

import java.util.Iterator;
import java.util.Stack;

/**
 * 由多条命令整合而成的命令
 */
public class MacroCommand implements Command {
    private Stack<Command> commands = new Stack<>();
    @Override
    public void execute() {
        Iterator<Command> iterator = commands.iterator();
        while (iterator.hasNext()) {
            iterator.next().execute();
        }
    }

    public void append(Command command) {
        // 防止加入自己，从而陷入死循环
        if (command != this) {
            commands.push(command);
        }
    }

    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }

    public void clear() {
        commands.clear();
    }
}
