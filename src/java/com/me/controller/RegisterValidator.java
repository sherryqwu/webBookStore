package com.me.controller;

import com.me.DAO.AdException;
import com.me.DAO.UserDAO;
import com.me.pojo.Book;
import com.me.pojo.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

public class RegisterValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(User.class);
    }

    public void validate(Object obj, Errors errors)
    {
        //Advert newAdvert = (Advert) obj;
        User user = (User) obj;
        //errors.rejectValue("userName", "error.userName.required","User name or password incorrect!");
        
        UserDAO userDao = new UserDAO();
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.name", "UserName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passWord", "error.invalid.password", "Password Required");
        try {
            User temp = userDao.get(user.getUserName(), user.getPassWord());
            if(temp != null){
                errors.rejectValue("userName", "error.userName.required","User name exist!");
            }
        } catch (AdException ex) {
            Logger.getLogger(RegisterValidator.class.getName()).log(Level.SEVERE, null, ex);
            errors.rejectValue("userName", "error.userName.required","User or password incorrect!");
        }
        userDao.close();
    }
}
