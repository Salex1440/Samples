package com.salex.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends File {

    private final List<AbstractFile> context = new ArrayList<>();

    protected Folder(String name) {
        super(name);
    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t".repeat(lvl)).append("*").append(name);
        for (AbstractFile file : context) {
            sb.append("\n").append(file.display());
        }
        return sb.toString();
    }

    public void add(AbstractFile file) {
        file.setLevel(lvl + 1);
        context.add(file);
    }

    public void remove(AbstractFile file) {
        context.remove(file);
    }

}
