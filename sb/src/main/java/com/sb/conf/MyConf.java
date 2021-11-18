package com.sb.conf;

import com.sb.model.Pet;
import com.sb.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//true 是Full Mode。 如果多个bean之间有依赖，要用Full mode。
//false 是Lite Mode, 如果多个bean之间没有依赖，用Lite mode
@Configuration(proxyBeanMethods = true)
public class MyConf {
    @Bean
    public User zhangSan(){
        User user = new User("张三");
        user.setPet(tomcat());
        return user;
    }

    @Bean(name = "tomcat")
    public Pet tomcat(){
        return new Pet("tomcat");
    }


}
