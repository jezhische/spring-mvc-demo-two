package com.jezh.entityImpl.validation;

import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Component
public class Customer {

    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 2, message = "min 2 characters are required")
    private String lastName;

    @NotNull(message = "must not be null")
    @Min(value = 1, message = "must be greater than or equal to 1")
    @Max(value = 10, message = "must be less than or equal to 10")
//    and message for typeMismatch (NumberFormatException, when typed String instead of Integer in the form) is defined in
// messages.properties and resolved with bean "messageSource" of ResourceBundleMessageSource type (see app-config.xml)
//    NB: the name of property is "typeMismatch.custy.freePasses=..." ("error type.model attribute name.field name"),
//    and model attribute name is custy, not customer !!!! (this is model.attributeName, not the bean name!!!!)
    private Integer freePasses;

//  regex: с начала строки; любая цифра; ровно 5 раз. Вместо [\\d] можно писать [0-9]
    @Pattern(regexp = "^[\\d]{5}", message = "please type 5 digits only")
//    @NotNull(message = "must not be null")
    private String postalCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public Integer getFreePasses() {
//        return freePasses != null && freePasses.getClass().equals(Integer.class)? freePasses: null;
//    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
