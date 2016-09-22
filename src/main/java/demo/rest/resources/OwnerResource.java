package demo.rest.resources;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
public class OwnerResource extends ResourceSupport {
    private String firstName;
    private String name;
}
