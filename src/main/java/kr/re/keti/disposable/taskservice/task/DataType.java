package kr.re.keti.disposable.taskservice.task;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum DataType {

    INTEGER32("000"),
    FLOAT("001");

    private String code;
    DataType(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    @JsonCreator
    public static DataType getString(String code) {
        return Arrays.stream(DataType.values())
                .filter(v -> v.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No matching constant for [" + code + "]"));
    }
}
