package org.acko.smartlife.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.acko.smartlife.dao.jpa.CheckupRepository;
import org.acko.smartlife.models.dao.jpa.Checkup;
import org.acko.smartlife.models.dto.CheckupResponse;
import org.acko.smartlife.service.CheckupService;
import org.acko.smartlife.service.integration.UserService;
import org.acko.smartlife.service.mapper.CheckupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author prabodh.hend
 */
@Service
@Slf4j
public class CheckupServiceImpl implements CheckupService {

    @Autowired
    private UserService userService;

    @Autowired
    private CheckupRepository checkupRepository;

    @Override
    public List<CheckupResponse> getDetails(String userId) {
        log.info("Fetching checkup details");
        userService.validate(userId);
        List<Checkup> checkupList = checkupRepository.findByUserId(userId);
        return CheckupMapper.map(checkupList);
    }
}
