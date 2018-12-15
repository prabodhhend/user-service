package org.acko.smartlife.dao.jpa;

import org.acko.smartlife.models.dao.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author prabodh.hend
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String userId);
}
