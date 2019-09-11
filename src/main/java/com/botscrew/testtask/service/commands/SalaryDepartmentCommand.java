package com.botscrew.testtask.service.commands;

import com.botscrew.testtask.service.AbstractCommand;
import com.botscrew.testtask.service.Command;
import com.botscrew.testtask.service.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SalaryDepartmentCommand extends AbstractCommand {

    private final AverageSalaryDepartmentCommand averageCommand;

    private final List<Command> commands = new ArrayList<>();

    public SalaryDepartmentCommand(AverageSalaryDepartmentCommand averageCommand) {
        this.averageCommand = averageCommand;
        text = "salary";
        root = true;
        commands.addAll(Arrays.asList(averageCommand));
    }

    @Override
    public String execute(String sentence) {
        boolean isFound = sentence.contains(text);
        if (!isFound) return null;
        String key = StringUtil.getKeyBefore(sentence, text);
        return averageCommand.execute(sentence);
    }
}
