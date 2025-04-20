package com.TextEditor.editor.invoker;

import com.TextEditor.editor.command.Command;

public class EditorButton {
    private final Command command;

    public EditorButton(Command command) {
        this.command = command;
    }

    public void click() {
        command.execute();
    }
}