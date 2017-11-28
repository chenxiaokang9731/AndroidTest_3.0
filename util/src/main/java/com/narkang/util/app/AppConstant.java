package com.narkang.util.app;

import android.content.Context;
import android.os.Handler;

public class AppConstant {

    public static Configurator init(Context context) {
        Configurator.getInstance()
                .withApplicationContext(context);

        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    @SuppressWarnings("unused")
    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfigurator().getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }

    public static String getApiHost() {
        return getConfigurator().getConfiguration(ConfigKeys.API_HOST);
    }

    public static Handler getHandler() {
        return getConfigurator().getConfiguration(ConfigKeys.HANDLER);
    }
}
