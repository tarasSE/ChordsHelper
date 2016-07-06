package com.generic.webproject.data;

import com.generic.webproject.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class UserDTO extends GenericDTO<User> {

    private Integer id;

    private String username;

    private String password;

    private String email;

}
