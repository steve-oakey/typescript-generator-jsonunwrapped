package ca.oakey.typescript.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Person {
    @JsonUnwrapped
    private Name name;

    public Name getName() {
        return name;
    }
}
