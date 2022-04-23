package com.hrms.utils;

import java.util.HashMap;
import java.util.Map;

public class JsonMsg {
    //状态码
    private int code;
    //返回信息
    private String msg;
    //要返回的数据
    private Map<String, Object> extendInfo = new HashMap<String, Object>();

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

    public Map<String, Object> getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(Map<String, Object> extendInfo) {
        this.extendInfo = extendInfo;
    }

    //操作成功
    public static JsonMsg success(){
        JsonMsg msg = new JsonMsg();
        msg.setCode(100);
        msg.setMsg("操作成功");
        return msg;
    }

    //操作成功
    public static JsonMsg fail(){
        JsonMsg msg = new JsonMsg();
        msg.setCode(200);
        msg.setMsg("操作失败");
        return msg;
    }

    public JsonMsg addInfo(String key, Object obj){
        this.extendInfo.put(key, obj);
        return this;
    }
}
