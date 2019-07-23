package demoSample.client.app.registration.client.registrationmodification;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class RegistrationModificationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(RegistrationModificationPresenter.class, RegistrationModificationPresenter.MyView.class, RegistrationModificationView.class, RegistrationModificationPresenter.MyProxy.class);
    }
}
