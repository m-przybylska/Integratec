package mapper;

import com.integratec.model.domain.Account;
import com.integratec.model.domain.DTO.AccountGetDto;
import com.integratec.model.domain.DTO.AccountPostDto;

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
}
