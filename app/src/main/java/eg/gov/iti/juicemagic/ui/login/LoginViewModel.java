package eg.gov.iti.juicemagic.ui.login;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import eg.gov.iti.juicemagic.data.JuiceRetrofit;
import eg.gov.iti.juicemagic.pojo.AuthModel;
import eg.gov.iti.juicemagic.pojo.UsersModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {
    public MutableLiveData<AuthModel> loginMutableLiveData = new MutableLiveData<>();

    public void getUsers(UsersModel usersModel) {
        Call<AuthModel> call = JuiceRetrofit.getInstance().getJuice().login(usersModel);
        call.enqueue(new Callback<AuthModel>() {
            @Override
            public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {

                    loginMutableLiveData.setValue(response.body());
                    Log.e("TAG", "onResponse: response" + response.body().getMessage());

            }

            @Override
            public void onFailure(Call<AuthModel> call, Throwable t) {
                Log.e("TAG", "onResponse: failure" + t.getMessage());
            }
        });
    }

}
