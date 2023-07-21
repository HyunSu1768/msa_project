package com.example.user.adapter.out.persistence;

import com.example.common.annotation.PersistenceAdapter;
import com.example.user.adapter.in.web.rest.dto.request.SaveUserDto;
import com.example.user.adapter.out.persistence.repository.UserRepository;
import com.example.user.application.port.out.SaveUserPort;
import com.example.user.domain.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class UserPersistenceAdapter implements SaveUserPort {

    private final UserRepository userRepository;

    @Override
    public void saveUser(SaveUserDto saveUserDto) {

        userRepository.save(saveUserDto.toUser());

    }
}
