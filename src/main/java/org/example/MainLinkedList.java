package org.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainLinkedList {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        List<Tag> tags = new LinkedList<>();
        for (int i = 1; i <= 200000; i++) {
            HTag htag = new HTag(1);
            PTag ptag = new PTag("Jeg er et pTag");
            tags.add(htag);
            tags.add(ptag);
        }
        long end = System.currentTimeMillis();
        System.out.println(tags.size());
        System.out.println("loop1 = " + (end-start));


        Iterator<Tag> it = tags.iterator();
        while (it.hasNext()) {
            Tag tag = it.next();
            if (tag instanceof HTag) {
                it.remove();
            }
        }
//        for (int i = 0; i < tags.size(); i++) {
//            if (tags.get(i) instanceof HTag) {
//                tags.remove(i);
//            }
//        }
        long deleteEnd = System.currentTimeMillis();
        System.out.println(tags.size());
        System.out.println("loop2 = " + (deleteEnd - end));
    }
}
