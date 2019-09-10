package com.botscrew.testtask.service.impl;

import com.botscrew.testtask.service.Command;
import com.botscrew.testtask.service.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommandExecutorImpl implements CommandExecutor {

    @Autowired
    private List<Command> commands = new ArrayList<>();

    @PostConstruct
    public void init() {
        commands = commands.stream().filter(Command::isRoot).collect(Collectors.toList());
    }

    public void appendCommands(List<Command> commands) {
        this.commands.addAll(commands);
    }

    @Override
    public String execute(String sentence) {
        if (commands.isEmpty()) return "None commands";
        List<String> results = new ArrayList<>();
        for (Command command : commands) {
            results.add(command.execute(sentence));
        }
        List<String> filtered = results.stream().filter(Objects::nonNull).collect(Collectors.toList());
        if (filtered.isEmpty()) return "Any non match";
        if (filtered.size() > 1) return "Too much results";
        return filtered.get(0);
    }
}
