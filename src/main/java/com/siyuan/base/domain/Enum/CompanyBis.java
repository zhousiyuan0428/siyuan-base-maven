package com.siyuan.base.domain.Enum;

public enum CompanyBis {
    THING_INIT(1,"初始化"),
    THING_DEAL(4,"已处理"),
    THING_HANGUP(2,"挂起"),
    THING_SUSPEND(3,"暂停");

    private Integer status;
    private String Describe;

    public Integer getStatus() {
        return status;
    }

    public String getDescribe() {
        return Describe;
    }

    CompanyBis(Integer status, String describe) {
        this.status = status;
        Describe = describe;
    }
}
