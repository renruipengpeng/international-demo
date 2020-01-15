package com.renruipeng.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.beans.Transient;
import java.util.Objects;

/**
 * @author Mr--renruipeng
 * @date 2019-12-27
 **/

public class BaseResponse<T> {
    public static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";
    public static final String DEFAULT_ERROR_MESSAGE = "操作失败";
    public static final String DEFAULT_SUCCESS_CODE = "1";
    public static final String DEFAULT_ERROR_CODE = "0";
    private String code;
    private String errCode = "0";
    private String msg;
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(String code, String msg, T data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> BaseResponse<T> success(T t) {
        BaseResponse<T> res = new BaseResponse();
        res.setCode("1");
        res.setMsg("操作成功");
        res.setData(t);
        return res;
    }

    public static <T> BaseResponse<T> success() {
        BaseResponse<T> res = new BaseResponse();
        res.setCode("1");
        res.setMsg("操作成功");
        res.setData((T) null);
        return res;
    }

    public static <T> BaseResponse<T> error(IError error) {
        BaseResponse<T> res = new BaseResponse();
        res.setCode("0");
        res.setErrCode(error.getErrCode());
        res.setMsg(error.getMsg());
        res.setData((T) null);
        return res;
    }

    public static <T> BaseResponse<T> error(String msg) {
        BaseResponse<T> res = new BaseResponse();
        res.setCode("0");
        res.setErrCode(IError.GENERAL_ERROR.getErrCode());
        res.setMsg(msg);
        res.setData((T) null);
        return res;
    }

    public static <T> BaseResponse<T> error(IError error, String msg) {
        BaseResponse<T> res = new BaseResponse();
        res.setCode("0");
        res.setErrCode(error.getErrCode());
        res.setMsg(msg);
        res.setData((T) null);
        return res;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    @Transient
    @JsonIgnore
    public boolean isSuccess() {
        return Objects.equals(this.code, "1");
    }

    @Override
    public String toString() {
        return "BaseResponse [code=" + this.code + ", errCode=" + this.errCode + ", msg=" + this.msg + ", data=" + this.data + "]";
    }
}