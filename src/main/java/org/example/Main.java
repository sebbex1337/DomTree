package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Tag> tags = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            HTag htag = new HTag(i);
            PTag ptag = new PTag("Jeg er et pTag");
            tags.add(htag);
            tags.add(ptag);
        }
        System.out.println(tags);
    }
}