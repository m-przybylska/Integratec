package com.integratec.mapper;

import com.integratec.model.domain.Account;
import com.integratec.model.domain.DTO.AccountGetDto;
import com.integratec.model.domain.DTO.AccountPostDto;
import org.mapstruct.Mapper;
import java.util.List;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    Account userPostDtoToUser(AccountPostDto userPostDto);

    List<AccountGetDto> usersToUsersGetDto(List<Account> accounts);
}
