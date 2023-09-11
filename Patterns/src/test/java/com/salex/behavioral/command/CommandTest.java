package com.salex.behavioral.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void test() {
        Command command = new CommandImpl(new Foo());

        command.execute();
    }
}