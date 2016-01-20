package com.appros.lisa;

import android.support.annotation.NonNull;

import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

/**
 * Created by vitaly on 19.01.16.
 */
public class VkApi {


    public void getPlacesList(){

        VKRequest request = new VKRequest("places.search", VKParameters.from(VKApiConst.USER_ID, 167600225));

        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {

                System.out.println("VKApi.users onComplete");

                System.out.println( response.json.toString() );

            }

            @Override
            public void onError(VKError error) {

                System.out.println("VKApi.users onError");

                System.out.println(error.toString() );
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {

                System.out.println("VKApi.users attemptFailed");
            }
        });

    }

}
