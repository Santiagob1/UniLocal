package co.edu.uniquindio.unilocal.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class GlobalExceptions {
//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<MensajeDTO> badCredentialsException(BadCredentialsException e){
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body( new
//                MensajeDTO(HttpStatus.UNAUTHORIZED, true, "Datos de autenticación incorrectos") );
//    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<MensajeDTO> generalException(Exception e){
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( new
//                MensajeDTO(HttpStatus.INTERNAL_SERVER_ERROR, true, e.getMessage()) );
//    }
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<MensajeDTO> accessDeniedException(AccessDeniedException
//                                                                    accessDeniedException) {
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new
//                MensajeDTO(HttpStatus.FORBIDDEN, true, "No se puede acceder a este recurso"));
//    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<MensajeDTO> validationException(MethodArgumentNotValidException ex){
//        List<String> messages = new ArrayList<>();
//        BindingResult results = ex.getBindingResult();
//        for (FieldError e: results.getFieldErrors()) {
//            messages.add(e.getField()+": "+e.getDefaultMessage());
//        }
//        return ResponseEntity.badRequest().body(new MensajeDTO(HttpStatus.BAD_REQUEST, true,
//                messages.toString()));
//    }
}
