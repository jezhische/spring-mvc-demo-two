package com.jezh.controller;

import com.jezh.entityImpl.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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

    @Value("#{favLangOptions}")
    private Map<String, String> favoriteLanguageOptions;

//    если я хочу, чтобы в классе StudentImpl получилось автозаполнение поля @Value("#{favOS}")
// private Map<String, String> favOSOptions;, то мне нужно пометить этот класс как компонент, чтобы спринг создал
// заранее бин и автозаполнил это поле из пропертей, и здесь этот бин заавтовайрить, а не создавать в атрибуте
// модели заново - создание объекта как new StudentImpl(), без обращения к спринговскому контексту,
// пройдет мимо спринга, и поле не будет заполнено.
    @Autowired
    private StudentImpl studiosus;


    @RequestMapping("/showForm")
    public String showF(Model model) {
//        studiosus.setFavOSOptions(studiosus.reverseSortAndSwapKeyValue(studiosus.getFavOSOptions()));
        model.addAttribute("student", studiosus /*new StudentImpl()*/);
        favoriteDishOptions = favoriteDishOptions.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey(), entry.getValue()),
                        Map::putAll);
        model.addAttribute("theFavDishOptions", favoriteDishOptions);
//        сортируем мапу для radiobuttons:
        favoriteLanguageOptions = favoriteLanguageOptions.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey(), entry.getValue()),
                        Map::putAll);
        model.addAttribute("theFavLangOptions", favoriteLanguageOptions);
        return "student-form";
    }

    @RequestMapping("/processFormi")
    public String procF(/*@Valid */@ModelAttribute("student") StudentImpl student, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "student-form";
        else return "student-confirmation";
    }
}
