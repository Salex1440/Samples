package com.salex.behavioral.command;

public class CommandImpl implements Command {

    private final Foo foo;

    public CommandImpl(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void execute() {
        foo.bar();
    }

}
