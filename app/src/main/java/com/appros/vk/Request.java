package com.appros.vk;

import android.util.Log;

import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

/**
 * Created by Vitaly on 20.01.2016.
 */
public class Request {

    protected VKParameters parameters;

    protected String methodBase;

    protected VKRequest request;

    protected VKRequest.VKRequestListener requestListener;

    public interface Listener {

        public void onComplete(VKResponse response);

        public void onError(VKError error);

        public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts);

    }

    public Request(String method) {

        this.request = new VKRequest(method);
    }

    public void execute() {

        this.request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {

                super.onComplete(response);

                System.out.println("VKApi.* onComplete");

                System.out.println(response.json.toString());

                Log.d("onComplete", " - Авторизирован");

            }

            @Override
            public void onError(VKError error) {

                System.out.println("VKApi.* onError");

                System.out.println(error.toString());

                Log.d("onError", " - Авторизирован");
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {

                System.out.println("VKApi.* attemptFailed");
            }
        });
    }

    public void onComplete() {

        //
    }

    public void onError() {

        //
    }

    public void attemptFailed() {

        //
    }

    protected VKRequest getRequest() {
        return this.request;
    }

    protected VKParameters getParameters() {
        return this.parameters;
    }

    /**
     * Возвращает полное имя метода
     * @param methodName
     * @return
     */
    protected String getFullMethodName(String methodName) {

        String fullMethodName = this.getMethodBase() + "" + methodName;

        return fullMethodName;
    }

    public void setMethodBase(String methodBase) {

        this.methodBase = methodBase;
    }

    public String getMethodBase() {

        return this.methodBase;
    }

}
