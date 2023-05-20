package com.pavcho.ExpenseTracker.mapper;

import com.pavcho.ExpenseTracker.dto.user_dto.UserCreatedDto;
import com.pavcho.ExpenseTracker.entity.User;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserCreatedMapper {

  UserCreatedMapper INSTANCE = Mappers.getMapper(UserCreatedMapper.class);

  @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "toTimestamp")
  User mapUserCreatedDtoToUser(UserCreatedDto userCreatedDto, @Context String timeZone);

  @Mapping(source = "createdAt", target = "createdAt", qualifiedByName = "fromTimestamp")
  UserCreatedDto mapUserToUserCreatedDto(User user, @Context String timeZone);

  @Named("fromTimestamp")
  default LocalDateTime fromTimestamp(Long timestamp, @Context String timeZone) {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of(timeZone));
  }

  @Named("toTimestamp")
  default Long toTimestamp(LocalDateTime localDateTime, @Context String timeZone) {
    return localDateTime.atZone(ZoneId.of(timeZone)).toInstant().toEpochMilli();
  }
}

