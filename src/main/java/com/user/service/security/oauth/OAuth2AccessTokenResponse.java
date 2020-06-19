package com.user.service.security.oauth;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class OAuth2AccessTokenResponse extends DefaultOAuth2AccessToken {
    public OAuth2AccessTokenResponse(String value) {
        super(value);
    }

    public OAuth2AccessTokenResponse(OAuth2AccessToken accessToken) {
        super(accessToken);
    }
}
