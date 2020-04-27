package ru.kolyasnikovkv.discussion1c.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
Токен это ID User, его всегда передаем в заголовках

 */
//public class BaseApiController extends BaseController {
/*
    @Autowired
    private IUserService userService;

    protected Result success() {
        return success(null);
    }

    protected Result success(Object detail) {
        Result result = new Result();
        result.setCode(200);
        result.setDescription("SUCCESS");
        result.setDetail(detail);
        return result;
    }

    protected Result error(String description) {
        Result result = new Result();
        result.setCode(201);
        result.setDescription(description);
        return result;
    }

     protected User getApiUser() {
        return getApiUser(true);
    }


    protected User getApiUser(boolean required) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest();
        String token = request.getHeader("token");
        //    String token = request.getParameter("token");
        if (required) {
            ApiAssert.notEmpty(token, "token Не может быть пустым");
            User user = userService.selectByToken(token);
            ApiAssert.notNull(user, "token Неправильно, пожалуйста, войдите в свою учетную запись на веб-сайте, затем перейдите на страницу личных настроек и отсканируйте QR-код, чтобы получить token");
            return user;
        } else {
             if (StringUtils.isEmpty(token)) return null;
            return userService.selectByToken(token);
        }
    }*/
//}
