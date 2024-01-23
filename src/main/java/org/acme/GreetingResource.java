package org.acme;

import org.jboss.logging.Logger;

import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.inject.Instance;

@Startup
@ApplicationScoped
public class GreetingResource {

    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    GreetingResource(Event<TheEvent> event, Instance<MyService> service) {
        LOG.infof("Service isResolvable before event: %b", service.isResolvable());
        LOG.info("Firing event");
        event.fire(new TheEvent());
        LOG.infof("Service isResolvable after event: %b", service.isResolvable());
    }
}
