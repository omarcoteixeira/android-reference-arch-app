package br.com.omarcoteixeira.apps.ref.base;

import android.app.Activity;

import br.com.omarcoteixeira.apps.ref.home.MainActivity;
import br.com.omarcoteixeira.apps.ref.home.MainActivityComponent;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        MainActivityComponent.class
})
public abstract class ActivityBindModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> provideActivityInjector(MainActivityComponent.Builder builder);
}
