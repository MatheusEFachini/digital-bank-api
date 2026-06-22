package enums;

public enum TransferStatus {
    COMPLETE("C"),
    PENDING("P"),
    FAILED("F");

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
