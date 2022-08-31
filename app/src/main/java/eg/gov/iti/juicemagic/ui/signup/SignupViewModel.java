package eg.gov.iti.juicemagic.ui.signup;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import eg.gov.iti.juicemagic.data.JuiceRetrofit;
import eg.gov.iti.juicemagic.pojo.AuthModel;
import eg.gov.iti.juicemagic.pojo.UsersModel;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupViewModel extends ViewModel {
    public MutableLiveData<AuthModel> usersModelMutableLiveData = new MutableLiveData<>();

    //function return data from retrofit
    public void postUsers(UsersModel usersModel) {
        retrofit2.Call<AuthModel> call = JuiceRetrofit.getInstance().getJuice().signup(usersModel);
        call.enqueue(new Callback<AuthModel>() {
            @Override
            public void onResponse(retrofit2.Call<AuthModel> call, Response<AuthModel> response) {
                usersModelMutableLiveData.setValue(response.body());
                //Log.e("TAG", "onResponse: success" + response.body().getMessage());
            }

            @Override
            public void onFailure(retrofit2.Call<AuthModel> call, Throwable t) {
                // Log.e("TAG", "onResponse: not success" + t.getMessage());
            }
        });
    }
}