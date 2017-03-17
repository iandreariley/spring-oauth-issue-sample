package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Basic details service.
 */
@Component
public class TheClientDetailsService implements ClientDetailsService {

    Logger logger = LoggerFactory.getLogger("DEBUG");

    @PostConstruct
    public void init() {
        logger.warn("*** INITIALIZING CLIENT DETAILS SERVICE ***");
    }

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        if (s.equals("acme"))
            return new ThePrincipal("acme", "acmesecret");
        return null;
    }
}
