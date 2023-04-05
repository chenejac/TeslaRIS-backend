package rs.teslaris.core.configuration;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import rs.teslaris.core.exception.CantRegisterAdminException;
import rs.teslaris.core.exception.NonExistingRefreshTokenException;
import rs.teslaris.core.exception.NotFoundException;
import rs.teslaris.core.exception.TakeOfRoleNotPermittedException;
import rs.teslaris.core.exception.WrongPasswordProvidedException;
import rs.teslaris.core.util.exceptionhandling.ErrorObject;

@ControllerAdvice
public class ErrorHandlerConfiguration {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ErrorObject handleMethodBindingException(HttpServletRequest request, BindException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
            .forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));

        ex.getBindingResult().getGlobalErrors()
            .forEach(e -> errors.put(e.getObjectName(), e.getDefaultMessage()));

        return new ErrorObject(request, ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST, errors);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    ErrorObject handleNotFoundException(HttpServletRequest request, NotFoundException ex) {
        return new ErrorObject(request, ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NonExistingRefreshTokenException.class)
    @ResponseBody
    ErrorObject handleNonExistingRefreshTokenException(HttpServletRequest request,
                                                       NonExistingRefreshTokenException ex) {
        return new ErrorObject(request, ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TakeOfRoleNotPermittedException.class)
    @ResponseBody
    ErrorObject handleTakeOfRoleNotPermittedException(HttpServletRequest request,
                                                       TakeOfRoleNotPermittedException ex) {
        return new ErrorObject(request, ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CantRegisterAdminException.class)
    @ResponseBody
    ErrorObject handleCantRegisterAdminException(HttpServletRequest request,
                                                 CantRegisterAdminException ex) {
        return new ErrorObject(request, ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WrongPasswordProvidedException.class)
    @ResponseBody
    ErrorObject handleWrongPasswordProvidedException(HttpServletRequest request,
                                                 WrongPasswordProvidedException ex) {
        return new ErrorObject(request, ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
