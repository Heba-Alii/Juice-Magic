package eg.gov.iti.juicemagic.ui.CartDetails;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import eg.gov.iti.juicemagic.data.JuiceRetrofit;
import eg.gov.iti.juicemagic.pojo.GetCart_Model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartDetailsViewModel extends ViewModel {
    public MutableLiveData<GetCart_Model> cartDetailsMutableLiveDat = new MutableLiveData<>();

    public void getCart(String clientId) {
        Call<GetCart_Model> call = JuiceRetrofit.getInstance().getJuice().getCart("en", clientId, "");
        call.enqueue(new Callback<GetCart_Model>() {
            @Override
            public void onResponse(Call<GetCart_Model> call, Response<GetCart_Model> response) {
                if (response.body().getSuccess() == 1) {
                    Log.e("TAG", "onResponse: addtocart success" + response.body());
                    cartDetailsMutableLiveDat.setValue(response.body());
                } else {
                    Log.e("TAG", "onResponse: addtocart not success" + response.body());
                }
            }

            @Override
            public void onFailure(Call<GetCart_Model> call, Throwable t) {
                Log.e("TAG", "onFailure: addtocart failed" + t.getMessage());

            }
        });
    }
}