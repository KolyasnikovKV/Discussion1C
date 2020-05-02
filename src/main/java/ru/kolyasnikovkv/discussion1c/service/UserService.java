package ru.kolyasnikovkv.discussion1c.service;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.*;
import org.springframework.stereotype.Service;
import ru.kolyasnikovkv.discussion1c.dto.UserDto;
import ru.kolyasnikovkv.discussion1c.model.User;
import ru.kolyasnikovkv.discussion1c.repository.jpa.CrudUserJpaDao;

@Service
@AllArgsConstructor
public class UserService {

    private final CrudUserJpaDao repository;
    private final Converter<User, UserDto> converter;
    private final Converter<UserDto, User> converterDto;

   /* public List<AccountDTO> listByUser(Long userId) {
        return accountRepository.findAccountsByOwnerId(userId)
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
*/

    public User selectById(Integer id) {
        User user = repository.findById(id);
        // checkNotFoundWithId(country, id);
        return user;
    }

    public UserDto get(Integer id) {
        User user = repository.findById(id);
       // checkNotFoundWithId(country, id);
        return converter.convert(user);
    }

    public void delete(Integer id) {
        //checkNotFoundWithId(repository.delete(id), id);

    }

    public UserDto create(UserDto userDto){
        User user = converterDto.convert(userDto);
        user = repository.save(user);
        return converter.convert(user);
    }

    public UserDto update(UserDto userDto) {
        User user = repository.findById(userDto.getId());
        //country = checkNotFoundWithId(country, countryDto.getId());
        user.setUsername(userDto.getName());
        user = repository.save(user);
        return converter.convert(user);
    }
}