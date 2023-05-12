package com.pavcho.ExpenseTracker.service.implementation;

import com.pavcho.ExpenseTracker.dto.UserRegisterDto;
import com.pavcho.ExpenseTracker.entity.User;
import com.pavcho.ExpenseTracker.enums.Role;
import com.pavcho.ExpenseTracker.exception.EmailIsTakenException;
import com.pavcho.ExpenseTracker.exception.UserNotFoundException;
import com.pavcho.ExpenseTracker.mapper.UserRegisterMapper;
import com.pavcho.ExpenseTracker.repository.UserRepository;
import com.pavcho.ExpenseTracker.service.contract.UserService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  @Autowired
  private final UserRepository userRepository;
  @Autowired
  private final MongoTemplate mongoTemplate;
  private static final String DEFAULT_IMAGE_LINK =
      "https://drive.google.com/file/d/1W1viYGAN02JMMPbBnbewuaCdR9OHQS1r/view?usp=share_link";


  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public UserRegisterDto registerNewUser(UserRegisterDto userRegisterDto) {
    checkForExistingEmail(userRegisterDto);
    User newUser = UserRegisterMapper.INSTANCE.mapUserRegisterDtoToUser(userRegisterDto);
    newUser.setPassword(userRegisterDto.getPassword());
    if (newUser.getPictureUrl() == null) {
      newUser.setPictureUrl(DEFAULT_IMAGE_LINK);
    }
    if (newUser.getRole() == null) {
      newUser.setRole(Role.USER);
    }
    userRepository.insert(newUser);
    return UserRegisterMapper.INSTANCE.mapUserToUserRegisterDto(newUser);
  }

  @Override
  public User findByEmail(String email) {
    Optional<User> user = userRepository.findByEmail(email);
    if (user.isEmpty()){
      throw new UserNotFoundException();
    }

    return user.get();
  }

  @Override
  public List<User> deleteByEmail(String email) {
    Optional<User> deleteUser = userRepository.findByEmail(email);
    if (deleteUser.isEmpty()) {
      throw new UserNotFoundException();
    }

    userRepository.delete(deleteUser.get());
    return userRepository.findAll();
  }

  @Override
  public User editUserInfo(User user) {
    Optional<User> optionalUser = userRepository.findById(user.getId());
    if (optionalUser.isEmpty()) {
      throw new UserNotFoundException();
    }
    User editUser = optionalUser.get();
    editUser.setFirstName(user.getFirstName());
    editUser.setLastName(user.getLastName());
    editUser.setEmail(user.getEmail());

    Query query = new Query();
    query.addCriteria(Criteria.where("id").is(user.getId()));
    Update update = new Update();
    update.set("firstName", user.getFirstName());
    update.set("lastName", user.getLastName());
    update.set("email", user.getEmail());

    mongoTemplate.updateFirst(query, update, User.class);

    return editUser;
  }

  private void checkForExistingEmail(UserRegisterDto userRegisterDto) {
    Optional<User> accountByEmail =
        userRepository.findByEmail(userRegisterDto.getEmail());
    if (accountByEmail.isPresent()) {
      throw new EmailIsTakenException();
    }
  }

}
