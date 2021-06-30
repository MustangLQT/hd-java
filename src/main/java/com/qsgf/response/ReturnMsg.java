package com.qsgf.response;



/**
* @Description: 返回对象
* @Author: lqt
* @Date: 2021/4/11
*/
public class ReturnMsg {

    private int status;
    private String msg;
    private Object data;

    public static ReturnMsg newInstance() {
        return new ReturnMsg();
    }

    public static ReturnMsg consSuccess() {
        ReturnMsg t_rtn = newInstance().setStatus(ReturnStatus.SUCCESS.getCode());
        return t_rtn;
    }

    public static ReturnMsg consSuccess(Object data) {
        ReturnMsg t_rtn = consSuccess().setData(data);
        return t_rtn;
    }

    public static ReturnMsg consSuccess(String msg) {
        ReturnMsg t_rtn = consSuccess().setMsg(msg);
        return t_rtn;
    }

    public static ReturnMsg consSuccess(Object data, String msg) {
        ReturnMsg t_rtn = consSuccess().setData(data).setMsg(msg);
        return t_rtn;
    }

    public static ReturnMsg consFail() {
        ReturnMsg t_rtn = newInstance().setStatus(ReturnStatus.FAIL.getCode());
        return t_rtn;
    }

    public static ReturnMsg consFail(int status, String msg) {
        ReturnMsg t_rtn = newInstance().setStatus(status).setMsg(msg);
        return t_rtn;
    }

    public static ReturnMsg consFail(String msg) {
        ReturnMsg t_rtn = consFail().setMsg(msg);
        return t_rtn;
    }

    public ReturnMsg() {
    }

    public int getStatus() {
        return this.status;
    }

    public String getMsg() {
        return this.msg;
    }

    public Object getData() {
        return this.data;
    }

    public ReturnMsg setStatus(int status) {
        this.status = status;
        return this;
    }

    public ReturnMsg setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ReturnMsg setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ReturnMsg)) {
            return false;
        } else {
            ReturnMsg other = (ReturnMsg)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getStatus() != other.getStatus()) {
                return false;
            } else {
                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ReturnMsg;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = result * 59 + this.getStatus();
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ReturnMsg(status=" + this.getStatus() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }

}
