package com.rdani2005.uberdirect.domain.event.publisher;

import com.rdani2005.uberdirect.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent<?>> {
    void publish(T domainEvent);
}
