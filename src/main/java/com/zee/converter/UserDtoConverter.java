package com.zee.converter;

import com.zee.dto.UserDTO;
//import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import com.zee.service.UserService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationPropertiesBinding
public class UserDtoConverter implements Converter<String, UserDTO> {


    UserService userService;

    public UserDtoConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {

        if (source == null || source.equals("")) {
            return null;
        }

        return userService.findByUserName(source);

    }

}
