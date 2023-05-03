package br.com.foguete.rpgproject.adapter.in.exception;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ErrorDTO implements Serializable {

    private static final long serialVersionUID = -2279690562401212479L;

    private int statusCode;

    private String message;

    private List<ErrorDetailDTO> details;

    public ErrorDTO(int statusCode, String message, List<ErrorDetailDTO> details) {
        this.statusCode = statusCode;
        this.message = message;
        this.details = details;
    }

    public ErrorDTO(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ErrorDTO() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ErrorDetailDTO> getDetails() {
        if (this.details == null) {
            this.details = new ArrayList<>();
        }
        return this.details;
    }

    @Override
    public String toString() {
        return "ErrorDTO [statusCode=" + statusCode + ", message=" + message + ", details=" + details + "]";
    }
}
