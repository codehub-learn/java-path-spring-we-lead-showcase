package gr.codelearn.spring.showcase.app.transfer;

public record ApiError(Integer status, String message, String path) {
}
