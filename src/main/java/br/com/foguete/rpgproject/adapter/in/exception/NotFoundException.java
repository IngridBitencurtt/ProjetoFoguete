package br.com.foguete.rpgproject.adapter.in.exception;

import java.util.List;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1L;

    private List<ErrorDetailDTO> details;


    public NotFoundException() {
    }

    public NotFoundException(String message){
        super(message);
    }
}
