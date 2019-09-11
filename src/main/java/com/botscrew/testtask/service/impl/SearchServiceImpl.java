package com.botscrew.testtask.service.impl;

import com.botscrew.testtask.repository.SearchRepository;
import com.botscrew.testtask.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    private final List<SearchRepository> repositories;

    public SearchServiceImpl(List<SearchRepository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public String search(String template) {
        StringBuilder stringBuilder = new StringBuilder();
        for (SearchRepository repository : repositories) {
            List<Object> results = repository.findByNameLike(template);
            if (!results.isEmpty()) {
                results.forEach(s -> stringBuilder.append(s).append(' '));
            }
        }
        return stringBuilder.toString();
    }
}
