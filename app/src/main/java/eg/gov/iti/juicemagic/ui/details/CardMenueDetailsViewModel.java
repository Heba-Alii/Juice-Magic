package eg.gov.iti.juicemagic.ui.details;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import eg.gov.iti.juicemagic.data.JuiceRetrofit;
import eg.gov.iti.juicemagic.pojo.AddCart_Model;
import eg.gov.iti.juicemagic.pojo.Additions_Model;
import eg.gov.iti.juicemagic.pojo.GetCart_Model;
import eg.gov.iti.juicemagic.pojo.Remove_Response;
import eg.gov.iti.juicemagic.pojo.ResponseCart_Model;
import eg.gov.iti.juicemagic.pojo.SubCategoryModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardMenueDetailsViewModel extends ViewModel {
    public MutableLiveData<SubCategoryModel> menueDetailsMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Additions_Model> additionMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Remove_Response> removeResponseMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<ResponseCart_Model> responseCart_modelMutableLiveData = new MutableLiveData<>();

    public void getItemDetails(String subCategoryId) {
        Call<SubCategoryModel> call = JuiceRetrofit.getInstance().getJuice().getDetails("en", "", subCategoryId);
        call.enqueue(new Callback<SubCategoryModel>() {
            @Override
            public void onResponse(Call<SubCategoryModel> call, Response<SubCategoryModel> response) {
                if (response.body().getSuccess() == 1) {
                    Log.e("TAG", "onResponse: on Respone Addition" + response.body());
                    menueDetailsMutableLiveData.setValue(response.body());

                } else {
                    Log.e("TAG", "onResponse: Addition" + response.body());
                }
            }

            @Override
            public void onFailure(Call<SubCategoryModel> call, Throwable t) {
                Log.e("TAG", "onFailure: Failure Addition" + t.getMessage());
            }
        });

    }

    public void getAddition(String subCategory_id) {
        Call<Additions_Model> call = JuiceRetrofit.getInstance().getJuice().get_Additions("en", "1", subCategory_id);
        call.enqueue(new Callback<Additions_Model>() {
            @Override
            public void onResponse(Call<Additions_Model> call, Response<Additions_Model> response) {
                if (response.body().getSuccess() == 1) {
                    additionMutableLiveData.setValue(response.body());
                } else {
                    Log.e("TAG", "onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<Additions_Model> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
    }

    public void getRemoves(String subCategory_id) {
        Call<Remove_Response> call = JuiceRetrofit.getInstance().getJuice().get_removes("en", subCategory_id);
        call.enqueue(new Callback<Remove_Response>() {
            @Override
            public void onResponse(Call<Remove_Response> call, Response<Remove_Response> response) {
                if (response.body().getSuccess() == 1) {
                    removeResponseMutableLiveData.setValue(response.body());
                } else {
                    Log.e("TAG", "onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<Remove_Response> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });
    }

    public void addToCart(AddCart_Model addCartModel) {
        Call<ResponseCart_Model> call = JuiceRetrofit.getInstance().getJuice().addCart(addCartModel);
        call.enqueue(new Callback<ResponseCart_Model>() {
            @Override
            public void onResponse(Call<ResponseCart_Model> call, Response<ResponseCart_Model> response) {
                Log.e("TAG", "onResponse: add to cart on response" + response.body());
                responseCart_modelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ResponseCart_Model> call, Throwable t) {
                Log.e("TAG", "onFailure: add to cart on Failure" + t.getMessage());
            }
        });

    }
}