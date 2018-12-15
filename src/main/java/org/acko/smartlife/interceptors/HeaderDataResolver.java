package org.acko.smartlife.interceptors;

import lombok.extern.slf4j.Slf4j;
import org.acko.smartlife.constants.RequestHeaderConstants;
import org.acko.smartlife.utils.ApplicationContext;
import org.jboss.logging.NDC;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author prabodh.hend
 */
@Slf4j
public class HeaderDataResolver implements HandlerMethodArgumentResolver {

    private static final int MIN_LENGTH = 16;
    private static final int MAX_LENGTH = 32;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        final String requestId = webRequest.getHeader(RequestHeaderConstants.X_REQUEST_ID);
        ApplicationContext.setCurrentRequestId(requestId);
        NDC.push(requestId);
        log.info("requestId: {}", requestId);
        return null;
    }

}
