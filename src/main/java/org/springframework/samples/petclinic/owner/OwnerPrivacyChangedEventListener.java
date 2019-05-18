package org.springframework.samples.petclinic.owner;

import org.springframework.context.ApplicationListener;
import org.springframework.samples.petclinic.owner.OwnerService.OwnerPrivacyChangeEvent;
import org.springframework.stereotype.Component;

@Component
public class OwnerPrivacyChangedEventListener implements ApplicationListener<OwnerService.OwnerPrivacyChangeEvent> {
    private final OwnerPrivacyChangeHistoryRepository ownerPrivacyChangeHistories;

    public OwnerPrivacyChangedEventListener(
        OwnerPrivacyChangeHistoryRepository ownerPrivacyChangeHistories) {
        this.ownerPrivacyChangeHistories = ownerPrivacyChangeHistories;
    }

    @Override
    public void onApplicationEvent(OwnerPrivacyChangeEvent ownerPrivacyChangeEvent) {
        OwnerPrivacyChangeHistory ownerPrivacyChangeHistory = ownerPrivacyChangeEvent.getOwnerPrivacyChangeHistory();
        ownerPrivacyChangeHistories.save(ownerPrivacyChangeHistory);
    }
}
