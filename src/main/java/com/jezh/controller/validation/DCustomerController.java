package com.jezh.controller.validation;

import com.jezh.entityImpl.validation.Customer;
import com.jezh.util.CustomerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class DCustomerController {

    @Autowired
    private Customer customer;

    @RequestMapping("/processForm")
    //    results of validation will be placed in the BindingResult
//    todo: In the method signature, the BindingResult parameter must be immediately after the model attribute.
    public String processForm(@Valid @ModelAttribute("custy") Customer customer, BindingResult bindingResult) {
/*        if (bindingResult.hasFieldErrors("freePasses")) {
            System.out.println(bindingResult.getFieldError("freePasses"));
            return "/validation/customer-form";
        }
        else*/ if (bindingResult.hasErrors()) {
            System.out.println(">>>> " + bindingResult);
            return "/validation/customer-form";
        }
        else {
//            небольшая обработка - исправление первых символов toUpperCase:
            customer.setFirstName(CustomerUtils.afterInitBinderReplaceFirstChar(customer.getFirstName()));
            customer.setLastName(CustomerUtils.afterInitBinderReplaceFirstChar(customer.getLastName()));
            return "/validation/customer-confirmation";
        }
    }
//    solution for problem if customer types only whitespaces in the form text area:
// todo: @InitBinder pre-process ALL web requests coming into this Controller
    @InitBinder
    public void initBinder (WebDataBinder dataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
//       after that trimmerEditor will be applied for EVERY STRING CLASS, as I define in the parameters of registrar:
        dataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("custy", customer);
        return "/validation/customer-form";
    }

}
