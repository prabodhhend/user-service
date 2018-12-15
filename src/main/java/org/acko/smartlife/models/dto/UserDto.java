package org.acko.smartlife.models.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author prabodh.hend
 */
@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String countryCode;
    private String contactNumber;
    private boolean accountExpired = false;
    private boolean isEnabled = true;
    private boolean isVerified = true;
    private boolean isDeleted = false;
}