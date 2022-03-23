package com.zzl.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MPConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        System.out.println("hello!!!!!!  ysj");
        System.out.println("hello!!!!!!  ysj");
        System.out.println("hello!!!!!!  ysj");
        System.out.println("hto fix commit");
        System.out.println("push test");
        System.out.println("pull test");
        System.out.println("github更新了");
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }

}
