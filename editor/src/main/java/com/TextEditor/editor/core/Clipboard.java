package com.TextEditor.editor.core;

public class Clipboard {
    private String text = "";

    public void setText(String t) {
        text = t;
    }

    public String getText() {
        return text;
    }
}