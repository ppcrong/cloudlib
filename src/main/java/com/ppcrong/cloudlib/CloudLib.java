package com.ppcrong.cloudlib;

import android.util.Log;

import com.ppcrong.cloudlib.callback.CloudCallback;
import com.ppcrong.cloudlib.model.AddUserFBInput;
import com.ppcrong.cloudlib.model.AddUserFBOutput;
import com.ppcrong.cloudlib.model.AddUserInput;
import com.ppcrong.cloudlib.model.AddUserOutput;
import com.ppcrong.cloudlib.model.AddUserWithMailInput;
import com.ppcrong.cloudlib.model.AddUserWithMailOutput;
import com.ppcrong.cloudlib.model.AuthUserFBInput;
import com.ppcrong.cloudlib.model.AuthUserFBOutput;
import com.ppcrong.cloudlib.model.AuthUserInput;
import com.ppcrong.cloudlib.model.AuthUserOutput;
import com.ppcrong.cloudlib.model.BikeAddInput;
import com.ppcrong.cloudlib.model.BikeAddOutput;
import com.ppcrong.cloudlib.model.EditAccountFBInput;
import com.ppcrong.cloudlib.model.EditAccountFBOutput;
import com.ppcrong.cloudlib.model.EditAccountInput;
import com.ppcrong.cloudlib.model.EditAccountOutput;
import com.ppcrong.cloudlib.model.EditUserSettingInput;
import com.ppcrong.cloudlib.model.EditUserSettingOutput;
import com.ppcrong.cloudlib.model.GetUserSettingInput;
import com.ppcrong.cloudlib.model.GetUserSettingOutput;
import com.ppcrong.cloudlib.model.HeartRateAddInput;
import com.ppcrong.cloudlib.model.HeartRateAddOutput;
import com.ppcrong.cloudlib.model.ReSendUserMailInput;
import com.ppcrong.cloudlib.model.ReSendUserMailOutput;
import com.ppcrong.cloudlib.model.SleepAddInput;
import com.ppcrong.cloudlib.model.SleepAddOutput;
import com.ppcrong.cloudlib.model.StepAddInput;
import com.ppcrong.cloudlib.model.StepAddOutput;
import com.ppcrong.cloudlib.model.SwimAddInput;
import com.ppcrong.cloudlib.model.SwimAddOutput;
import com.ppcrong.cloudlib.model.SwimLapAddInput;
import com.ppcrong.cloudlib.model.SwimLapAddOutput;
import com.ppcrong.cloudlib.model.UserDeviceAddInput;
import com.ppcrong.cloudlib.model.UserDeviceAddOutput;
import com.ppcrong.cloudlib.model.UserDeviceDeleteInput;
import com.ppcrong.cloudlib.model.UserDeviceDeleteOutput;
import com.ppcrong.cloudlib.model.UserDeviceListInput;
import com.ppcrong.cloudlib.model.UserDeviceListOutput;
import com.ppcrong.cloudlib.model.UserGoalAddInput;
import com.ppcrong.cloudlib.model.UserGoalAddOutput;
import com.ppcrong.cloudlib.model.UserGoalDeleteInput;
import com.ppcrong.cloudlib.model.UserGoalDeleteOutput;
import com.ppcrong.cloudlib.model.UserGoalEditInput;
import com.ppcrong.cloudlib.model.UserGoalEditOutput;
import com.ppcrong.cloudlib.model.UserGoalListInput;
import com.ppcrong.cloudlib.model.UserGoalListOutput;
import com.ppcrong.cloudlib.model.UserVideoAddInput;
import com.ppcrong.cloudlib.model.UserVideoAddOutput;
import com.ppcrong.cloudlib.utils.Constant;
import com.socks.library.KLog;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

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
    private <IN, OUT> CopyOnWriteArrayList<OUT> postJson(String url, IN input, final TypeReference outTypeRef) throws IOException {

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
        Response response = call.execute();
        String jsonResponse = response.body().string();
        KLog.i("Response json:");
        KLog.json(jsonResponse);
        return parseJsonOutputs(jsonResponse, outTypeRef);
    }

    private <IN, OUT> CopyOnWriteArrayList<OUT> postJson(String url, CopyOnWriteArrayList<IN> inputs, final TypeReference outTypeRef) throws IOException {

        ObjectMapper om = new ObjectMapper();
        String json = "";
        try {
            json = om.writeValueAsString(inputs);
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
        Response response = call.execute();
        String jsonResponse = response.body().string();
        KLog.i("Response json:");
        KLog.json(jsonResponse);
        return parseJsonOutputs(jsonResponse, outTypeRef);
    }

    private <IN, OUT> void postJsonAsync(String url, IN input, final CloudCallback<OUT> cb, final TypeReference outTypeRef) {

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
                CopyOnWriteArrayList<OUT> outputs = parseJsonOutputs(json, outTypeRef);
                cb.onResponse(outputs);
            }

            @Override
            public void onFailure(Call call, IOException e) {
                KLog.d(Log.getStackTraceString(e));
                cb.onFailure(e);
            }
        });
    }

    private <IN, OUT> void postJsonAsync(String url, CopyOnWriteArrayList<IN> inputs, final CloudCallback<OUT> cb, final TypeReference outTypeRef) {

        ObjectMapper om = new ObjectMapper();
        String json = "";
        try {
            json = om.writeValueAsString(inputs);
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
                CopyOnWriteArrayList<OUT> outputs = parseJsonOutputs(json, outTypeRef);
                cb.onResponse(outputs);
            }

            @Override
            public void onFailure(Call call, IOException e) {
                KLog.d(Log.getStackTraceString(e));
                cb.onFailure(e);
            }
        });
    }

    private <T> CopyOnWriteArrayList<T> parseJsonOutputs(String json, TypeReference outTypeRef) {

        CopyOnWriteArrayList<T> outputs = null;
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

            CopyOnWriteArrayList<T> list = om.readValue(json, outTypeRef);
            output = list.get(0);
        } catch (IOException e) {
            KLog.i(Log.getStackTraceString(e));
        }

        return output;
    }
    // endregion [Common]

    // region [Account]
    public CopyOnWriteArrayList<AddUserOutput> addUser(AddUserInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_ADD_USER, input,
                new TypeReference<CopyOnWriteArrayList<AddUserOutput>>() {
                });
    }

    public void addUserAsync(AddUserInput input, final CloudCallback<AddUserOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_ADD_USER, input, cb,
                new TypeReference<CopyOnWriteArrayList<AddUserOutput>>() {
                });
    }

    public CopyOnWriteArrayList<AddUserWithMailOutput> addUserWithMail(AddUserWithMailInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_ADD_USER_WITH_MAIL, input,
                new TypeReference<CopyOnWriteArrayList<AddUserWithMailOutput>>() {
                });
    }

    public void addUserWithMailAsync(AddUserWithMailInput input, final CloudCallback<AddUserWithMailOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_ADD_USER_WITH_MAIL, input, cb,
                new TypeReference<CopyOnWriteArrayList<AddUserWithMailOutput>>() {
                });
    }

    public CopyOnWriteArrayList<ReSendUserMailOutput> resendUserMail(ReSendUserMailInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_RESEND_USER_MAIL, input,
                new TypeReference<CopyOnWriteArrayList<ReSendUserMailOutput>>() {
                });
    }

    public void resendUserMailAsync(ReSendUserMailInput input, final CloudCallback<ReSendUserMailOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_RESEND_USER_MAIL, input, cb,
                new TypeReference<CopyOnWriteArrayList<ReSendUserMailOutput>>() {
                });
    }

    public CopyOnWriteArrayList<AddUserFBOutput> addUserFB(AddUserFBInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_ADD_USER_FB, input,
                new TypeReference<CopyOnWriteArrayList<AddUserFBOutput>>() {
                });
    }

    public void addUserFBAsync(AddUserFBInput input, final CloudCallback<AddUserFBOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_ADD_USER_FB, input, cb,
                new TypeReference<CopyOnWriteArrayList<AddUserFBOutput>>() {
                });
    }

    public CopyOnWriteArrayList<AuthUserOutput> authUser(AuthUserInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_AUTH_USER, input,
                new TypeReference<CopyOnWriteArrayList<AuthUserOutput>>() {
                });
    }

    public void authUserAsync(AuthUserInput input, final CloudCallback<AuthUserOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_AUTH_USER, input, cb,
                new TypeReference<CopyOnWriteArrayList<AuthUserOutput>>() {
                });
    }

    public CopyOnWriteArrayList<AuthUserFBOutput> authUserFB(AuthUserFBInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_AUTH_USER_FB, input,
                new TypeReference<CopyOnWriteArrayList<AuthUserFBOutput>>() {
                });
    }

    public void authUserFBAsync(AuthUserFBInput input, final CloudCallback<AuthUserFBOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_AUTH_USER_FB, input, cb,
                new TypeReference<CopyOnWriteArrayList<AuthUserFBOutput>>() {
                });
    }

    public CopyOnWriteArrayList<EditAccountOutput> editAccount(EditAccountInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_EDIT_ACCOUNT, input,
                new TypeReference<CopyOnWriteArrayList<EditAccountOutput>>() {
                });
    }

    public void editAccountAsync(EditAccountInput input, final CloudCallback<EditAccountOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_EDIT_ACCOUNT, input, cb,
                new TypeReference<CopyOnWriteArrayList<EditAccountOutput>>() {
                });
    }

    public CopyOnWriteArrayList<EditAccountFBOutput> editAccountFB(EditAccountFBInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_EDIT_ACCOUNT_FB, input,
                new TypeReference<CopyOnWriteArrayList<EditAccountFBOutput>>() {
                });
    }

    public void editAccountFBAsync(EditAccountFBInput input, final CloudCallback<EditAccountFBOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_EDIT_ACCOUNT_FB, input, cb,
                new TypeReference<CopyOnWriteArrayList<EditAccountFBOutput>>() {
                });
    }
    // endregion [Account]

    // region [UserSetting]
    public CopyOnWriteArrayList<GetUserSettingOutput> getUserSetting(GetUserSettingInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_GET_USER_SETTING, input,
                new TypeReference<CopyOnWriteArrayList<GetUserSettingOutput>>() {
                });
    }

    public void getUserSettingAsync(GetUserSettingInput input, final CloudCallback<GetUserSettingOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_GET_USER_SETTING, input, cb,
                new TypeReference<CopyOnWriteArrayList<GetUserSettingOutput>>() {
                });
    }

    public CopyOnWriteArrayList<EditUserSettingOutput> editUserSetting(EditUserSettingInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_EDIT_USER_SETTING, input,
                new TypeReference<CopyOnWriteArrayList<EditUserSettingOutput>>() {
                });
    }

    public void editUserSettingAsync(EditUserSettingInput input, final CloudCallback<EditUserSettingOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_EDIT_USER_SETTING, input, cb,
                new TypeReference<CopyOnWriteArrayList<EditUserSettingOutput>>() {
                });
    }
    // endregion [UserSetting]

    // region [UserDevice]
    public CopyOnWriteArrayList<UserDeviceAddOutput> userDeviceAdd(UserDeviceAddInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_USER_DEVICE_ADD, input,
                new TypeReference<CopyOnWriteArrayList<UserDeviceAddOutput>>() {
                });
    }

    public void userDeviceAddAsync(UserDeviceAddInput input, final CloudCallback<UserDeviceAddOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_USER_DEVICE_ADD, input, cb,
                new TypeReference<CopyOnWriteArrayList<UserDeviceAddOutput>>() {
                });
    }

    public CopyOnWriteArrayList<UserDeviceListOutput> userDeviceList(UserDeviceListInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_USER_DEVICE_LIST, input,
                new TypeReference<CopyOnWriteArrayList<UserDeviceListOutput>>() {
                });
    }

    public void userDeviceListAsync(UserDeviceListInput input, final CloudCallback<UserDeviceListOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_USER_DEVICE_LIST, input, cb,
                new TypeReference<CopyOnWriteArrayList<UserDeviceListOutput>>() {
                });
    }

    public CopyOnWriteArrayList<UserDeviceDeleteOutput> userDeviceDelete(UserDeviceDeleteInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_USER_DEVICE_DELETE, input,
                new TypeReference<CopyOnWriteArrayList<UserDeviceDeleteOutput>>() {
                });
    }

    public void userDeviceDeleteAsync(UserDeviceDeleteInput input, final CloudCallback<UserDeviceDeleteOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_USER_DEVICE_DELETE, input, cb,
                new TypeReference<CopyOnWriteArrayList<UserDeviceDeleteOutput>>() {
                });
    }
    // endregion [UserDevice]

    // region [UserGoal]
    public CopyOnWriteArrayList<UserGoalAddOutput> userGoalAdd(UserGoalAddInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_USER_GOAL_ADD, input,
                new TypeReference<CopyOnWriteArrayList<UserGoalAddOutput>>() {
                });
    }

    public void userGoalAddAsync(UserGoalAddInput input, final CloudCallback<UserGoalAddOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_USER_GOAL_ADD, input, cb,
                new TypeReference<CopyOnWriteArrayList<UserGoalAddOutput>>() {
                });
    }

    public CopyOnWriteArrayList<UserGoalListOutput> userGoalList(UserGoalListInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_USER_GOAL_LIST, input,
                new TypeReference<CopyOnWriteArrayList<UserGoalListOutput>>() {
                });
    }

    public void userGoalListAsync(UserGoalListInput input, final CloudCallback<UserGoalListOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_USER_GOAL_LIST, input, cb,
                new TypeReference<CopyOnWriteArrayList<UserGoalListOutput>>() {
                });
    }

    public CopyOnWriteArrayList<UserGoalEditOutput> userGoalEdit(UserGoalEditInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_USER_GOAL_EDIT, input,
                new TypeReference<CopyOnWriteArrayList<UserGoalEditOutput>>() {
                });
    }

    public void userGoalEditAsync(UserGoalEditInput input, final CloudCallback<UserGoalEditOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_USER_GOAL_EDIT, input, cb,
                new TypeReference<CopyOnWriteArrayList<UserGoalEditOutput>>() {
                });
    }

    public CopyOnWriteArrayList<UserGoalDeleteOutput> userGoalDelete(UserGoalDeleteInput input) throws IOException {

        KLog.i();

        return postJson(Constant.URL_USER_GOAL_DELETE, input,
                new TypeReference<CopyOnWriteArrayList<UserGoalDeleteOutput>>() {
                });
    }

    public void userGoalDeleteAsync(UserGoalDeleteInput input, final CloudCallback<UserGoalDeleteOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_USER_GOAL_DELETE, input, cb,
                new TypeReference<CopyOnWriteArrayList<UserGoalDeleteOutput>>() {
                });
    }
    // endregion [UserGoal]

    // region [UploadHistory]
    // region [HR]
    public CopyOnWriteArrayList<HeartRateAddOutput> heartRateAdd(CopyOnWriteArrayList<HeartRateAddInput> inputs) throws IOException {

        KLog.i();

        return postJson(Constant.URL_HR_ADD, inputs,
                new TypeReference<CopyOnWriteArrayList<HeartRateAddOutput>>() {
                });
    }

    public void heartRateAddAsync(CopyOnWriteArrayList<HeartRateAddInput> inputs, final CloudCallback<HeartRateAddOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_HR_ADD, inputs, cb,
                new TypeReference<CopyOnWriteArrayList<HeartRateAddOutput>>() {
                });
    }
    // endregion [HR]

    // region [Sleep]
    public CopyOnWriteArrayList<SleepAddOutput> sleepAdd(CopyOnWriteArrayList<SleepAddInput> inputs) throws IOException {

        KLog.i();

        return postJson(Constant.URL_SLEEP_ADD, inputs,
                new TypeReference<CopyOnWriteArrayList<SleepAddOutput>>() {
                });
    }

    public void sleepAddAsync(CopyOnWriteArrayList<SleepAddInput> inputs, final CloudCallback<SleepAddOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_SLEEP_ADD, inputs, cb,
                new TypeReference<CopyOnWriteArrayList<SleepAddOutput>>() {
                });
    }
    // endregion [Sleep]

    // region [Step]
    public CopyOnWriteArrayList<StepAddOutput> stepAdd(CopyOnWriteArrayList<StepAddInput> inputs) throws IOException {

        KLog.i();

        return postJson(Constant.URL_STEP_ADD, inputs,
                new TypeReference<CopyOnWriteArrayList<StepAddOutput>>() {
                });
    }

    public void stepAddAsync(CopyOnWriteArrayList<StepAddInput> inputs, final CloudCallback<StepAddOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_STEP_ADD, inputs, cb,
                new TypeReference<CopyOnWriteArrayList<StepAddOutput>>() {
                });
    }
    // endregion [Step]

    // region [Bike]
    public CopyOnWriteArrayList<BikeAddOutput> bikeAdd(CopyOnWriteArrayList<BikeAddInput> inputs) throws IOException {

        KLog.i();

        return postJson(Constant.URL_BIKE_ADD, inputs,
                new TypeReference<CopyOnWriteArrayList<BikeAddOutput>>() {
                });
    }

    public void bikeAddAsync(CopyOnWriteArrayList<BikeAddInput> inputs, final CloudCallback<BikeAddOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_BIKE_ADD, inputs, cb,
                new TypeReference<CopyOnWriteArrayList<BikeAddOutput>>() {
                });
    }
    // endregion [Bike]

    // region [Swim]
    public CopyOnWriteArrayList<SwimAddOutput> swimAdd(CopyOnWriteArrayList<SwimAddInput> inputs) throws IOException {

        KLog.i();

        return postJson(Constant.URL_SWIM_ADD, inputs,
                new TypeReference<CopyOnWriteArrayList<SwimAddOutput>>() {
                });
    }

    public void swimAddAsync(CopyOnWriteArrayList<SwimAddInput> inputs, final CloudCallback<SwimAddOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_SWIM_ADD, inputs, cb,
                new TypeReference<CopyOnWriteArrayList<SwimAddOutput>>() {
                });
    }

    public CopyOnWriteArrayList<SwimLapAddOutput> swimLapAdd(CopyOnWriteArrayList<SwimLapAddInput> inputs) throws IOException {

        KLog.i();

        return postJson(Constant.URL_SWIM_LAP_ADD, inputs,
                new TypeReference<CopyOnWriteArrayList<SwimLapAddOutput>>() {
                });
    }

    public void swimLapAddAsync(CopyOnWriteArrayList<SwimLapAddInput> inputs, final CloudCallback<SwimLapAddOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_SWIM_LAP_ADD, inputs, cb,
                new TypeReference<CopyOnWriteArrayList<SwimLapAddOutput>>() {
                });
    }
    // endregion [Swim]

    // region [Video]
    public CopyOnWriteArrayList<UserVideoAddOutput> userVideoAdd(CopyOnWriteArrayList<UserVideoAddInput> inputs) throws IOException {

        KLog.i();

        return postJson(Constant.URL_USER_VIDEO_ADD, inputs,
                new TypeReference<CopyOnWriteArrayList<UserVideoAddOutput>>() {
                });
    }

    public void userVideoAddAsync(CopyOnWriteArrayList<UserVideoAddInput> inputs, final CloudCallback<UserVideoAddOutput> cb) {

        KLog.i();

        postJsonAsync(Constant.URL_USER_VIDEO_ADD, inputs, cb,
                new TypeReference<CopyOnWriteArrayList<UserVideoAddOutput>>() {
                });
    }
    // endregion [Video]
    // endregion [UploadHistory]
}
