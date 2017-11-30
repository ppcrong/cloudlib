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
import java.util.ArrayList;

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

    private <IN, OUT> void postJson(String url, ArrayList<IN> inputs, final CloudCallback<OUT> cb, final TypeReference outTypeRef) {

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

        KLog.i();

        postJson(Constant.URL_ADD_USER, input, cb,
                new TypeReference<ArrayList<AddUserOutput>>() {
                });
    }

    public void addUserWithMail(AddUserWithMailInput input, final CloudCallback<AddUserWithMailOutput> cb) {

        KLog.i();

        postJson(Constant.URL_ADD_USER_WITH_MAIL, input, cb,
                new TypeReference<ArrayList<AddUserWithMailOutput>>() {
                });
    }

    public void resendUserMail(ReSendUserMailInput input, final CloudCallback<ReSendUserMailOutput> cb) {

        KLog.i();

        postJson(Constant.URL_RESEND_USER_MAIL, input, cb,
                new TypeReference<ArrayList<ReSendUserMailOutput>>() {
                });
    }

    public void addUserFB(AddUserFBInput input, final CloudCallback<AddUserFBOutput> cb) {

        KLog.i();

        postJson(Constant.URL_ADD_USER_FB, input, cb,
                new TypeReference<ArrayList<AddUserFBOutput>>() {
                });
    }

    public void authUser(AuthUserInput input, final CloudCallback<AuthUserOutput> cb) {

        KLog.i();

        postJson(Constant.URL_AUTH_USER, input, cb,
                new TypeReference<ArrayList<AuthUserOutput>>() {
                });
    }

    public void authUserFB(AuthUserFBInput input, final CloudCallback<AuthUserFBOutput> cb) {

        KLog.i();

        postJson(Constant.URL_AUTH_USER_FB, input, cb,
                new TypeReference<ArrayList<AuthUserFBOutput>>() {
                });
    }

    public void editAccount(EditAccountInput input, final CloudCallback<EditAccountOutput> cb) {

        KLog.i();

        postJson(Constant.URL_EDIT_ACCOUNT, input, cb,
                new TypeReference<ArrayList<EditAccountOutput>>() {
                });
    }

    public void editAccountFB(EditAccountFBInput input, final CloudCallback<EditAccountFBOutput> cb) {

        KLog.i();

        postJson(Constant.URL_EDIT_ACCOUNT_FB, input, cb,
                new TypeReference<ArrayList<EditAccountFBOutput>>() {
                });
    }
    // endregion [Account]

    // region [UserSetting]
    public void getUserSetting(GetUserSettingInput input, final CloudCallback<GetUserSettingOutput> cb) {

        KLog.i();

        postJson(Constant.URL_GET_USER_SETTING, input, cb,
                new TypeReference<ArrayList<GetUserSettingOutput>>() {
                });
    }

    public void editUserSetting(EditUserSettingInput input, final CloudCallback<EditUserSettingOutput> cb) {

        KLog.i();

        postJson(Constant.URL_EDIT_USER_SETTING, input, cb,
                new TypeReference<ArrayList<EditUserSettingOutput>>() {
                });
    }
    // endregion [UserSetting]

    // region [UserDevice]
    public void userDeviceAdd(UserDeviceAddInput input, final CloudCallback<UserDeviceAddOutput> cb) {

        KLog.i();

        postJson(Constant.URL_USER_DEVICE_ADD, input, cb,
                new TypeReference<ArrayList<UserDeviceAddOutput>>() {
                });
    }

    public void userDeviceList(UserDeviceListInput input, final CloudCallback<UserDeviceListOutput> cb) {

        KLog.i();

        postJson(Constant.URL_USER_DEVICE_LIST, input, cb,
                new TypeReference<ArrayList<UserDeviceListOutput>>() {
                });
    }

    public void userDeviceDelete(UserDeviceDeleteInput input, final CloudCallback<UserDeviceDeleteOutput> cb) {

        KLog.i();

        postJson(Constant.URL_USER_DEVICE_DELETE, input, cb,
                new TypeReference<ArrayList<UserDeviceDeleteOutput>>() {
                });
    }
    // endregion [UserDevice]

    // region [UserGoal]
    public void userGoalAdd(UserGoalAddInput input, final CloudCallback<UserGoalAddOutput> cb) {

        KLog.i();

        postJson(Constant.URL_USER_GOAL_ADD, input, cb,
                new TypeReference<ArrayList<UserGoalAddOutput>>() {
                });
    }

    public void userGoalList(UserGoalListInput input, final CloudCallback<UserGoalListOutput> cb) {

        KLog.i();

        postJson(Constant.URL_USER_GOAL_LIST, input, cb,
                new TypeReference<ArrayList<UserGoalListOutput>>() {
                });
    }

    public void userGoalEdit(UserGoalEditInput input, final CloudCallback<UserGoalEditOutput> cb) {

        KLog.i();

        postJson(Constant.URL_USER_GOAL_EDIT, input, cb,
                new TypeReference<ArrayList<UserGoalEditOutput>>() {
                });
    }

    public void userGoalDelete(UserGoalDeleteInput input, final CloudCallback<UserGoalDeleteOutput> cb) {

        KLog.i();

        postJson(Constant.URL_USER_GOAL_DELETE, input, cb,
                new TypeReference<ArrayList<UserGoalDeleteOutput>>() {
                });
    }
    // endregion [UserGoal]

    // region [UploadHistory]
    // region [HR]
    public void heartRateAdd(ArrayList<HeartRateAddInput> inputs, final CloudCallback<HeartRateAddOutput> cb) {

        KLog.i();

        postJson(Constant.URL_HR_ADD, inputs, cb,
                new TypeReference<ArrayList<HeartRateAddOutput>>() {
                });
    }
    // endregion [HR]

    // region [Sleep]
    public void sleepAdd(ArrayList<SleepAddInput> inputs, final CloudCallback<SleepAddOutput> cb) {

        KLog.i();

        postJson(Constant.URL_SLEEP_ADD, inputs, cb,
                new TypeReference<ArrayList<SleepAddOutput>>() {
                });
    }
    // endregion [Sleep]

    // region [Step]
    public void stepAdd(ArrayList<StepAddInput> inputs, final CloudCallback<StepAddOutput> cb) {

        KLog.i();

        postJson(Constant.URL_STEP_ADD, inputs, cb,
                new TypeReference<ArrayList<StepAddOutput>>() {
                });
    }
    // endregion [Step]

    // region [Bike]
    public void bikeAdd(ArrayList<BikeAddInput> inputs, final CloudCallback<BikeAddOutput> cb) {

        KLog.i();

        postJson(Constant.URL_BIKE_ADD, inputs, cb,
                new TypeReference<ArrayList<BikeAddOutput>>() {
                });
    }
    // endregion [Bike]

    // region [Swim]
    public void swimAdd(ArrayList<SwimAddInput> inputs, final CloudCallback<SwimAddOutput> cb) {

        KLog.i();

        postJson(Constant.URL_SWIM_ADD, inputs, cb,
                new TypeReference<ArrayList<SwimAddOutput>>() {
                });
    }

    public void swimLapAdd(ArrayList<SwimLapAddInput> inputs, final CloudCallback<SwimLapAddOutput> cb) {

        KLog.i();

        postJson(Constant.URL_SWIM_LAP_ADD, inputs, cb,
                new TypeReference<ArrayList<SwimLapAddOutput>>() {
                });
    }
    // endregion [Swim]

    // region [Video]
    public void userVideoAdd(ArrayList<UserVideoAddInput> inputs, final CloudCallback<UserVideoAddOutput> cb) {

        KLog.i();

        postJson(Constant.URL_USER_VIDEO_ADD, inputs, cb,
                new TypeReference<ArrayList<UserVideoAddOutput>>() {
                });
    }
    // endregion [Video]
    // endregion [UploadHistory]
}
