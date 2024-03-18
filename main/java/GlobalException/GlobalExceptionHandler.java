package GlobalException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.assignment.entity.ApiResponse;


import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataNotCurrectException.class)
	public ResponseEntity<ApiResponse> handleDataNotCurrectException(DataNotCurrectException e) {
		
		// logger.error("An error occurred", e);

		ApiResponse respon = new ApiResponse(false, "data not created");
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respon);
	}
}
