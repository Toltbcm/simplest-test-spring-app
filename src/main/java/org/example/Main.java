package org.example;

import org.example.config.AppConfig;
import org.example.model.EntityOne;
import org.example.service.EntityOneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EntityOneService entityOneService = context.getBean(EntityOneService.class);

        EntityOne entityOne = new EntityOne();
        entityOne.setColumnOne("Test data");
        entityOne.setColumnTwo(777);

        System.out.println(entityOneService.save(entityOne));
    }
}
