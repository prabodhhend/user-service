package org.acko.smartlife.service;

import org.acko.smartlife.models.dto.RewardResponse;

/**
 * @author prabodh.hend
 */
public interface RewardService {

    RewardResponse getSummary(String userId);
}
