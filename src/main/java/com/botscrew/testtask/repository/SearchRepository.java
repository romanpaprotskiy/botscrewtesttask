package com.botscrew.testtask.repository;

import java.util.List;

public interface SearchRepository {

    List<Object> findByNameLike(String template);
}
