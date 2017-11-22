package com.jezh.controller;

import com.jezh.entityImpl.StudentImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/stud")
public class CStudentController {

    // передать опции выпадающего списка из проперти-файла:
    // файл favoriteDishes.properties замаплен на id "favoriteDishOptions" в app-config.xml
    // NB: здесь должен быть объект "чистого" типа интерфейса
    @Value("#{favoriteDishOptions}")
    private Map<String, String> favoriteDishOptions;

    @RequestMapping("/showForm")
    public String showF(Model model) {
        model.addAttribute("student", new StudentImpl());
        favoriteDishOptions = favoriteDishOptions.entrySet().stream()
//                попробовать в реверсивном порядке
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey(), entry.getValue()),
                        Map::putAll);
        model.addAttribute("theFavDishOptions", favoriteDishOptions);
        return "student-form";
    }

    @RequestMapping("/processFormi")
    public String procF(@ModelAttribute("student") StudentImpl student) {
        return "student-confirmation";
    }
}
