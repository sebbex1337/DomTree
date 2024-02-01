package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Tag> hTags = new ArrayList<>();
        for (int i = 1; i < 6;i++) {
            HTag hTag1 = new HTag(i);
            hTag1.setText("Jeg er et " + hTag1.getTagName() + " tag");
            hTags.add(hTag1);
            for (int j = 0; j <= 5; j++) {
                PTag ptag = new PTag("Jeg er et p tag inde i " + hTag1.getTagName());
                hTags.add(ptag);
            }
        }

        for (Tag tag: hTags) {
            //System.out.println(tag.toHTMLString());
        }

        BodyTag body = new BodyTag();
        body.setChildren(hTags);
        System.out.println(body);
    }
}