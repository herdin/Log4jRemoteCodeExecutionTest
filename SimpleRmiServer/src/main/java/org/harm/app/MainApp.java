package org.harm.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.Naming;
import java.util.Optional;

@Slf4j
@SpringBootApplication
@RestController
public class MainApp {
    public static void main(String[] args) {
//        Naming.lookup("HelloService")
        SpringApplication.run(MainApp.class);
    }

    @GetMapping(value = { "/healthcheck", "/healthcheck/{name}"})
    public ResponseEntity hello(@PathVariable(required = false, value = "name") Optional<String> name) {
        log.info("hello, {}", name.orElse("me"));
        return ResponseEntity.ok().build();
    }
}
