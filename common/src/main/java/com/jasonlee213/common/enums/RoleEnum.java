package com.jasonlee213.common.enums;

public enum RoleEnum {
    Admin(1), User(2);

    private final int ID;

    RoleEnum(int roleID) { this.ID = roleID; }

    public int getRoleID() { return ID; }
    // Static method to map an int to an enum
    public static RoleEnum getRole(int id) {
        for (RoleEnum status : RoleEnum.values()) {
            if (status.getRoleID() == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid Status ID: " + id);
    }
}
