package com.appros.lisa;

import android.content.Intent;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

/**
 * Created by vitaly on 20.01.16.
 */
public class MainApplication extends android.app.Application {

    @Override
    public void onCreate(){

        super.onCreate();

        vkAccessTokenTracker.startTracking();

        VKSdk.initialize(this);
    }

    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
                // VKAccessToken is invalid
                System.out.println("Не удалось получить валидный токен...");
            }
        }
    };

}
