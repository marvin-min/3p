package com.sb.conf;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@ImportResource("classpath:beans.xml") //用来导入外部配置文件的配置。需要放在bean上才生效
//@Component
public class ImportResourceConf {
}
