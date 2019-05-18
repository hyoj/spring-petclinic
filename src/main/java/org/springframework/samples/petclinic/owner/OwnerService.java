package org.springframework.samples.petclinic.owner;

import java.util.Collection;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class OwnerService implements ApplicationEventPublisherAware {
    private final OwnerRepository owners;
    private ApplicationEventPublisher eventPublisher;

    public OwnerService(OwnerRepository owners) {
        this.owners = owners;
    }

    public Owner save(Owner owner) {
        this.owners.save(owner);
        eventPublisher.publishEvent(new OwnerPrivacyChangeEvent(this, owner, "C"));
        return owner;
    }

    public Collection<Owner> findByLastName(String lastName) {
        return this.owners.findByLastName(lastName);
    }

    public Owner findById(int ownerId) {
        return this.owners.findById(ownerId);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    static class OwnerPrivacyChangeEvent extends ApplicationEvent {
        private OwnerPrivacyChangeHistory ownerPrivacyChangeHistory;

        private OwnerPrivacyChangeEvent(Object source, Owner owner, String changeType) {
            super(source);
            final OwnerPrivacyChangeHistory ownerPrivacyChangeHistory = new OwnerPrivacyChangeHistory();
            ownerPrivacyChangeHistory.setOwnerId(owner.getId());
            ownerPrivacyChangeHistory.setChangeType(changeType);

            this.ownerPrivacyChangeHistory = ownerPrivacyChangeHistory;
        }

        OwnerPrivacyChangeHistory getOwnerPrivacyChangeHistory() {
            return ownerPrivacyChangeHistory;
        }
    }
}
