package odin.homework.mobilebankingv2.api.user;

import odin.homework.mobilebankingv2.api.user.web.CreateUserDto;
import odin.homework.mobilebankingv2.api.user.web.UserDto;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapstruct {

    List<UserDto> listDtoToListModel (List<User> model);
    UserDto userToUserDto (User model);
    User createUserDtoToUser (CreateUserDto model);


}
