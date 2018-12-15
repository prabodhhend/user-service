package org.acko.smartlife.dao.jpa;

import org.acko.smartlife.models.dao.jpa.CheckupDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author prabodh.hend
 */
@Repository
public interface CheckupDetailsRepository extends JpaRepository<CheckupDetails, String> {

    List<CheckupDetails> findByCheckupId(String checkupId);
}
