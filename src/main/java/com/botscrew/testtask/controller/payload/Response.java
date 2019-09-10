package com.botscrew.testtask.controller.payload;

import java.io.Serializable;
import java.util.Objects;

public class Response implements Serializable {

    private static final long serialVersionUID = 6538682098024326335L;

    private String text;

    public Response(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Response{" +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(text, response.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
