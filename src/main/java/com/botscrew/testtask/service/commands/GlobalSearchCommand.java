package com.botscrew.testtask.service.commands;

import com.botscrew.testtask.service.AbstractCommand;
import com.botscrew.testtask.service.SearchService;
import com.botscrew.testtask.service.util.StringUtil;
import org.springframework.stereotype.Service;

@Service
public class GlobalSearchCommand extends AbstractCommand {

    private final SearchService searchService;

    public GlobalSearchCommand(SearchService searchService) {
        this.searchService = searchService;
        text = "search";
        root = true;
    }

    @Override
    public String execute(String sentence) {
        boolean isFound = sentence.contains(text);
        if (!isFound) return null;
        String template = StringUtil.getKeyAfter(sentence, "by");
        return searchService.search(template);
    }


}
