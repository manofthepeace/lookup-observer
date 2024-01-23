package org.acme;

import org.jboss.logging.Logger;

import io.quarkus.arc.lookup.LookupIfProperty;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@LookupIfProperty(name = "my.feature", stringValue = "true")
@ApplicationScoped
public class MyService {

    private static final Logger LOG = Logger.getLogger(MyService.class);

    MyService() {
        LOG.info("MyService ctor called");
    }

    void myObserver(@Observes TheEvent event) {
        LOG.info("Observer Called");
    }

}
