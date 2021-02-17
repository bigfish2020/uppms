package design.uppms.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import design.uppms.common.Interceptor.MyInterceptor;
import design.uppms.jackson.LocalDateTimeDeserializer;
import design.uppms.jackson.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

@Configuration
public class MySpringMVConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;
    @Autowired
    private LocalDateTimeSerializer localDateTimeSerializer;

    @Autowired
    private LocalDateTimeDeserializer localDateTimeDeserializer;

    /**
     * 跨域
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.setAllowCredentials(true);
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        return new CorsFilter(configSource);
    }


    /**
     * 添加路径拦截
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }


    /**
     * 注册拦截器，也就是使自己的拦截器生效
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/LoginRegiste/Registe");
    }



    /**
     * 配置 Jackson
     *
     * @param converters 消息转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Iterator<HttpMessageConverter<?>> iterator = converters.iterator();
        while(iterator.hasNext()){
            HttpMessageConverter<?> converter = iterator.next();
            if(converter instanceof MappingJackson2HttpMessageConverter){
                iterator.remove();
            }
        }
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder
                .json()
                // 属性为 null 时不进行序列化
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                // 指定 LocalDateTime 序列化器
                .serializers(localDateTimeSerializer)
                // 指定 LocalDateTime 反序列化器
                .deserializers(localDateTimeDeserializer)
                .build();

        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);

        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
        converters.add(stringHttpMessageConverter);
    }
}

