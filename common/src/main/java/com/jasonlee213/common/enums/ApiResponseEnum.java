package com.jasonlee213.common.enums;

public enum ApiResponseEnum {
    Success(200), BadRequest(400), Failed(500);

    private final int status;

    ApiResponseEnum(int status) { this.status = status; }

    public int getStatusID() { return status; }
    // Static method to map an int to an enum
    public static StatusEnum getApiResponse(int id) {
        for (StatusEnum status : StatusEnum.values()) {
            if (status.getStatusID() == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid Status ID: " + id);
    }
}
