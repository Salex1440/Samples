package com.salex.solid.O.bad.example;

public class Npc {

    private String npcType;

    public Npc(String npcType) {
        this.npcType = npcType;
    }

    public void greet() {
        if (npcType.equals("peasant")) {
            System.out.println("My lord");
        } else if (npcType.equals("blacksmoth")) {
            System.out.println("Hello, do you need a new armor?");
        } else if (npcType.equals("bishop")) {
            System.out.println("Bless you");
        }
    }

}
