package com.variedadesbyj.byj.exepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecursoNoEncontrado extends RuntimeException{
    public RecursoNoEncontrado(String mensaje){
        super(mensaje);
    }
}
