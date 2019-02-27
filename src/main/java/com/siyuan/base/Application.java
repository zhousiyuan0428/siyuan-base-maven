package com.siyuan.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.siyuan.base.dao.mapper")
public class Application {

//    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
//
//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate){
//        return args -> {
//            Quote quote = restTemplate.getForObject(
//                    "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//            logger.info(quote.toString());
//        };
//    }
}
