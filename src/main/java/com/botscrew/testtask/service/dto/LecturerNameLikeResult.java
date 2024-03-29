package com.botscrew.testtask.service.dto;

import java.io.Serializable;
import java.util.Objects;

public class LecturerNameLikeResult implements Serializable {

    private static final long serialVersionUID = -6502142255986007186L;

    private String firstName;

    private String lastName;

    public LecturerNameLikeResult(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LecturerNameLikeResult that = (LecturerNameLikeResult) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return firstName  + " " +  lastName + "\n";


    }
}
