package com.example.digital_bank_api.enums;

public enum TransferStatus {
    COMPLETE("C"),
    FAILED("F");
    // removed PENDING status, since we are not using too many requests

    private String status;

    TransferStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static TransferStatus fromStatus(String status) {
        for (TransferStatus value : values()) {
            if (value.status.equals(status)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown TransferStatus: " + status);
    }
}
