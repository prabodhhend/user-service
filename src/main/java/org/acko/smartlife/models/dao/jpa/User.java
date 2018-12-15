package org.acko.smartlife.models.dao.jpa;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author prabodh.hend
 */
@Data
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@Where(clause = "is_deleted = 0")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "account_expired", columnDefinition = "BIT")
    private boolean accountExpired = false;

    @Column(name = "is_enabled", columnDefinition = "BIT")
    private boolean isEnabled = true;

    @Column(name = "is_verified", columnDefinition = "BIT")
    private boolean isVerified = true;

    @Column(name = "is_deleted", columnDefinition = "BIT")
    private boolean isDeleted = false;


}