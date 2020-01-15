package com.renruipeng.common;


public interface IError {
    IError.DefaultErrorEnum GENERAL_ERROR = IError.DefaultErrorEnum.GENERAL_ERROR;
    IError.DefaultErrorEnum SYSYTEM_UNKNOW = IError.DefaultErrorEnum.SYSYTEM_UNKNOW;
    IError.DefaultErrorEnum PARAM_CHECK_FAILD = IError.DefaultErrorEnum.PARAM_CHECK_FAILD;
    IError.DefaultErrorEnum DATA_NOT_EXIST = IError.DefaultErrorEnum.DATA_NOT_EXIST;
    IError.DefaultErrorEnum DATA_ERROR = IError.DefaultErrorEnum.DATA_ERROR;
    IError.DefaultErrorEnum FEIGN_FAIL = IError.DefaultErrorEnum.FEIGN_FAIL;

    String getMsg();

    String getErrCode();

    public static enum DefaultErrorEnum implements IError {
        GENERAL_ERROR("-1", "通用错误"),
        SYSYTEM_UNKNOW("900000", "系统未知错误"),
        PARAM_CHECK_FAILD("900101", "参数校验失败"),
        DATA_NOT_EXIST("900200", "数据不存在"),
        DATA_ERROR("900201", "数据异常"),
        FEIGN_FAIL("900102", "Feign服务调用异常");

        private String errCode;
        private String msg;

        private DefaultErrorEnum(String errCode, String msg) {
            this.errCode = errCode;
            this.msg = msg;
        }

        public String getMsg() {
            return this.msg;
        }

        public String getErrCode() {
            return this.errCode;
        }
    }
}
