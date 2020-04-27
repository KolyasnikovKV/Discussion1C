package ru.kolyasnikovkv.discussion1c.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import ru.kolyasnikovkv.discussion1c.dto.UserDto;
import ru.kolyasnikovkv.discussion1c.model.User;

@Service
public class DtoToUserConverter implements Converter<UserDto, User> {
    @Override
    public User convert(UserDto source) {
        User user = new User();
        user.setId(source.getId());
        user.setUsername(source.getName());
        return user;
    }
}
