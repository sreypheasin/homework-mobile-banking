package odin.homework.mobilebankingv2.api.user;

import odin.homework.mobilebankingv2.api.user.web.UserController;
import odin.homework.mobilebankingv2.api.user.web.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<User, EntityModel<UserDto>> {

    private UserMapstruct userMapstruct;

    @Autowired
    public void setUserMapstruct(UserMapstruct userMapstruct) {
        this.userMapstruct = userMapstruct;
    }

    @SuppressWarnings("unchecked")
    public UserModelAssembler() {
        super(UserController.class, (Class<EntityModel<UserDto>>) (Class<?>) EntityModel.class);
    }

    @Override
    public EntityModel<UserDto> toModel(User entity) {

        UserDto userDto = userMapstruct.userToUserDto(entity);

        Link selfLink = linkTo(methodOn(UserController.class).findByUuid(entity.getUuid())).withSelfRel();
        Link collectionLink = linkTo(methodOn(UserController.class).findAll()).withRel(IanaLinkRelations.COLLECTION);

        return EntityModel.of(userDto,selfLink,collectionLink);
    }

    @Override
    public CollectionModel<EntityModel<UserDto>> toCollectionModel(Iterable<? extends User> entities) {
        return super.toCollectionModel(entities);
    }

}
