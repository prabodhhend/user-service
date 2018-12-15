package org.acko.smartlife.dao.jpa;

import org.acko.smartlife.models.dao.jpa.RewardSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author prabodh.hend
 */
@Repository
public interface RewardSummaryRepository extends JpaRepository<RewardSummary, String> {

    RewardSummary findByUserId(Long userId);

    RewardSummary findByRewardId(String rewardId);
}
