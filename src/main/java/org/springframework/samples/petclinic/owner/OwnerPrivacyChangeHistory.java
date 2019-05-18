package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;

@Entity
@Table(name = "owner_privacy_change_hist")
public class OwnerPrivacyChangeHistory extends BaseEntity {

    @Column(name = "owner_id")
    private Integer ownerId;

    @Column(name = "change_type")
    private String changeType;

    @Column(name = "change_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate changeTime;

    public OwnerPrivacyChangeHistory() {
        this.changeTime = LocalDate.now();
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public LocalDate getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(LocalDate changeTime) {
        this.changeTime = changeTime;
    }
}
