package org.acko.smartlife.service;

import org.acko.smartlife.models.dto.UserDto;

/**
 * @author prabodh.hend
 */
public interface UserService {

    UserDto findByEmail(String email);
}
