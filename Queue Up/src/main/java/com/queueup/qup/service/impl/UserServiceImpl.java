package com.queueup.qup.service.impl;

import com.queueup.qup.dto.UserDto;
import com.queueup.qup.entity.User;
import com.queueup.qup.repository.UserRepo;
import com.queueup.qup.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService/*, GenericCrudService<UserDto, Integer>*/ {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
/*

    @Override
    public UserDto create(UserDto userdto) {
        User entity = User.builder()
                .id(userdto.getId())
                .userName(userdto.getUserName())
                .name(userdto.getName())
                .email(userdto.getEmail())
                .password(userdto.getPassword())
                .phoneNumber(userdto.getPhoneNumber())
                .build();
        entity=userRepo.save(entity);
        return UserDto.builder().id(entity.getId())
                .userName(entity.getUserName())
                .name(entity.getName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }
*/

    @Override
    public UserDto save(UserDto userDto) {
        User entity = User.builder()
                .id(userDto.getId())
                .userName(userDto.getUserName())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .phoneNumber(userDto.getPhoneNumber())
                .gender(userDto.getGender())
                .build();
        entity = userRepo.save(entity);
        return userDto.builder()
                .id(entity.getId())
                .userName(userDto.getUserName())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .phoneNumber(userDto.getPhoneNumber())
                .gender(userDto.getGender())
                .build();
    }

    @Override
    public List<UserDto> findAll() {
        List<User> userList = userRepo.findAll();
        return userList.stream().map(
                user -> UserDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .userName(user.getUserName())
                        .email(user.getEmail())
                        .gender(user.getGender())
                        .phoneNumber(user.getPhoneNumber())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

 /*   @Override
    public void delete(Integer id) {

    }*/
}
