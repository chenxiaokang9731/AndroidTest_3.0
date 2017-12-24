package com.narkang.util.app;

import android.content.Context;
import android.os.Handler;

import java.util.HashMap;

public class Configurator {

    private static final HashMap<Object, Object> ANT_CONFIGS = new HashMap<>();
    private static final Handler HANDLER = new Handler();

    public Configurator() {
        ANT_CONFIGS.put(ConfigKeys.CONFIG_READY, false);
        ANT_CONFIGS.put(ConfigKeys.HANDLER, HANDLER);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final Configurator withApiHost(String apiHost) {
        ANT_CONFIGS.put(ConfigKeys.API_HOST, apiHost);
        return this;
    }

    final Configurator withApplicationContext(Context context) {
        ANT_CONFIGS.put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) ANT_CONFIGS.get(ConfigKeys.CONFIG_READY);
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    /**
     * 配置完成
     */
    public final void configure() {
        ANT_CONFIGS.put(ConfigKeys.CONFIG_READY, true);
    }

    @SuppressWarnings("unused")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = ANT_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) ANT_CONFIGS.get(key);
    }
}
