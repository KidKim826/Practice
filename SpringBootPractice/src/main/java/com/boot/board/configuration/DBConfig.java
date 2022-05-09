package com.boot.board.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.boot.board.model.dao")
public class DBConfig {

}
