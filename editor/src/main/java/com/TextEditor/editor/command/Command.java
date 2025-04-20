package com.TextEditor.editor.command;

public interface Command {
    void execute();
    void undo();
}
