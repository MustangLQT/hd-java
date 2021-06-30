package com.qsgf.response;


/**
* @Description: 返回状态码
* @Author: lqt
* @Date: 2021/4/11
*/
public enum ReturnStatus {

    /**
     * 成功
     */
    SUCCESS(20),

    /**
     * 失败
     */
    FAIL(40),

    /**
     * 鉴权失败
     */
    UNAUTHORIZED(41);

    private final int code;

    ReturnStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

}
