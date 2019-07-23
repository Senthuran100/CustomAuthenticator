package com.wso2.sample.authentification.custom.internal;


import com.wso2.sample.authentification.custom.SampleGetUsername;
import com.wso2.sample.authentification.custom.SampleValidateUsername;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;


@Component(
        name = "com.wso2.sample.authentification.custom",
        immediate = true
)
public class SampleValidateUsernameComponent {

    private static final Log LOGGER = LogFactory.getLog(SampleValidateUsernameComponent.class);

    @Activate
    protected void activate(ComponentContext context) {
        BundleContext bundleContext = context.getBundleContext();
        bundleContext.registerService(SampleGetUsername.class,
              new  SampleValidateUsername(), null);
        LOGGER.info("Validate Username Component is activated");
    }

    @Deactivate
    protected void deactivate(ComponentContext context) {
        LOGGER.info("Validate Username Component is deactivated");
    }

}