package org.example.demo.ticket.batch.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "*")
public class SpringJavaConfigurator {

    @Qualifier("config")
    @Autowired
    @Lazy
    private SystemSettings systemSettings;

    @Autowired
    private Environment env;

    // @Value("${app.displayname}")
    //public String appDisplayName;

    @Bean
    public SystemSettings getSystemSettings() {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        SystemSettings mybean=(SystemSettings)ctx.getBean("config");
        //String dateFormat = env.getProperty("system.date-format");
        //String appDisplayName = env.getProperty("app.displayname");
        String appDisplayName = mybean.getMyrep();
        System.out.println("appDisplayName="+appDisplayName);

        return new SystemSettings(appDisplayName);

    }

}

