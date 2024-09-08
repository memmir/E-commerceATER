package com.ater.commerce.user.dto;

import com.ater.commerce.user.model.User;
import org.hibernate.annotations.Comments;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public static UserDto convert(User from){
        return new UserDto(from.getMail(), from.getFirstName(), from.getLastName(), from.getMiddleName());
    }
}
