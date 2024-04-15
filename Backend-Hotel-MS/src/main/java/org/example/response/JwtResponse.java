package org.example.response;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String email;
    private List<String> roles;

    public JwtResponse(String token,
                       String email, List<String> roles) {
        this.token = token;
        this.email = email;
        this.roles = roles;
    }
}
