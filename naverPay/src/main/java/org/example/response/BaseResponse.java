package org.example.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseResponse<T> {

    private StatusEnum status;

    private int code;
    private String message;
    private T data;

    public BaseResponse(T data){
        this.status=StatusEnum.OK;
        this.code=StatusEnum.OK.statusCode;;
        this.message=StatusEnum.OK.message;
        this.data=data;
    }

    public BaseResponse(StatusEnum status){
        this.status=status;
        this.code=status.statusCode;
        this.message=status.message;
    }
    @Builder
    public BaseResponse(StatusEnum status, T data) {
        this.status = status;
        this.code=status.statusCode;
        this.message = status.message;
        this.data = data;
    }
}
