package com.TextEditor.editor.command;

import com.TextEditor.editor.core.Clipboard;
import com.TextEditor.editor.core.TextEditor;

public class CopyCommand implements Command {
    private final TextEditor editor;
    private final Clipboard clipboard;

    public CopyCommand(TextEditor editor, Clipboard clipboard) {
        this.editor = editor;
        this.clipboard = clipboard;
    }

    @Override
    public void execute() {
        clipboard.setText(editor.copy(5));
    }

    @Override
    public void undo() {
        // No-op for copy
    }
}