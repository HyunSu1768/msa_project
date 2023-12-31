package com.example.adapter.out.persistence;

import com.example.common.annotation.PersistenceAdapter;
import com.example.common.exception.BusinessException;
import com.example.common.exception.ErrorCode;
import com.example.adapter.in.web.rest.dto.request.SaveUserDto;
import com.example.adapter.in.web.rest.dto.response.UserDto;
import com.example.adapter.out.persistence.repository.UserRepository;
import com.example.application.port.out.LoadUserByAccountIdPort;
import com.example.application.port.out.LoadUserPort;
import com.example.application.port.out.SaveUserPort;
import com.example.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class UserPersistenceAdapter implements SaveUserPort, LoadUserPort, LoadUserByAccountIdPort {

    private final UserRepository userRepository;

    @Override
    public void saveUser(SaveUserDto saveUserDto) {

        userRepository.save(saveUserDto.toUser());

    }

    @Override
    public UserDto loadUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        return user.toDto();

    }

    @Override
    public UserDto loadUserByAccountId(String accountId) {

        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        return user.toDto();

    }
}
