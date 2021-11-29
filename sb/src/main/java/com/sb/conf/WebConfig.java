package com.sb.conf;

import com.sb.model.Pet;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration(proxyBeanMethods = false)
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer){
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        pathMatchConfigurer.setUrlPathHelper(urlPathHelper);
    }

    //自定义数据绑定器
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, Pet>() {
            @Override
            public Pet convert(String source) {
                if(StringUtils.hasText(source)){
                    Pet pet = new Pet();
                    pet.setName(source.split(",")[0]);
                    pet.setAge(Integer.parseInt(source.split(",")[1]));
                    return pet;
                }
                return null;
            }
        });
    }
}
