package com.ater.commerce.user.dto;

import com.ater.commerce.user.model.UserInformation;
import org.hibernate.annotations.Comments;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public static UserDto convert(UserInformation from){
        return new UserDto(from.getMail(), from.getFirstName(), from.getLastName(), from.getMiddleName());
    }
}
