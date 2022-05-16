package com.integratec.mapper;

import com.integratec.model.domain.Account;
import com.integratec.model.domain.DTO.AccountGetDto;
import com.integratec.model.domain.DTO.AccountPostDto;
import com.integratec.model.domain.DTO.RequestGetDTO;
import com.integratec.model.domain.DTO.RequestPostDTO;
import com.integratec.model.domain.Request;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    Account userPostDtoToUser(AccountPostDto userPostDto);

    List<AccountGetDto> usersToUsersGetDto(List<Account> accounts);

    Request requestPostDTO(RequestPostDTO requestPostDTO);

    List<RequestGetDTO> requestsToRequestsGetDto(List<Request> requests);
}
