package ru.kolyasnikovkv.discussion1c.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ru.kolyasnikovkv.discussion1c.model.User;
//import ru.kolyasnikovkv.discussion1c.service.ISystemConfigService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class BaseController {

    //@Autowired
   // private ISystemConfigService systemConfigService;

    protected String redirect(String path) {
        return "redirect:" + path;
    }

    protected User getUser() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder
                .getRequestAttributes())).getRequest();
        HttpSession session = request.getSession();
        return (User) session.getAttribute("_user");
    }

    // Рендеринг только для пути к шаблону страницы переднего плана, фон не изменяется
    protected String render(String path) {
        //return String.format("theme/%s/%s", systemConfigService.selectAllConfig().get("theme").toString(), path);
        return "";
    }

}
