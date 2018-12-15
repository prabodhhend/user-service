package org.acko.smartlife.service.mapper;

import org.acko.smartlife.models.dao.jpa.User;
import org.acko.smartlife.models.dto.UserDto;

/**
 * @author prabodh.hend
 */
public class UserMapper {

    public static UserDto map(User user)
    {
        UserDto response = new UserDto();
        if (null != user) {
            response.setAccountExpired(user.isAccountExpired());
            response.setContactNumber(user.getContactNumber());
            response.setCountryCode(user.getCountryCode());
            response.setDeleted(user.isDeleted());
            response.setEnabled(user.isEnabled());
            response.setFirstName(user.getFirstName());
            response.setId(user.getId());
            response.setLastName(user.getLastName());
            response.setUsername(user.getUsername());
            response.setVerified(user.isVerified());
        }
        return response;
    }
}
