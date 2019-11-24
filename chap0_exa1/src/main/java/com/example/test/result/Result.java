package com.example.test.result;

public class Result<T>
{
    private int code;
    private String msg;
    private T data;
    public Result(T data)
    {
        this.data  = data;
    }
    public Result() {}
    public void setCode(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }

    public T getData()
    {
        return data;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }
}
