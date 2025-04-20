package com.TextEditor.editor.command;

import com.TextEditor.editor.core.Clipboard;
import com.TextEditor.editor.core.TextEditor;

public class CutCommand implements Command {
    private final TextEditor editor;
    private final Clipboard clipboard;
    private String backup = "";

    public CutCommand(TextEditor editor, Clipboard clipboard) {
        this.editor = editor;
        this.clipboard = clipboard;
    }

    @Override
    public void execute() {
        backup = editor.cut(5);
        clipboard.setText(backup);
    }

    @Override
    public void undo() {
        editor.paste(backup);
    }
}