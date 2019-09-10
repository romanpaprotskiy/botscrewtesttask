package com.botscrew.testtask.controller;

import com.botscrew.testtask.controller.payload.Request;
import com.botscrew.testtask.controller.payload.Response;
import com.botscrew.testtask.service.CommandExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class CommandController {

    private final CommandExecutor commandExecutor;

    public CommandController(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @PostMapping("/dialog")
    public ResponseEntity dialog(@RequestBody Request request) {
        String executed = commandExecutor.execute(request.getSentence());
        return ResponseEntity.ok(new Response(executed));
    }
}
