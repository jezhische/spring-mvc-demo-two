package com.jezh.controller;

import com.jezh.entity.Student;
import com.jezh.entityImpl.StudentImpl;
import com.jezh.util.HellControllerUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hell")
public class BHellController {

    // Behind the scene the object theStudent is populated with form data ("name" and "surname")
    // @ModelAttribute - "Annotation that binds a method parameter or method return value to a named model attribute,
    // exposed to a web view. "
    @RequestMapping("processForm")
    public String procF(HttpServletRequest request,
                        @RequestParam("name") String nm, @RequestParam("surname") String surnm,
                        @ModelAttribute("student") StudentImpl theStudent,
                        Model model) {
//        обработка HttpServletRequest (затем атрибут модели можно просто вызвать в JSP по имени):
        String message = "Hey, " + HellControllerUtils.getMessageFromRequest(request) + "!";
        model.addAttribute("message", message);
//        извлекаем value из @RequestParam:
        model.addAttribute("fromRequestParam", nm + " " + surnm);
        return "hello";
    }
    // Модель можно создавать после заполнения полей формы, если в запросе "processForm" мы хотим получить значение
    // из текстовых полей формы и заполнить атрибуты вновь созданной модели.
    // Но если в запросе "processForm" В ПАРАМЕТРАХ МЕТОДА УЖЕ ИДЕТ
    //todo: обращение к определенному атрибуту модели (@ModelAttribute("student")), модель и этот атрибут д.б. созданы заранее,
    // что мы и делаем сейчас в методе, который возвращает страничку с формами.
    // Затем поля этого атрибута модели - бина "student" - будут автоматически заполняться из полей формы, поскольку
    // во вьюхе hello-form я указал (стр.27-29), что данные поля формы нужно связать с полями бина. Их дефолтное
    // значение спринг получил из модели с помощью геттеров, а затем передал им новое с помощью сеттеров.
    @RequestMapping("showForm")
    public String showF(Model model) {
        model.addAttribute("student", new StudentImpl());
        return "hello-form";
    }
}
