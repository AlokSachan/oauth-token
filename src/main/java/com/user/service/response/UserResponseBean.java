package com.user.service.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserResponseBean {
    private Long userId;
    private String fullName;
    private String email;
    private String state;
    private String password;

}
