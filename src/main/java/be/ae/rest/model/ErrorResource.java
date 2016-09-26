package be.ae.rest.model;

import lombok.Data;

@Data
public class ErrorResource {
    private String id;
    private String message;

    public ErrorResource(String id, String message) {
        this.id = id;
        this.message = message;
    }
}
