package com.softgroup.frontend.rest.configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.softgroup.authorization.impl.configuration.AuthorizationAppCfg;
import com.softgroup.common.dao.impl.configuration.DaoAppCfg;
import com.softgroup.common.router.impl.configuration.RouterAppCfg;
import com.softgroup.messenger.impl.configuration.MessengerAppCfg;
import com.softgroup.profile.impl.configuration.ProfileAppCfg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@WebAppConfiguration
@EnableWebMvc
@EnableSpringDataWebSupport
@ComponentScan("com.softgroup.frontend.rest")
@Import({ RouterAppCfg.class, AuthorizationAppCfg.class, ProfileAppCfg.class, MessengerAppCfg.class, DaoAppCfg.class})
public class RestAppCfg extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add( mappingJackson2HttpMessageConverter() );
        super.configureMessageConverters(converters);
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter( objectMapper() );
    }

    private ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
        mapper.configure( SerializationFeature.FAIL_ON_EMPTY_BEANS, false );
        mapper.setVisibility( PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY );
        mapper.setPropertyNamingStrategy( PropertyNamingStrategy.SNAKE_CASE );
        mapper.setSerializationInclusion( JsonInclude.Include.NON_NULL );
        return mapper;
    }
}