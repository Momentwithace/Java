package africa.semicolon.truecaller.dtos.requests;

import lombok.Data;


@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String pin;
    private String email;
}
