package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Tag> hTags = new ArrayList<>();
        for (int i = 1; i < 6;i++) {
            HTag hTag1 = new HTag(i);
            hTag1.setText("Jeg er et " + hTag1.getTagName() + " tag");
            hTag1.setColor(230, 150,15);
            hTags.add(hTag1);
            for (int j = 0; j <= 5; j++) {
                PTag ptag = new PTag("Jeg er et p tag inde i " + hTag1.getTagName());
                ptag.setColor(100,100,25);
                hTags.add(ptag);
            }
        }

        for (Tag tag: hTags) {
            //System.out.println(tag.toHTMLString());
        }

        BodyTag body = new BodyTag();
        body.setChildren(hTags);

        System.out.println(body.toHTMLString());
        body.setColor(255,10,15);
        body.toHTMLStringFile("index.html");
        System.out.println(body);
    }
}