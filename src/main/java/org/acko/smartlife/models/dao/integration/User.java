package org.acko.smartlife.models.dao.integration;

import lombok.Data;

/**
 * @author prabodh.hend
 */
@Data
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String profileName;
    private String password;
    private String countryCode;
    private String contactNumber;
    private boolean accountExpired = false;
    private boolean isEnabled = true;
    private boolean isVerified = true;
    private boolean isDeleted = false;
}
