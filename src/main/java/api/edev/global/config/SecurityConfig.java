package api.edev.global.config;

import api.edev.global.jwt.JwtFilter;
import api.edev.global.jwt.JwtProvider;
import api.edev.global.oauth.CustomOAuth2UserService;
import api.edev.global.oauth.HttpCookieOAuth2AuthorizationRequestRepository;
import api.edev.global.oauth.OAuth2FailureHandler;
import api.edev.global.oauth.OAuth2SuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOauth2UserService;
    private final JwtProvider jwtProvider;
    private final OAuth2SuccessHandler successHandler;
    private final OAuth2FailureHandler failureHandler;
    private final HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .headers().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().formLogin().disable()
                .httpBasic().disable()
                .authorizeHttpRequests()
                .requestMatchers("/").permitAll()
                .requestMatchers("/members").permitAll()
                .requestMatchers("/**").permitAll()
                .anyRequest().permitAll();

        httpSecurity.oauth2Login()
                .authorizationEndpoint()
                .authorizationRequestRepository(httpCookieOAuth2AuthorizationRequestRepository)
                .and()
                .redirectionEndpoint()
                .and().userInfoEndpoint().userService(customOauth2UserService)
                .and()
                .successHandler(successHandler)
                .failureHandler(failureHandler);

        return httpSecurity
                .addFilterBefore(new JwtFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
