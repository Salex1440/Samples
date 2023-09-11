package com.salex.structural.composite;

public class File extends AbstractFile {

    public File(String name) {
        super(name);
    }

    @Override
    public String display() {
        return "\t".repeat(lvl) + name;
    }

    @Override
    protected void setLevel(Integer lvl) {
        this.lvl = lvl;
    }
}
