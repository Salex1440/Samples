package com.salex.solid.O.bad.example;

public class Npc {

    public void greet(String npcType) {
        if (npcType.equals("peasant")) {
            System.out.println("My lord");
        } else if (npcType.equals("blacksmoth")) {
            System.out.println("Hello, do you need a new armor?");
        } else if (npcType.equals("bishop")) {
            System.out.println("Bless you");
        }
    }

}
