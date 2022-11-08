package org.example.response;

public enum StatusEnum {
    OK(200,"성공입니다."),
    BAD_REQUEST(400,"요청을 잘못했습니다."),
    NOT_FOUND(404,"찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(500,"서버에 문제가 있습니다."),

    CANT_DELETE(1001, "삭제가 되지 않았습니다."),
    SUCCESS(1000, "요청이 성공했습니다.");

    int statusCode;
    String message;

    StatusEnum(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
