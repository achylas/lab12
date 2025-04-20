package com.TextEditor.editor.command;

import com.TextEditor.editor.core.Clipboard;
import com.TextEditor.editor.core.TextEditor;

public class PasteCommand implements Command {
    private final TextEditor editor;
    private final Clipboard clipboard;
    private String pastedText = "";

    public PasteCommand(TextEditor editor, Clipboard clipboard) {
        this.editor = editor;
        this.clipboard = clipboard;
    }

    @Override
    public void execute() {
        pastedText = clipboard.getText();
        editor.paste(pastedText);
    }

    @Override
    public void undo() {
        editor.cut(pastedText.length());
    }
}
