package com.aplicacion.gestiones.appgestiones.Controllers;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Handler de Excepciones Global con un mensaje custom.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handlerException(Exception ex, Model model){
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }
}
