package org.harm.app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String softHello(String name) {
        log.info("soft hello, {}", name);
        return "soft hello, " + name;
    }

    @Override
    public String hardHello(String name) {
        log.info("hard hello, {}", name);
        return "hard hello, " + name;
    }
}
