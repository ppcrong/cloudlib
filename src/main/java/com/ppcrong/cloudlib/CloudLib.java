package com.ppcrong.cloudlib;

import android.util.Log;

import com.ppcrong.cloudlib.callback.CloudCallback;
import com.ppcrong.cloudlib.model.AddUserInput;
import com.ppcrong.cloudlib.model.AddUserOutput;
import com.ppcrong.cloudlib.model.AuthUserInput;
import com.ppcrong.cloudlib.model.AuthUserOutput;
import com.ppcrong.cloudlib.utils.Constant;
import com.socks.library.KLog;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Cloud Library
 */
public class CloudLib {

    // region [Common]
    private <IN, OUT> void postJson(String url, IN input, final CloudCallback<OUT> cb, final TypeReference outTypeRef) {

        ObjectMapper om = new ObjectMapper();
        String json = "";
        try {
            json = om.writeValueAsString(input);
        } catch (Exception e) {
            KLog.i(Log.getStackTraceString(e));
        }
        KLog.i("POST json:");
        KLog.json(json);

        RequestBody body = RequestBody.create(Constant.JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                KLog.i("Response json:");
                KLog.json(json);
//                OUT output = parseJsonOutput(json, outTypeRef);
                ArrayList<OUT> outputs = parseJsonOutputs(json, outTypeRef);
                cb.onResponse(outputs);
            }

            @Override
            public void onFailure(Call call, IOException e) {
                KLog.d("addUser onFailure");
                cb.onFailure();
            }
        });
    }

    private <T> ArrayList<T> parseJsonOutputs(String json, TypeReference outTypeRef) {

        ArrayList<T> outputs = null;
        ObjectMapper om = new ObjectMapper();
        try {

            outputs = om.readValue(json, outTypeRef);
        } catch (IOException e) {
            KLog.i(Log.getStackTraceString(e));
        }

        return outputs;
    }

    private <T> T parseJsonOutput(String json, TypeReference outTypeRef) {

        T output = null;
        ObjectMapper om = new ObjectMapper();
        try {

            ArrayList<T> list = om.readValue(json, outTypeRef);
            output = list.get(0);
        } catch (IOException e) {
            KLog.i(Log.getStackTraceString(e));
        }

        return output;
    }
    // endregion [Common]

    // region [Account]
    public void addUser(AddUserInput input, final CloudCallback<AddUserOutput> cb) {

        postJson(Constant.URL_ADD_USER, input, cb,
                new TypeReference<ArrayList<AddUserOutput>>() {
                });
    }

    public void authUser(AuthUserInput input, final CloudCallback<AuthUserOutput> cb) {

        postJson(Constant.URL_AUTH_USER, input, cb,
                new TypeReference<ArrayList<AuthUserOutput>>() {
                });
    }
    // endregion [Account]

    // region [UserSetting]
    // endregion [UserSetting]

    // region [UserDevice]
    // endregion [UserDevice]

    // region [UserGoal]
    // endregion [UserGoal]

    // region [UploadHistory]
    // region [HR]
    // endregion [HR]

    // region [Sleep]
    // endregion [Sleep]

    // region [Step]
    // endregion [Step]

    // region [Bike]
    // endregion [Bike]

    // region [Swim]
    // endregion [Swim]

    // region [Video]
    // endregion [Video]
    // endregion [UploadHistory]
}
