package com.siyuan.base.domain.model;

import lombok.Data;

@Data
public class WebResponse {
    private String result;
    private String resultCode;

    public WebResponse(String result, String resultCode) {
        this.result = result;
        this.resultCode = resultCode;
    }
}
