package be.ae.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> list() {
        //TODO
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<String> get(@PathVariable String id) {
        //TODO
        return ResponseEntity.ok(null);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(String body) {
        //TODO
        return ResponseEntity.created(null).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        //TODO
        return ResponseEntity.noContent().build();
    }
}