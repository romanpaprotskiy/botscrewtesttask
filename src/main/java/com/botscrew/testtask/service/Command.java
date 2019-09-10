package com.botscrew.testtask.service;

public interface Command {

    String execute(String sentence);

    boolean isRoot();
}
