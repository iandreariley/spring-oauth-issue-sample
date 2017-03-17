package com.example;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.*;

/**
 * Basic {@link Principal} object;
 */
public class ThePrincipal implements Principal, ClientDetails {

    private String name;
    private String password;

    public ThePrincipal(@NotNull String name, @NotNull String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @Override
    public String getClientId() {
        return name;
    }

    @Override
    public Set<String> getResourceIds() {
        return Collections.emptySet();
    }

    @Override
    public boolean isSecretRequired() {
        return false;
    }

    @Override
    public String getClientSecret() {
        return password;
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return new HashSet<String>(){{ add("everything"); }};
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return new HashSet<String>(){{
            add("password");
            add("client_credentials");
        }};
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return Collections.emptySet();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return TheUserDetails.authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return 1000000000;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return 1000000000;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return Collections.emptyMap();
    }
}
