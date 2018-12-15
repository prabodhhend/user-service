package org.acko.smartlife.models.dao.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author prabodh.hend
 */
@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @LastModifiedDate
    @JsonIgnore
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @JsonIgnore
    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;

    @JsonIgnore
    @Column(name = "is_deleted")
    private boolean deleted;

}
