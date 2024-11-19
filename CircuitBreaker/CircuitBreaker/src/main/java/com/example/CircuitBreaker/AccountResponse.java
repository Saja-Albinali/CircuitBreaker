package com.example.CircuitBreaker;

public class AccountResponse {
    private String accountInfo;
    private String stockInfo;
    private String success;

    public AccountResponse(String accountInfo, String stockInfo, String success) {
        this.accountInfo = accountInfo;
        this.stockInfo = stockInfo;
        this.success = success;
    }

    public String getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(String accountInfo) {
        this.accountInfo = accountInfo;
    }

    public String getStockInfo() {
        return stockInfo;
    }

    public void setStockInfo(String stockInfo) {
        this.stockInfo = stockInfo;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
