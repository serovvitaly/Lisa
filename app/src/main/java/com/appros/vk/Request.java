package com.appros.vk;

import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

/**
 * Created by Vitaly on 20.01.2016.
 */
public class Request {

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

                System.out.println("VKApi.users onComplete");

                System.out.println(response.json.toString());

            }

            @Override
            public void onError(VKError error) {

                System.out.println("VKApi.users onError");

                System.out.println(error.toString());
            }

            @Override
            public void attemptFailed(VKRequest request, int attemptNumber, int totalAttempts) {

                System.out.println("VKApi.users attemptFailed");
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
