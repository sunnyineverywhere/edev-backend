package api.edev.global.config;

import api.edev.domain.member.storage.AuthMemberArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final AuthMemberArgumentResolver authMemberArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
        argumentResolvers.add(authMemberArgumentResolver);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000/")
                .allowedOrigins("https://edev-sunnyineverywhere.vercel.app/")
                .allowedOrigins("https://edev.co.kr/")
                .allowedOrigins("https://www.edev.co.kr/")
                .allowedMethods(HttpMethod.GET.name())
                .allowedMethods(HttpMethod.POST.name())
                .allowedMethods(HttpMethod.PUT.name())
                .allowedMethods(HttpMethod.DELETE.name())
                .allowedHeaders("Authorization")
                .allowedHeaders("refresh-token")
                .allowCredentials(true);
    }
}
