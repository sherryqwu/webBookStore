package com.me.controller;

import com.me.pojo.Book;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

public class AddBookValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Book.class);
    }

    public void validate(Object obj, Errors errors)
    {

 //       if(checkPrice==)
        {
 //           errors.reject("price", "error.invalid.price", "price must be int");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.name", "Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descript", "error.invalid.descript", "Descript Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contents", "error.invalid.contents", "Contents Required");
    }
}
