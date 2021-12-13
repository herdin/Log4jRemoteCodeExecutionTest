package org.harm.app.config;

import org.harm.app.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class RmiClientConfig {
    @Bean
    public RmiProxyFactoryBean rmiProxyFactoryBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://192.168.1.6:10999/HelloService");
        rmiProxyFactoryBean.setServiceInterface(HelloService.class);
        return rmiProxyFactoryBean;
    }
}
