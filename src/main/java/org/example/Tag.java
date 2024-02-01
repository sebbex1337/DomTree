package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Tag {
    private String id;
    private String tagName;
    private String text;
    private List<Tag> children;

    public Tag() {
        children = new ArrayList<>();
    }

    public List<Tag> getChildren() {
        return children;
    }

    public void setChildren(List<Tag> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", tagName='" + tagName + '\'' +
                ", text='" + text + '\'' + this.children.size() +
                '}';
    }

    public String toHTMLString() {
        String s1 = "<" + tagName + ">";
        s1 += text + "</" + tagName + ">";
        return s1;
    }
}
