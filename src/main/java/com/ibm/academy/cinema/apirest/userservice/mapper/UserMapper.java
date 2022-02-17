package com.ibm.academy.cinema.apirest.userservice.mapper;

import com.ibm.academy.cinema.apirest.userservice.dto.SubscriberDto;
import com.ibm.academy.cinema.apirest.userservice.dto.UserDto;
import com.ibm.academy.cinema.apirest.userservice.entity.Subscriber;
import com.ibm.academy.cinema.apirest.userservice.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    default UserDto toDto(User user) {
        if (user instanceof Subscriber)
            return toDto((Subscriber) user);
        else
            return null;
    }

    default User toEntity(UserDto userDto) {
        if (userDto instanceof SubscriberDto)
            return toEntity((SubscriberDto) userDto);
        else
            return null;
    }

    SubscriberDto toDto(Subscriber subscriber);
    Subscriber toEntity(SubscriberDto subscriberDto);
}
