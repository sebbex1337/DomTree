package org.example;

public class SpanTag extends Tag {

    public SpanTag() {
        this.setTagName("span");
    }
    public SpanTag(String text) {
        this();
        super.setText(text);
    }

    public boolean hasLineShift() {
        return false;
    }

}
