package kr.re.keti.disposable.taskservice.category;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Type {

    SERVICE("Service"),
    MICROSERVICE("MicroService"),
    DEVICE("Device");

    private String name;

    Type(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static Type getString(String name) {
        return Arrays.stream(Type.values())
                .filter(v -> v.name().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No matching constant for [" + name + "]"));
    }
}
