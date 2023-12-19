package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.base.BaseComponent;
import gr.codelearn.spring.showcase.app.transfer.ApiError;
import gr.codelearn.spring.showcase.app.transfer.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class CustomizedExceptionHandler extends BaseComponent {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ApiResponse<?>> handleAllExceptions(final Exception ex, final WebRequest request) {
		logger.error("Unexpected exception occurred.", ex);
		return new ResponseEntity<>(
				ApiResponse.builder()
						   .data(getApiError(ex, HttpStatus.INTERNAL_SERVER_ERROR, request))
						   .build()
				, HttpStatus.INTERNAL_SERVER_ERROR
		);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public final ResponseEntity<ApiResponse<?>> handleNonExistence(final NoSuchElementException ex,
																   final WebRequest request) {
		logger.error("Reference to a non-existing object.", ex);
		return new ResponseEntity<>(
				ApiResponse.builder().data(getApiError(ex, HttpStatus.NOT_FOUND, request)).build(),
				HttpStatus.NOT_FOUND
		);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	protected ResponseEntity<ApiResponse<?>> handleMissingServletRequestParameter(
			final MissingServletRequestParameterException ex, final WebRequest request) {
		logger.error("There was a parameter missing from incoming request.", ex);
		return new ResponseEntity<>(
				ApiResponse.builder()
						   .data(getApiError(ex, HttpStatus.BAD_REQUEST, request))
						   .build()
				, HttpStatus.BAD_REQUEST
		);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
																		  final WebRequest request) {
		logger.error("Method argument is invalid.", ex);
		return new ResponseEntity<>(
				ApiResponse.builder()
						   .data(getApiError(ex, HttpStatus.BAD_REQUEST, request))
						   .build()
				, HttpStatus.BAD_REQUEST
		);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ApiResponse<?>> handleMethodArgumentTypeMismatch(final MethodArgumentTypeMismatchException ex,
																				 final WebRequest request) {
		logger.error("Method argument, although matched, is of wrong type.", ex);
		return new ResponseEntity<>(
				ApiResponse.builder().data(getApiError(ex, HttpStatus.BAD_REQUEST, request)).build(),
				HttpStatus.BAD_REQUEST
		);
	}

	private ApiError getApiError(final Exception ex, final HttpStatus status, final WebRequest request) {
		String path = request.getDescription(false);
		if (path.indexOf("uri=") == 0) {
			path = StringUtils.replace(path, "uri=", "");
		}
		return new ApiError(status.value(), ex.getMessage(), path);
	}

	private ApiError getApiError(final Exception ex, final HttpStatus status, final WebRequest request,
								 String customMessage) {
		String path = request.getDescription(false);
		if (path.indexOf("uri=") == 0) {
			path = StringUtils.replace(path, "uri=", "");
		}
		return new ApiError(status.value(), customMessage != null ? customMessage : ex.getMessage(), path);
	}
}
