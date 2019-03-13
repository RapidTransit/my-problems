package my.problems;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImmutablePojo {

    @JsonProperty
    private final String response;

    private ImmutablePojo(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public static ImmutablePojo of(String response){
        return new ImmutablePojo(response);
    }
}
