package org.acko.smartlife.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.acko.smartlife.dao.jpa.UserRepository;
import org.acko.smartlife.models.dao.jpa.User;
import org.acko.smartlife.models.dto.UserDto;
import org.acko.smartlife.service.UserService;
import org.acko.smartlife.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author prabodh.hend
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto findByEmail(String email) {
        User user = userRepository.findByUsername(email);
        return UserMapper.map(user);
    }
}
