package com.dw.basic.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String password;
    private String email;
    private String realName;
    private String role;
    private String createdAt;
}
