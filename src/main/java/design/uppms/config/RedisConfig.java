package design.uppms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Integer> personRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Integer> template = new RedisTemplate<Object, Integer>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Integer> serializer = new Jackson2JsonRedisSerializer<Integer>(Integer.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

}
