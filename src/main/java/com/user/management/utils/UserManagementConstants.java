package com.user.management.utils;

public class UserManagementConstants {

    private UserManagementConstants(){}

    public static final String[] NON_RESTRICTED_ENDPOINTS={"/swagger-ui.html", "/swagger-ui/**","/v3/**","/v1/authorities","/v1/roles",
            "/v1/map/authoritiesmapping","/v1/map/authority","/v1/users"};
}
