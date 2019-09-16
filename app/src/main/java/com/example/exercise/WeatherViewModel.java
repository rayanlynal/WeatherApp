package com.example.exercise;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class WeatherViewModel extends AndroidViewModel {
    /*public MutableLiveData<String> currentPassword = new MutableLiveData<>();
    public MutableLiveData<String> newPassword = new MutableLiveData<>();
    public MutableLiveData<String> confirmNewPassword = new MutableLiveData<>();
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();*/
    /*public MutableLiveData<ChangePassword> forgotPasswordMutableLiveData = new MutableLiveData<>();*/
    private Application application;

    public WeatherViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    /*public LiveData<ChangePassword> getUserNewPassword() {
        return forgotPasswordMutableLiveData;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }*/

    /*public void onChangePasswordClick() {
        ChangePassword changePassword = new ChangePassword(currentPassword.getValue(), newPassword.getValue(),
                confirmNewPassword.getValue());

        if (!changePassword.isOldPasswordEntered()) {
            errorMessage.setValue(application.getString(R.string.error_enter_old_password));
        } else if (!changePassword.isNewPasswordEntered()) {
            errorMessage.setValue(application.getString(R.string.error_enter_new_password));
        } else if (!changePassword.isPasswordIsStrong()) {
            errorMessage.setValue(application.getString(R.string.strong_password_info));
        } else if (!changePassword.isConfirmNewPasswordEntered()) {
            errorMessage.setValue(application.getString(R.string.error_enter_confirm_password));
        } else if (!changePassword.isPasswordMatched()) {
            errorMessage.setValue(application.getString(R.string.error_password_not_match));
        } else {
            forgotPasswordMutableLiveData.setValue(changePassword);
        }
    }*/
}
