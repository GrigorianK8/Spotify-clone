package com.grigoriank.spotifyBackend.usercontext.mapper;

import com.grigoriank.spotifyBackend.usercontext.ReadUserDTO;
import com.grigoriank.spotifyBackend.usercontext.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    ReadUserDTO readUserDTOToUser(User entity);
}
