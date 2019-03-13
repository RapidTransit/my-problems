package my.problems;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Something {

    @JsonProperty
    protected String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
