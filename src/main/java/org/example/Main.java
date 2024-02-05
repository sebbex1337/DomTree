package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Tag> tags = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            HTag htag = new HTag(1, "hej" + i);
            htag.setId(htag.getText());
            tags.add(htag);
            PTag ptag = new PTag("Hejx" +i);
            ptag.setId(ptag.getText());
            tags.add(ptag);
        }

        System.out.println(tags);
        Collections.sort(tags);
        System.out.println(tags);
    }
}