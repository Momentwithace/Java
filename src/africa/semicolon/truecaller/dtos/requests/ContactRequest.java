package africa.semicolon.truecaller.dtos.requests;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ContactRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String userEmail;

}