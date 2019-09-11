package com.botscrew.testtask.service.dto;

import java.io.Serializable;
import java.util.Objects;

public class StatisticDTO implements Serializable {

    private static final long serialVersionUID = 9092805967968382190L;

    private String fieldName;

    private int count;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return  fieldName + " = " + count + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticDTO that = (StatisticDTO) o;
        return Double.compare(that.count, count) == 0 &&
                Objects.equals(fieldName, that.fieldName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, count);
    }
}
