package com.automan.root.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author he.zhou
 * @Date 2021-12-29
 */
public class JsonResult<T>{
    protected T data;

    protected int status;

    protected String msg;


    protected JsonResult(@JsonProperty("status") int status, @JsonProperty("msg") String msg, @JsonProperty("data") T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> JsonResult<T> create(int status, String message, T data) {
        return new JsonResult<>(status, message, data);
    }

//    public static <T> JsonResult<T> create(RpcResult<T> rpcResult) {
//        Status statusCode = rpcResult.getStatusCode();
//        return create(statusCode.getStatus(), statusCode.getReason(), rpcResult.getData());
//    }

    public static <T> JsonResult<T> create(Status statusCode, T data) {
        return create(statusCode.getStatus(), statusCode.getReason(), data);
    }

    public static <T> JsonResult<T> success(T data) {
        Status statusCode = Status.success();
        return create(statusCode, data);
    }

    public static <T> JsonResult<T> error(String message) {
        Status statusCode = Status.error(message);
        return create(statusCode, null);
    }

    public static <T> JsonResult<T> error(int status, String message) {
        Status statusCode = Status.error(status, message);
        return create(statusCode, null);
    }

//    public static <T> JsonResult<T> error(StatusCodeException e) {
//        Status statusCode = e.getStatusCode();
//        return create(statusCode, null);
//    }

    public int getStatus() {
        return this.status;
    }

    public boolean isSuccess() {
        return Status.create(this.status, this.msg).isSuccess();
    }

    public String getMsg() {
        return this.msg;
    }

    public T getData() {
        return this.data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JsonResult)) {
            return false;
        }
        JsonResult<?> that = (JsonResult)o;
        if (this.status != that.status) {
            return false;
        }
        if ((this.data != null) ? !this.data.equals(that.data) : (that.data != null)) {
            return false;
        }
        return (this.msg != null) ? this.msg.equals(that.msg) : ((that.msg == null));
    }

    @Override
    public int hashCode() {
        int result = (this.data != null) ? this.data.hashCode() : 0;
        result = 31 * result + this.status;
        result = 31 * result + ((this.msg != null) ? this.msg.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JsonResult{data=" + this.data + ", status=" + this.status + ", msg='" + this.msg + '\'' + '}';
    }
}
