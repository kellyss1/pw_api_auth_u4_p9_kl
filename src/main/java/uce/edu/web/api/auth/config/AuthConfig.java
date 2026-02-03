package uce.edu.web.api.auth.config;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "auth")
public interface AuthConfig {
    String issuer();

    @WithName("token.ttl")
    long tokenTtl();

}
