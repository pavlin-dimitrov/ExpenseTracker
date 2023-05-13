package com.pavcho.ExpenseTracker.mapper;

import com.pavcho.ExpenseTracker.dto.UserDto;
import com.pavcho.ExpenseTracker.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  User mapUserDtoToUser(UserDto userDto);

  UserDto mapUserToUserDto(User user);
}
