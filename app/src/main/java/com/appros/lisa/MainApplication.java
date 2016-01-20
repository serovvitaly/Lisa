package com.appros.lisa;

import com.vk.sdk.VKSdk;

/**
 * Created by vitaly on 20.01.16.
 */
public class MainApplication extends android.app.Application {

    @Override
    public void onCreate(){

        VKSdk.initialize(this);
    }

}
