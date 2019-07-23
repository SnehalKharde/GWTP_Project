package demoSample.client.app.registration.app;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import demoSample.client.HomeModule;
import demoSample.client.app.registration.RegistrationModule;
import demoSample.client.app.registration.client.registrationmodification.RegistrationModificationModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new RegistrationModificationModule());
        install(new HomeModule());
        install(new RegistrationModule());
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
