package com.jezh.entityImpl.validation;

import com.jezh.customAnnotation.AliasArray;
import com.jezh.customAnnotation.CourseCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;
import java.util.List;

@Component
public class Customer {

    private String firstName;
    @NotNull(message = "is required") // NB: message is overridden in messages.properties as NotNull.custy.lastName,
    // see also app-config.xml, ResourceBundleMessageSource
    @Size(min = 2, message = "min 2 characters are required")
    private String lastName;

    @NotNull(message = "must not be null") // the field for this annotation must be the Integer type, as int cannot be null
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

    // CUSTOM ANNOTATION:
    @CourseCode(value = "jezh"/*, message = "must start with 'jezh' and be continued with digits"*/) // and the message
    // is overridden in the messages.properties as CourseCode.custy.courseCode,
    // see also app-config.xml, ResourceBundleMessageSource
    private String courseCode;

//    The list to populate @AliasArray value, see aliases.properties:
//    @Value("#{'${alias.values}'.split(',')}")
//    private List<Strin
//    @Value("${alias.values}")
//    private String[] aliasValues;

//    CUSTON ANNOTATION 2:
//    из .properties не получается, поскольку value must be constant (final or effectively final).
// NB: this is String, not String[], because the form is text area and must contains only 1 value
    @AliasArray(value = {"bear", "giant", "huge", "jumbo"},
            message = "must have such epithet as bear, giant, huge or jumbo, or all items together")
    private String alias;

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

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
