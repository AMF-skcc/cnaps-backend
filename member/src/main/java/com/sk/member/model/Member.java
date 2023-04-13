package com.sk.member.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/*
현재 수행하는 인증 처리가 수강 대상자의 눈높이와 다를 수 있어 단순화가 필요할 수 있음
 */

@Data
@Table(name = "member")
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;

    private String nickname;

    @Column(nullable = false)
    private String email;

    private String role;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Lob
    private byte[] salt;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String passwordHash;

    public Member(String username, String nickname, String email, String role, String password) {
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.role = role;
        this.salt = generateSalt();
        this.passwordHash = generatePasswordHash(password, salt);
    }

    public Member() {

    }

    public boolean login(String email, String password) {
        if (this.email.equals(email) && verifyPassword(password, salt, passwordHash)) {
            System.out.println("Login successful!"); // 실무에서는 System.out.println 대신 logger를 사용하여야 합니다.
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    public void setPassword(String newPassword) {
        byte[] newSalt = generateSalt();
        String newPasswordHash = generatePasswordHash(newPassword, newSalt);
        // Check password security requirements
        if (!newPasswordHash.equals(passwordHash)) {
            passwordHash = newPasswordHash;
            salt = newSalt;
            System.out.println("Password has been updated successfully.");
        } else {
            System.out.println("Invalid password. Please choose a different password.");
        }
    }

    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private String generatePasswordHash(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean verifyPassword(String password, byte[] salt, String passwordHash) {
        String hashedPassword = generatePasswordHash(password, salt);
        return hashedPassword != null && hashedPassword.equals(passwordHash);
    }

}
