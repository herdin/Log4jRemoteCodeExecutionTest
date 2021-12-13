package org.harm.app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RmiHelloService {
    @Autowired
    private HelloService helloService;
//    @Autowired
//    public void setHelloService(HelloService helloService) {
//        this.helloService = helloService;
//    }

    public void invokeRmiHello(String name) {
        String softResult = helloService.softHello(name);
        String hardResult = helloService.hardHello(name);
        log.info("soft : {}", softResult);
        log.info("hard : {}", hardResult);
    }
}
