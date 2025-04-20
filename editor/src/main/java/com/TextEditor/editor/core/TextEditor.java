package com.TextEditor.editor.core;

public class TextEditor {
    private StringBuilder content = new StringBuilder();
    private int cursorPosition = 0;

    public void write(String text) {
        content.insert(cursorPosition, text);
        cursorPosition += text.length();
    }

    public String cut(int length) {
        int start = Math.max(0, cursorPosition - length);
        String cutText = content.substring(start, cursorPosition);
        content.delete(start, cursorPosition);
        cursorPosition = start;
        return cutText;
    }

    public String copy(int length) {
        int start = Math.max(0, cursorPosition - length);
        return content.substring(start, cursorPosition);
    }

    public void paste(String text) {
        write(text);
    }

    public void setCursorPosition(int pos) {
        cursorPosition = Math.min(pos, content.length());
    }

    public String getContent() {
        return content.toString();
    }

    public int getCursorPosition() {
        return cursorPosition;
    }
}