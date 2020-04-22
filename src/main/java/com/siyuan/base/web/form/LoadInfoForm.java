package com.siyuan.base.web.form;

public class LoadInfoForm {
    private int id;
    private String applyId;
    private String customerId;
    private String customerName;
    private String barCode;
    private String businessType;
    private Double businessSum;
    private int businessTerm;
    private String managerId;
    private String orgId;
    private String loadStatus;
    private String processStatus;
    private String awaitStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Double getBusinessSum() {
        return businessSum;
    }

    public void setBusinessSum(Double businessSum) {
        this.businessSum = businessSum;
    }

    public int getBusinessTerm() {
        return businessTerm;
    }

    public void setBusinessTerm(int businessTerm) {
        this.businessTerm = businessTerm;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getLoadStatus() {
        return loadStatus;
    }

    public void setLoadStatus(String loadStatus) {
        this.loadStatus = loadStatus;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public String getAwaitStatus() {
        return awaitStatus;
    }

    public void setAwaitStatus(String awaitStatus) {
        this.awaitStatus = awaitStatus;
    }
}
