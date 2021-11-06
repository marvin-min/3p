package com.sb;

import com.sb.model.Pet;
import com.sb.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class SbApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run =  SpringApplication.run(SbApplication.class, args);
        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        User user = run.getBean(User.class);
        Pet pet = run.getBean(Pet.class);
        System.out.println(user.getPet() == pet);

        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha："+haha);//true
        System.out.println("hehe："+hehe);//true
    }

    @Bean("tom11")
    @ConditionalOnMissingBean(name = "tomcat")
    public String tomcatPet(){
        return "tomcat";
    }

}
