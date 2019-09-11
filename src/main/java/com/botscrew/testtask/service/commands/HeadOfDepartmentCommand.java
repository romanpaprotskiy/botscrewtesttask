package com.botscrew.testtask.service.commands;

import com.botscrew.testtask.service.AbstractCommand;
import org.springframework.stereotype.Component;

@Component
public class HeadOfDepartmentCommand extends AbstractCommand {

    private final HeadOfDepartmentNextCommand command;

    public HeadOfDepartmentCommand(HeadOfDepartmentNextCommand command) {
        text = "head";
        root = true;
        this.command = command;
    }

    @Override
    public String execute(String sentence) {
        boolean isFound = sentence.contains(text);
        if (!isFound) return null;
        return command.execute(sentence);
    }
}
