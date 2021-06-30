package com.qsgf.response;


import java.util.List;


/**
* @Description: 返回带分页对象
* @Author: lqt
* @Date: 2021/4/11
*/
public class ReturnPageMsg {

    private static final int FAIL_PAGE_TOTAL = 0;

    private int total;
    private int status;
    private String msg;
    private List<?> data;

    public static ReturnPageMsg newInstance() {
        return new ReturnPageMsg();
    }

    public static ReturnPageMsg consSuccess(int total, List<?> data) {
        ReturnPageMsg t_rtn = newInstance().setStatus(ReturnStatus.SUCCESS.getCode()).setTotal(total).setData(data);
        return t_rtn;
    }

    public static ReturnPageMsg consSuccess(int total, List<?> data, String msg) {
        ReturnPageMsg t_rtn = consSuccess(total, data).setMsg(msg);
        return t_rtn;
    }

    public static ReturnPageMsg consFail() {
        ReturnPageMsg t_rtn = newInstance().setStatus(ReturnStatus.FAIL.getCode()).setTotal(FAIL_PAGE_TOTAL);
        return t_rtn;
    }

    public static ReturnPageMsg consFail(String msg) {
        ReturnPageMsg t_rtn = consFail().setMsg(msg).setTotal(FAIL_PAGE_TOTAL);
        return t_rtn;
    }

    public ReturnPageMsg() {
    }

    public int getTotal() {
        return this.total;
    }

    public int getStatus() {
        return this.status;
    }

    public String getMsg() {
        return this.msg;
    }

    public List<?> getData() {
        return this.data;
    }

    public ReturnPageMsg setTotal(int total) {
        this.total = total;
        return this;
    }

    public ReturnPageMsg setStatus(int status) {
        this.status = status;
        return this;
    }

    public ReturnPageMsg setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ReturnPageMsg setData(List<?> data) {
        this.data = data;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ReturnPageMsg)) {
            return false;
        } else {
            ReturnPageMsg other = (ReturnPageMsg)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getTotal() != other.getTotal()) {
                return false;
            } else if (this.getStatus() != other.getStatus()) {
                return false;
            } else {
                label40: {
                    Object this$msg = this.getMsg();
                    Object other$msg = other.getMsg();
                    if (this$msg == null) {
                        if (other$msg == null) {
                            break label40;
                        }
                    } else if (this$msg.equals(other$msg)) {
                        break label40;
                    }

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
        return other instanceof ReturnPageMsg;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 59 + this.getTotal();
        result = result * 59 + this.getStatus();
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ReturnPageMsg(total=" + this.getTotal() + ", status=" + this.getStatus() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }
}
