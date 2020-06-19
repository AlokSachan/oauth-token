package com.user.service.security.oauth;

import com.user.service.Constants;
import com.user.service.response.UserResponseBean;
import com.user.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidRequestException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class TokenEnhancerImpl implements TokenEnhancer {

    @Autowired
    private UserService userService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        OAuth2AccessTokenResponse defaultOAuth2AccessToken = new OAuth2AccessTokenResponse(accessToken);
        UserResponseBean userResponseBean = null;
            User user = (User) authentication.getPrincipal();
            try {
                userResponseBean = userService.getUserByEmail(user.getUsername());
            } catch (Exception e) {
                log.error("User not found by email {}", user.getUsername());
            }
        Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put(Constants.USER_INFO_KEY, userResponseBean);

        defaultOAuth2AccessToken.getAdditionalInformation().putAll(additionalInfo);

        return defaultOAuth2AccessToken;    }
}
