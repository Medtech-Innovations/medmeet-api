package org.medtech.medmeet.contact.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("contactMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public DetailMapper detailMapper() {return new DetailMapper();}
}
