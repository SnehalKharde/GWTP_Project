package demoSample.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import demoSample.client.app.registration.app.ApplicationModule;
import demoSample.client.place.NameTokens;
import demoSample.client.resources.ResourceLoader;

public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule
                .Builder()
                .defaultPlace(NameTokens.HOME)
                .errorPlace(NameTokens.HOME)
                .unauthorizedPlace(NameTokens.HOME)
                .build());
        install(new ApplicationModule());

        bind(ResourceLoader.class).asEagerSingleton();

    }
}
