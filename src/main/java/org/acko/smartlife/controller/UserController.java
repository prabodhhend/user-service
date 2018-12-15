package org.acko.smartlife.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.acko.smartlife.models.dto.UserDto;
import org.acko.smartlife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author prabodh.hend
 */
@RestController
@RequestMapping("api/v1")
@Slf4j
@Api(value = "UserController ", description = "User Apis", tags = {"User Apis"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/rewards/{email}/")
    public ResponseEntity<UserDto> getRewards(@PathVariable("email") String email) {
        log.info("Fetching user details for user:{}", email);
        UserDto response = userService.findByEmail(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
