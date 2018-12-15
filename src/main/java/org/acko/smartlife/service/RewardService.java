package org.acko.smartlife.service;

import org.acko.smartlife.constants.RewardPointType;
import org.acko.smartlife.models.dto.RewardResponse;

/**
 * @author prabodh.hend
 */
public interface RewardService {

    RewardResponse getSummary(Long userId);

    public boolean updateRewards(String rewardId, RewardPointType type, Double amount);
}
