package ru.kpfu.itis.bagautdinov.service;

import ru.kpfu.itis.bagautdinov.dto.CreateUserDto;
import ru.kpfu.itis.bagautdinov.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getByEmail(String email);

    UserDto getById(Integer id);

    List<UserDto> getAll();

    UserDto save(CreateUserDto createUserDto);

    List<UserDto> getAllStepan();

    List<UserDto> getAllByName(String name);
}
