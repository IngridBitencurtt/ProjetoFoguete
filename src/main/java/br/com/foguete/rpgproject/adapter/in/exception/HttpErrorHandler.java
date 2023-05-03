package br.com.foguete.rpgproject.adapter.in.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class HttpErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(HttpErrorHandler.class);

    private final MessageService messageService;

    public HttpErrorHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    //// ERROS 400

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public @ResponseBody
    ErrorDTO handleBadRequest(HttpServletRequest req, Exception ex) {
        log.error("handle-bad-request; exception; system; exception=\"{}\";", ex.getMessage());
        String errorMessage = buildErrorItems(((MethodArgumentNotValidException) ex).getBindingResult());
        return new ErrorDTO(HttpStatus.BAD_REQUEST.value(), errorMessage,
                buildItems(((MethodArgumentNotValidException) ex).getBindingResult()));
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingRequestHeaderException.class)
    public @ResponseBody
    ErrorDTO handleMissingRequestHeaderException(HttpServletRequest req, Exception ex) {
        log.error("handle-bad-request; exception; system; exception=\"{}\";", ex.getMessage());
        String errorMessage = ex.getMessage();
        return new ErrorDTO(HttpStatus.BAD_REQUEST.value(), errorMessage,
                null);
    }

    private List<ErrorDetailDTO> buildItems(final BindingResult bindingResult) {

        if (bindingResult.getFieldErrors().isEmpty())
            return null;

        final List<ErrorDetailDTO> details = new ArrayList<>();

        bindingResult.getFieldErrors().forEach(error ->
                details.add(new ErrorDetailDTO(error.getField(), error.getDefaultMessage()))
        );
        return details;
    }

    private String buildErrorItems(BindingResult bindingResult) {
        if (bindingResult.getFieldErrors().isEmpty()) {
            return "";
        }
        return bindingResult.getFieldErrors().get(0).getField()
                + " " + bindingResult.getFieldErrors().stream().findFirst().get().getDefaultMessage();
    }

}
