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

    // region [Account]
    public void addUser(AddUserInput input, final CloudCallback.AddUserCb cb) {

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
                .url(Constant.URL_ADD_USER)
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
                AddUserOutput output = parseAddUserInput(json);
                cb.onResponse(output);
            }

            @Override
            public void onFailure(Call call, IOException e) {
                KLog.d("addUser onFailure");
                cb.onFailure();
            }
        });
    }

    public AddUserOutput parseAddUserInput(String json) {

        AddUserOutput output = null;
        ObjectMapper om = new ObjectMapper();
        try {

            ArrayList<AddUserOutput> list =
                    om.readValue(json,
                            new TypeReference<List<AddUserOutput>>() {
                            });
            output = list.get(0);
        } catch (IOException e) {
            KLog.i(Log.getStackTraceString(e));
        }

        return output;
    }

    public void authUser(AuthUserInput input, final CloudCallback.AuthUserCb cb) {

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
                .url(Constant.URL_AUTH_USER)
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
                AuthUserOutput output = parseAuthUserInput(json);
                cb.onResponse(output);
            }

            @Override
            public void onFailure(Call call, IOException e) {
                KLog.d("addUser onFailure");
                cb.onFailure();
            }
        });
    }

    public AuthUserOutput parseAuthUserInput(String json) {

        AuthUserOutput output = null;
        ObjectMapper om = new ObjectMapper();
        try {

            ArrayList<AuthUserOutput> list =
                    om.readValue(json,
                            new TypeReference<List<AuthUserOutput>>() {
                            });
            output = list.get(0);
        } catch (IOException e) {
            KLog.i(Log.getStackTraceString(e));
        }

        return output;
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
