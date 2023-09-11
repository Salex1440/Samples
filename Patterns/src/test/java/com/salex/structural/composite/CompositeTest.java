package com.salex.structural.composite;

import org.junit.jupiter.api.Test;

class CompositeTest {

    @Test
    public void test() {
        Folder root = new Folder("root");
        Folder docs = new Folder("docs");
        File doc1 = new File("doc1.txt");
        File doc2 = new File("doc2.txt");
        Folder trash = new Folder("trash");
        File trash1 = new File("trash1.txt");
        Folder pics = new Folder("pics");
        File pic1 = new File("pic1.png");
        root.add(docs);
        docs.add(doc1);
        docs.add(doc2);
        docs.add(trash);
        trash.add(trash1);
        root.add(pics);
        pics.add(pic1);

        System.out.println(root.display());
    }

}