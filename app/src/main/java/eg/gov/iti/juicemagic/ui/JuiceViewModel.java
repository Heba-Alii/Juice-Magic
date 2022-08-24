package eg.gov.iti.juicemagic.ui;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import eg.gov.iti.juicemagic.data.JuiceRetrofit;
import eg.gov.iti.juicemagic.pojo.JuiceModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JuiceViewModel extends ViewModel {
    public MutableLiveData<JuiceModel> juiceMutableLiveData = new MutableLiveData<>();

    //function return juices from retrofit
    public void getJuices() {
        Call<JuiceModel> call = JuiceRetrofit.getInstance().getJuice().getJuice("", "en");
        call.enqueue(new Callback<JuiceModel>() {
            @Override
            public void onResponse(Call<JuiceModel> call, Response<JuiceModel> response) {
                if (response.body().getSuccess() == 1) {
                    juiceMutableLiveData.setValue(response.body());
                } else {
                    Log.e("TAG", "onResponse: not success");
                }
            }
            @Override
            public void onFailure(Call<JuiceModel> call, Throwable t) {

                Log.e("TAG", "onResponse: not success" + t.getMessage());

            }
        });
    }
}
