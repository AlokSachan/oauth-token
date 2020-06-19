package com.user.service.security;

import com.user.service.security.oauth.ResourceServerConfig;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

@Component
public class ClientDetailsServiceImpl implements ClientDetailsService {
    @Value("${client.id}")
    private String clientId;

    @Value("${client.secret}")
    private String clientSecret;

    @Value("${oauth.granttype}")
    private String greantType;

    @Value("${oauth.authorities}")
    private String authorities;

    @Value("${oauth.scope}")
    private String scope;
    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        BaseClientDetails baseClientDetails = new BaseClientDetails(clientId,
                ResourceServerConfig.RESOURCE_ID, scope, greantType, authorities);
        baseClientDetails.setClientSecret(clientSecret);
        return baseClientDetails;
    }
}
