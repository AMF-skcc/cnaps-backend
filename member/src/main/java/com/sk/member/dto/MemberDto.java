package com.sk.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {
    private String username;
    private String nickname;
    private String email;
    private String role;
    private String password;
}
