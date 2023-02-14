package models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String postCode;

}
