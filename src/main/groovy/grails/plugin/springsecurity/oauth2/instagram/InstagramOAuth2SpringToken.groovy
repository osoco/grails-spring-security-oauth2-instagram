package grails.plugin.springsecurity.oauth2.instagram

import com.github.scribejava.core.model.OAuth2AccessToken
import grails.plugin.springsecurity.oauth2.token.OAuth2SpringToken

class InstagramOauth2SpringToken extends OAuth2SpringToken{

    private String socialId
    private String username
    private String providerId

    InstagramOauth2SpringToken(OAuth2AccessToken accessToken, String username, String providerId) {
        super(accessToken)
        this.username = username
        this.providerId = providerId
    }

    @Override
    String getProviderName() {
        return providerId
    }

    @Override
    String getSocialId() {
        return socialId
    }

    @Override
    String getScreenName() {
        return username
    }
}