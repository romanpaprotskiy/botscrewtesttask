package com.botscrew.testtask.service;

import java.util.Objects;

public abstract class AbstractCommand implements Command {

    protected String text;

    protected Command next;

    protected boolean root;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Command getNext() {
        return next;
    }

    public void setNext(Command next) {
        this.next = next;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "AbstractCommand{" +
                "text='" + text + '\'' +
                ", next=" + next +
                ", root=" + root +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCommand that = (AbstractCommand) o;
        return root == that.root &&
                Objects.equals(text, that.text) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, next, root);
    }
}
