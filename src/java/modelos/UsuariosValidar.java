/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Peligro
 */
public class UsuariosValidar implements Validator{
     private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
   
     private Pattern pattern;
     private Matcher matcher;
    
    @Override
    public boolean supports(Class<?> type) 
    {
        return Usuarios.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Usuarios usuarios=(Usuarios)o;
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre",
        "required.nombre", "El campo Nombre es Obligatorio.");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass",
        "required.correo", "El campo pass es Obligatorio.");
         
         if (!(usuarios.getPass() != null && usuarios.getPass().isEmpty()))
        {
            this.pattern = Pattern.compile(EMAIL_PATTERN);
            this.matcher = pattern.matcher(usuarios.getPass());
             if (!matcher.matches()) {
                errors.rejectValue("pass", "pass.incorrect",
                  "la contraseña "+usuarios.getPass()+" no es válido");
               }
        }
         
    }
}
