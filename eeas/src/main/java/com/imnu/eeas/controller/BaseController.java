package com.imnu.eeas.config;

import com.imnu.eeas.core.Constants;
import com.imnu.eeas.core.EResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author hxc
 * @Date 2019/12/4 15:17
 */
public class BaseController {
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected HttpServletRequest request;


    /**
     * The Global exception handler
     * @param e
     * @return
     * @author 懒猴子CG
     * @date 2019/12/04 14:23
     */
    @ExceptionHandler(Exception.class)
    public EResponse exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        EResponse response = EResponse.failure(Constants.Response.FAILURE);
        return response;
    }
}
