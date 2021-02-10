package design.uppms.common.Interceptor;

import design.uppms.model.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 拦截器
 * 用于验证用户的合法性
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate<Object, Integer> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String Token = request.getHeader("Token");

        //在redis中查询，如果有该用户，则合法
        Integer integer = redisTemplate.opsForValue().get(Token);
        if (integer != null){
            //合法
            //重置过期时间,保证用户登录后只要是在操作就不会过期，登陆后不操作1小时过期
            redisTemplate.expire(Token,1L, TimeUnit.HOURS);
            System.out.println("放行");
            return true;
        }else {
            System.out.println("拦截");
            return false;
        }
    }
}
