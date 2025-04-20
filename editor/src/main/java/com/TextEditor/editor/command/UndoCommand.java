package com.TextEditor.editor.command;

import java.util.Stack;

public class UndoCommand {
    private final Stack<Command> history = new Stack<>();

    public void execute(Command cmd) {
        cmd.execute();
        history.push(cmd);
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command last = history.pop();
            last.undo();
        }
    }
}
