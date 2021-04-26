package grails.plugin.springsecurity.oauth2.instagram

import com.github.scribejava.apis.InstagramApi
import com.github.scribejava.core.builder.api.DefaultApi10a
import com.github.scribejava.core.model.Token
import grails.converters.JSON
import grails.plugin.springsecurity.oauth2.exception.OAuth2Exception
import grails.plugin.springsecurity.oauth2.service.OAuth2AbstractProviderService
import grails.plugin.springsecurity.oauth2.token.OAuth2SpringToken
import grails.transaction.Transactional

@Transactional
class InstagramOAuth2Service extends OAuth2AbstractProviderService {

    @Override
    String getProviderID() {
        return 'instagram'
    }

    @Override
    Class<? extends DefaultApi10a> getApiClass() {
        InstagramApi.class
    }

    @Override
    String getProfileScope() {
        return 'https://graph.instagram.com/me?fields=id,username'
    }


    @Override
    String getScopes() {
        return 'user_profile,user_media'
    }

    @Override
    String getScopeSeparator() {
        return ','
    }

    @Override
    OAuth2SpringToken createSpringAuthToken(Token accessToken) {
        def user
        def response = getResponse(accessToken)
        try {
            log.debug("JSON response body: " + accessToken.rawResponse)
            user = JSON.parse(response.body)
        } catch (Exception exception) {
            log.error("Error parsing response from " + getProviderID() + ". Response:\n" + response.body)
            throw new OAuth2Exception("Error parsing response from " + getProviderID(), exception)
        }
        if (!user?.username) {
            log.error("No user username from " + getProviderID() + ". Response was:\n" + response.body)
            throw new OAuth2Exception("No user username from " + getProviderID())
        }
        new InstagramOauth2SpringToken(accessToken, user.username, providerID)
    }

}