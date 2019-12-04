package com.imnu.eeas.core;

import java.util.UUID;

/**
 * @Author hxc
 * @Date 2019/12/4 17:21
 */
public class EResponse<T> {
    // 响应代码
    private String code;

    // 响应消息
    private String message;

    // 响应数据
    private T data;

    // 异常ID
    private String errorId;

    // 异常数据
    private Object errorData;

    private EResponse(String code, String message, T data, String errorId, Object errorData) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.errorId = errorId;
        this.errorData = errorData;
    }

    /**
     * 成功
     * @param message: 成功消息
     * @param data: 响应数据
     */
    public static <T> EResponse success(String message, T data) {
        return new EResponse(Constants.Response.SUCCESS.getCode(), message, data, null, null);
    }

    /**
     * 成功
     */
    public static <T> EResponse success() {
        return EResponse.success(Constants.Response.SUCCESS.getMessage(), null);
    }

    /**
     * 成功
     * @param data: 响应数据
     */
    public static <T> EResponse data(T data) {
        return EResponse.success(Constants.Response.SUCCESS.getMessage(), data);
    }

    /**
     * 失败
     * @param e: 业务异常
     */
    public static EResponse failure(BusinessException e) {
        return new EResponse(e.getCode(), e.getMessage(), null, e.getErrorId(), e.getErrorData());
    }

    /**
     * 失败
     * @param status: 响应状态
     */
    public static EResponse failure(IResponseStatus status) {
        return new EResponse(status.getCode(), status.getMessage(), null, UUID.randomUUID().toString(), null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public Object getErrorData() {
        return errorData;
    }

    public void setErrorData(Object errorData) {
        this.errorData = errorData;
    }
}
