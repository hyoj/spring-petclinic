package org.springframework.samples.petclinic.owner;

import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface OwnerPrivacyChangeHistoryRepository extends Repository<OwnerPrivacyChangeHistory, Integer> {

    void save(OwnerPrivacyChangeHistory ownerPrivacyChangeHistory);
}
