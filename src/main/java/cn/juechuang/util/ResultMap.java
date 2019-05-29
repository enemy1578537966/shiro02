package cn.juechuang.util;
public class ResultMap {
    private String message;
    private Integer code;
    private Object data;

    public ResultMap() {
    }

    public ResultMap(String message, Integer code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public static ResultMap ok(Object data){
        return  new ResultMap("成功",200,data);
    }

    public static ResultMap fail(Object data){
        return  new ResultMap("失败",500,data);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getcode() {
        return code;
    }

    public void setcode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}