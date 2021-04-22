Spring Security OAuth2 Instagram Plugin
====================================

Add a Instagram OAuth2 provider to the [Spring Security OAuth2 Plugin](https://github.com/grails-plugins/grails-spring-security-oauth2)
for Grails 3.0 to 3.2 applications.

Installation
------------
Add the following dependencies in `build.gradle`
```
dependencies {
...
    compile 'org.grails.plugins:spring-security-oauth2:3.1.2'
    compile 'org.grails.plugins:spring-security-oauth2-instagram:1.0.+'
...
}
```

Usage
-----
Add this to your application.yml
```
grails:
    plugin:
        springsecurity:
            oauth2:
                providers:
                    instagram:
                        api_key: 'instagram-api-key'               #needed
                        api_secret: 'instagram-api-secret'         #needed
                        successUri: "/oauth2/instagram/success"    #optional
                        failureUri: "/oauth2/instagram/failure"    #optional
                        callback: "/oauth2/instagram/callback"     #optional
                        scopes: "some_scope"                     #optional, see https://developers.google.com/identity/protocols/googlescopes#monitoringv3
```
You can replace the URIs with your own controller implementation.

In your view you can use the taglib exposed from this plugin and from OAuth plugin to create links and to know if the user is authenticated with a given provider:
```xml
<oauth2:connect provider="instagram">instagram</oauth2:connect>

Logged with instagram?
<oauth2:ifLoggedInWith provider="instagram">yes</oauth2:ifLoggedInWith>
<oauth2:ifNotLoggedInWith provider="instagram">no</oauth2:ifNotLoggedInWith>
```

License
-------
Apache 2