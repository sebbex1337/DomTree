package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Tag implements Comparable<Tag> {
    private static int nextId = 0;
    private String id;
    private String tagName;
    private String text;
    private List<Tag> children;
    private String color = ""; // #141414

    public Tag() {
        id = "" + Tag.nextId++;
        children = new ArrayList<>();
    }

    @Override
    public int compareTo(Tag o) {
        return this.getId().compareTo(o.getId());
    }

    public String getColor() {
        return color;
    }

    public void setColor(int red, int green, int blue) {
        red = Math.min(255, Math.max(0, red));
        green = Math.min(255, Math.max(0, green));
        blue = Math.min(255, Math.max(0, blue));

        this.setColor(String.format("#%02X%02X%02X", red, green, blue));
    }

    public static String rgbToColorString(int red, int green, int blue) {
        red = Math.min(255, Math.max(0, red));
        green = Math.min(255, Math.max(0, green));
        blue = Math.min(255, Math.max(0, blue));

        return String.format("#%02X%02X%02X", red, green, blue);
    }

    public void setColor(String color) {
        this.color = color;
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

    public String toHTMLStringNoChildren() {
        String s1 = "<" + tagName + ">";
        s1 += text + "</" + tagName + ">";
        return s1;
    }

    public boolean hasLineShift() {
        return true;
    }

    public String toHTMLString() {
        String s1 = "<" + tagName;
        if (this.getColor().length() > 0) {
            s1 += " style=\"background-color:" + this.getColor() + "\"";
        }
        s1 += ">";
        for (Tag tag: children) {
            String child = tag.toHTMLString();
            if (this.hasLineShift()) {
                s1 += "\n" + child;
            } else {
                s1 += child;
            }
        }
        s1 += text + "</" + tagName + ">";
        return s1;
    }

    public String toHTMLStringFile(String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(this.toHTMLString());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
