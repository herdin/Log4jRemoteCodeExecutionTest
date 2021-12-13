package org.harm.app.config;

import org.harm.app.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class RmiServerConfig {

    @Autowired
    HelloService helloService;
    @Bean
    public RmiServiceExporter rmiServiceExporter() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("HelloService");
        rmiServiceExporter.setService(helloService);
        rmiServiceExporter.setServiceInterface(HelloService.class);
//        rmiServiceExporter.setServicePort(12345);
        rmiServiceExporter.setRegistryPort(10999);//default 1099
        return rmiServiceExporter;
    }
}
