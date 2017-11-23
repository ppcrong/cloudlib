package com.ppcrong.cloudlib.callback;

import com.ppcrong.cloudlib.model.AddUserFBOutput;
import com.ppcrong.cloudlib.model.AddUserOutput;
import com.ppcrong.cloudlib.model.AuthUserFBOutput;
import com.ppcrong.cloudlib.model.AuthUserOutput;
import com.ppcrong.cloudlib.model.BikeAddOutput;
import com.ppcrong.cloudlib.model.EditAccountFBOutput;
import com.ppcrong.cloudlib.model.EditAccountOutput;
import com.ppcrong.cloudlib.model.EditUserSettingOutput;
import com.ppcrong.cloudlib.model.GetUserSettingOutput;
import com.ppcrong.cloudlib.model.HeartRateAddOutput;
import com.ppcrong.cloudlib.model.SleepAddOutput;
import com.ppcrong.cloudlib.model.StepAddOutput;
import com.ppcrong.cloudlib.model.SwimAddOutput;
import com.ppcrong.cloudlib.model.SwimLapAddOutput;
import com.ppcrong.cloudlib.model.UserDeviceAddOutput;
import com.ppcrong.cloudlib.model.UserDeviceDeleteOutput;
import com.ppcrong.cloudlib.model.UserDeviceListOutput;
import com.ppcrong.cloudlib.model.UserGoalAddOutput;
import com.ppcrong.cloudlib.model.UserGoalDeleteOutput;
import com.ppcrong.cloudlib.model.UserGoalEditOutput;
import com.ppcrong.cloudlib.model.UserGoalListOutput;
import com.ppcrong.cloudlib.model.UserVideoAddOutput;

public class CloudCallback {

    public interface AddUserCb {
        void onResponse(AddUserOutput output);
        void onFailure();
    }

    public interface AddUserFBCb {
        void onResponse(AddUserFBOutput output);
        void onFailure();
    }

    public interface AuthUserCb {
        void onResponse(AuthUserOutput output);
        void onFailure();
    }

    public interface AuthUserFBCb {
        void onResponse(AuthUserFBOutput output);
        void onFailure();
    }

    public interface EditAccountCb {
        void onResponse(EditAccountOutput output);
        void onFailure();
    }

    public interface EditAccountFBCb {
        void onResponse(EditAccountFBOutput output);
        void onFailure();
    }

    public interface GetUserSettingCb {
        void onResponse(GetUserSettingOutput output);
        void onFailure();
    }

    public interface EditUserSettingCb {
        void onResponse(EditUserSettingOutput output);
        void onFailure();
    }

    public interface UserDeviceAddCb {
        void onResponse(UserDeviceAddOutput output);
        void onFailure();
    }

    public interface UserDeviceListCb {
        void onResponse(UserDeviceListOutput output);
        void onFailure();
    }

    public interface UserDeviceDeleteCb {
        void onResponse(UserDeviceDeleteOutput output);
        void onFailure();
    }

    public interface UserGoalAddCb {
        void onResponse(UserGoalAddOutput output);
        void onFailure();
    }

    public interface UserGoalListCb {
        void onResponse(UserGoalListOutput output);
        void onFailure();
    }

    public interface UserGoalEditCb {
        void onResponse(UserGoalEditOutput output);
        void onFailure();
    }

    public interface UserGoalDeleteCb {
        void onResponse(UserGoalDeleteOutput output);
        void onFailure();
    }

    public interface HeartRateAddCb {
        void onResponse(HeartRateAddOutput output);
        void onFailure();
    }

    public interface SleepAddCb {
        void onResponse(SleepAddOutput output);
        void onFailure();
    }

    public interface StepAddCb {
        void onResponse(StepAddOutput output);
        void onFailure();
    }

    public interface BikeAddCb {
        void onResponse(BikeAddOutput output);
        void onFailure();
    }

    public interface SwimAddCb {
        void onResponse(SwimAddOutput output);
        void onFailure();
    }

    public interface SwimLapAddCb {
        void onResponse(SwimLapAddOutput output);
        void onFailure();
    }

    public interface UserVideoAddCb {
        void onResponse(UserVideoAddOutput output);
        void onFailure();
    }
}
