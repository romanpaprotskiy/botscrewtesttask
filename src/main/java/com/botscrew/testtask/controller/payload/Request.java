package com.botscrew.testtask.controller.payload;

import java.io.Serializable;
import java.util.Objects;

public class Request implements Serializable {

    private static final long serialVersionUID = -4942634844171955037L;

    private String sentence;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return "Request{" +
                "sentence='" + sentence + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(sentence, request.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence);
    }
}
