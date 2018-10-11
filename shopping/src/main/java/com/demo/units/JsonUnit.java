package com.demo.units;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 16:592018/10/10/010
 * @Modified By:
 */
public class JsonUnit<T> {
    private boolean success;
    private int code;
    private String msg;
    private T data;
    public JsonUnit(boolean success,int code,String msg,T data)
    {
        this.success=success;
        this.code=code;
        this.msg=msg;
        this.data=data;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
