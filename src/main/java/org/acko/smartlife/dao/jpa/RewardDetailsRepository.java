package org.acko.smartlife.dao.jpa;

import org.acko.smartlife.models.dao.jpa.RewardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author prabodh.hend
 */
@Repository
public interface RewardDetailsRepository extends JpaRepository<RewardDetails, String> {

    List<RewardDetails> findByRewardId(String rewardId);
}
