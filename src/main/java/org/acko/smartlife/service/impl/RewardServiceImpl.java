package org.acko.smartlife.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.acko.smartlife.dao.jpa.RewardSummaryRepository;
import org.acko.smartlife.models.dao.jpa.RewardSummary;
import org.acko.smartlife.models.dto.RewardResponse;
import org.acko.smartlife.service.RewardService;
import org.acko.smartlife.service.integration.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author prabodh.hend
 */
@Service
@Slf4j
public class RewardServiceImpl implements RewardService {

    @Autowired
    private UserService userService;

    @Autowired
    private RewardSummaryRepository rewardSummaryRepository;

    @Override
    public RewardResponse getSummary(String userId) {
        userService.validate(userId);
        RewardSummary summary = rewardSummaryRepository.findByUserId(userId);

        return null;
    }
}
