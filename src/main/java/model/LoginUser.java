package model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
//@Data
@Builder


public class LoginUser {

    // pojo = ono iz cega je objekat sadrzan, sta je tema (username i password)

    String username;
    String password;

}
