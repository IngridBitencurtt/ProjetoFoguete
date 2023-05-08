package br.com.foguete.rpgproject.adapter.in.exception;

public class BusinessException extends RuntimeException{
    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
