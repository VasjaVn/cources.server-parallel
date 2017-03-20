package com.softgroup.frontend.rest.configuration;

import com.softgroup.authorization.impl.configuration.AuthorizationAppCfg;
import com.softgroup.common.dao.impl.configuration.DaoAppCfg;
import com.softgroup.common.router.impl.configuration.RouterAppCfg;
import com.softgroup.messenger.impl.configuration.MessengerAppCfg;
import com.softgroup.profile.impl.configuration.ProfileAppCfg;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@ComponentScan("com.softgroup.frontend.rest")
@Import({ RouterAppCfg.class, AuthorizationAppCfg.class, ProfileAppCfg.class, MessengerAppCfg.class, DaoAppCfg.class})
public class RestAppCfg {
}
