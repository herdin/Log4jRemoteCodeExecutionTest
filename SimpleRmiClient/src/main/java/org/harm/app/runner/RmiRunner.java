package org.harm.app.runner;

import lombok.extern.slf4j.Slf4j;
import org.harm.app.service.RmiHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RmiRunner implements ApplicationRunner {
    @Autowired
    RmiHelloService rmiHelloService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("rmi runner start");
        rmiHelloService.invokeRmiHello("test-name");
        log.info("rmi runner end");
    }
}
