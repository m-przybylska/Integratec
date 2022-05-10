package com.integratec.mapper;

import com.integratec.model.domain.Account;
import com.integratec.model.domain.DTO.AccountGetDto;
import com.integratec.model.domain.DTO.AccountPostDto;
import com.integratec.model.domain.DTO.RequestGetDTO;
import com.integratec.model.domain.DTO.RequestPostDTO;
import com.integratec.model.domain.Request;

import java.util.ArrayList;
import java.util.List;

public class MapStructMapperImpl implements MapStructMapper{

    @Override
    public List<AccountGetDto> usersToUsersGetDto(List<Account> accounts) {
        List<AccountGetDto> accountGetDtos = new ArrayList<>();
        for(int i = 0; i < accounts.size(); i++){
            accountGetDtos.add(i, new AccountGetDto());
            accountGetDtos.get(i).setAccountId(accounts.get(i).getAccountId());
            accountGetDtos.get(i).setName(accounts.get(i).getName());
            accountGetDtos.get(i).setSurname(accounts.get(i).getSurname());
        }
        return accountGetDtos;
    }

    @Override
    public Account userPostDtoToUser(AccountPostDto userPostDto) {
        if ( userPostDto == null ) {
            return null;
        }

        Account user = new Account();

        user.setAccountId(userPostDto.getAccountId() );
        user.setLogin( userPostDto.getLogin() );
        user.setPassword( userPostDto.getPassword() );
        user.setName( userPostDto.getName() );
        user.setSurname( userPostDto.getSurname() );

        return user;
    }

    @Override
    public Request requestPostDTO(RequestPostDTO requestPostDTO){
        if( requestPostDTO == null){
            return null;
        }

        Request request = new Request();
        Account account = new Account();
        account.setAccountId(requestPostDTO.getSender());
        request.setRequestId(requestPostDTO.getRequestId());
        request.setReceiver(requestPostDTO.getReceiver());
        request.setSender(account);
        request.setTitle(requestPostDTO.getTitle());
        request.setText(requestPostDTO.getText());
        request.setComment(requestPostDTO.getComment());
        request.setSendDate(requestPostDTO.getSendDate());
        request.setRequestCategory(requestPostDTO.getRequestCategory());
        request.setRequestStatus(requestPostDTO.getRequestStatus());
        request.setRequestPriority(requestPostDTO.getRequestPriority());
        return request;

    }

    @Override
    public List<RequestGetDTO> requestsToRequestsGetDto(List<Request> requests){ List<AccountGetDto> accountGetDtos = new ArrayList<>();
        List<RequestGetDTO> reqestsGetDtos = new ArrayList<>();
        for(int i = 0; i < requests.size(); i++){
            reqestsGetDtos.add(i, new RequestGetDTO());
            reqestsGetDtos.get(i).setRequestId(requests.get(i).getRequestId());
            reqestsGetDtos.get(i).setReceiver(requests.get(i).getReceiver());
            reqestsGetDtos.get(i).setSender(requests.get(i).getSender().getAccountId());
            reqestsGetDtos.get(i).setName(requests.get(i).getSender().getName());
            reqestsGetDtos.get(i).setSurname(requests.get(i).getSender().getSurname());
            reqestsGetDtos.get(i).setTitle(requests.get(i).getTitle());
            reqestsGetDtos.get(i).setText(requests.get(i).getText());
            reqestsGetDtos.get(i).setComment(requests.get(i).getComment());
            reqestsGetDtos.get(i).setSendDate(requests.get(i).getSendDate());
            reqestsGetDtos.get(i).setRequestCategory(requests.get(i).getRequestCategory());
            reqestsGetDtos.get(i).setRequestStatus(requests.get(i).getRequestStatus());
            reqestsGetDtos.get(i).setRequestPriority(requests.get(i).getRequestPriority());
            reqestsGetDtos.get(i).setRequestStatus(requests.get(i).getRequestStatus());
        }
        return reqestsGetDtos;


    }
}
