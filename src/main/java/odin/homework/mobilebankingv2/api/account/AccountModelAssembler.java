package odin.homework.mobilebankingv2.api.account;

import odin.homework.mobilebankingv2.api.account.web.AccountController;
import odin.homework.mobilebankingv2.api.account.web.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;

@Component
public class AccountModelAssembler extends RepresentationModelAssemblerSupport<Account, EntityModel<AccountDto>> {

    private AccountMapstruct accountMapstruct;
    @Autowired
    public void setAccountMapstruct(AccountMapstruct accountMapstruct) {
        this.accountMapstruct = accountMapstruct;
    }

    @SuppressWarnings("unchecked")
    public AccountModelAssembler() {
        super(AccountController.class, (Class<EntityModel<AccountDto>>) (Class<?>) EntityModel.class);
    }

    @Override
    public EntityModel<AccountDto> toModel(Account entity) {
        AccountDto accountDto = accountMapstruct.modelToDto(entity);
        Link selfLink = linkTo(methodOn(AccountController.class).findByUuid(entity.getUuid())).withSelfRel();
        Link collection = linkTo(methodOn(AccountController.class).findAll()).withRel(IanaLinkRelations.COLLECTION);
        return EntityModel.of(accountDto,selfLink,collection);
    }

    @Override
    public CollectionModel<EntityModel<AccountDto>> toCollectionModel(Iterable<? extends Account> entities) {
        return super.toCollectionModel(entities);
    }
}
