package Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserProfile {

    public String login;
    public String password;

    public UserProfile(String login, String password){
        this.login=login;
        this.password=password;
    }
}
