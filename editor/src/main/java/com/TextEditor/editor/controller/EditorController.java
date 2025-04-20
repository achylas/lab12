package com.TextEditor.editor.controller;

import com.TextEditor.editor.command.*;
import com.TextEditor.editor.core.Clipboard;
import com.TextEditor.editor.core.TextEditor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editor")
public class EditorController {

    private final TextEditor editor = new TextEditor();
    private final Clipboard clipboard = new Clipboard();
    private final UndoCommand undoManager = new UndoCommand();

    @PostMapping("/write")
    public String write(@RequestParam String text) {
        editor.write(text);
        return editor.getContent();
    }

    @PostMapping("/cut")
    public String cut() {
        Command cut = new CutCommand(editor, clipboard);
        undoManager.execute(cut);
        return editor.getContent();
    }

    @PostMapping("/copy")
    public String copy() {
        Command copy = new CopyCommand(editor, clipboard);
        copy.execute();
        return "[Copied]: " + clipboard.getText();
    }

    @PostMapping("/paste")
    public String paste() {
        Command paste = new PasteCommand(editor, clipboard);
        undoManager.execute(paste);
        return editor.getContent();
    }

    @PostMapping("/undo")
    public String undo() {
        undoManager.undo();
        return "[Undo]: " + editor.getContent();
    }

    @GetMapping("/status")
    public String status() {
        return "[Text]: " + editor.getContent() + " | [Clipboard]: " + clipboard.getText();
    }
}