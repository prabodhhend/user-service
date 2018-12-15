package org.acko.smartlife.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author prabodh.hend
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@Slf4j
@EnableTransactionManagement
public class JpaAuditingConfiguration {

    @Bean
    public AuditorAware<String> auditorProvider() {
        log.info("Audit aware listener");
        return () -> (SecurityContextHolder.getContext().getAuthentication() == null ? "system" : SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
    }

}

