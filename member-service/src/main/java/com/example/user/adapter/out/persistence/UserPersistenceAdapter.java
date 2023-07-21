package com.example.user.adapter.out.persistence;

import com.example.common.annotation.PersistenceAdapter;
import com.example.common.exception.BusinessException;
import com.example.common.exception.ErrorCode;
import com.example.user.adapter.in.web.rest.dto.request.SaveUserDto;
import com.example.user.adapter.in.web.rest.dto.response.UserDto;
import com.example.user.adapter.out.persistence.repository.UserRepository;
import com.example.user.application.port.out.LoadUserPort;
import com.example.user.application.port.out.SaveUserPort;
import com.example.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class UserPersistenceAdapter implements SaveUserPort, LoadUserPort {

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
}
