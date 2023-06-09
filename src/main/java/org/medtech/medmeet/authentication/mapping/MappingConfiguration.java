package org.medtech.medmeet.authentication.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("authenticationMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }
}
