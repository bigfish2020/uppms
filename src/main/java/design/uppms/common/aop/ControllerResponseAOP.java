package design.uppms.common.aop;

import design.uppms.config.properties.CodeMessageProperties;
import design.uppms.model.vo.MessageResponseVO;
import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerResponseAOP {
    @Autowired(required = false)
    private CodeMessageProperties codeMessage;

    @AfterReturning(returning = "messageResponseVO",pointcut = "execution (* design.uppms.controller..*.*(..))")
    public void  afterReturning(MessageResponseVO messageResponseVO){
        if (messageResponseVO==null){
            return;
        }
        int code = messageResponseVO.getCode();
        String oldCodeMessage=messageResponseVO.getMessage();
        String newCodeMessage=codeMessage.getCodeMessage().get(code);
        if (Strings.isEmpty(oldCodeMessage)) {
            messageResponseVO.setMessage(newCodeMessage);
        }
    }
}
