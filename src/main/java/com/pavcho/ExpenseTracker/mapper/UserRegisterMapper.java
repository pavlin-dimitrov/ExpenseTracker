package com.pavcho.ExpenseTracker.mapper;

import com.pavcho.ExpenseTracker.dto.user_dto.UserRegisterDto;
import com.pavcho.ExpenseTracker.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRegisterMapper {

  UserRegisterMapper INSTANCE = Mappers.getMapper(UserRegisterMapper.class);

  User mapUserRegisterDtoToUser(UserRegisterDto userRegisterDto);

  UserRegisterDto mapUserToUserRegisterDto(User user);

}
