package com.xaut.util;

/**
 * 结果封装类
 */
public class ResponseBean {
	/* 附加 */
    private boolean success;
    
    /* 附加 */
    private String message;
    
    /* 操作返回的数 */
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseBean(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    /**
     * @param success
     * @param message
     * @param data
     */
    public ResponseBean(boolean success, Object data, String message) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ResponseBean() {
        super();
    }

    @Override
    public String toString() {
        return "Result [success=" + success + ", message=" + message + "]";
    }
}