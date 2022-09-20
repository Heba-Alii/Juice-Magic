package eg.gov.iti.juicemagic.ui.details;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import eg.gov.iti.juicemagic.data.JuiceRetrofit;
import eg.gov.iti.juicemagic.pojo.SubCategoryModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardMenueDetailsViewModel extends ViewModel {
    public MutableLiveData<SubCategoryModel> menueDetailsMutableLiveData = new MutableLiveData<>();

    public void getItemDetails(String subCategoryId) {
        Call<SubCategoryModel> call = JuiceRetrofit.getInstance().getJuice().getDetails("en", "", subCategoryId);
        call.enqueue(new Callback<SubCategoryModel>() {
            @Override
            public void onResponse(Call<SubCategoryModel> call, Response<SubCategoryModel> response) {
                if (response.body().getSuccess() == 1) {
                    Log.e("TAG", "onResponse: " + response.body());
                    menueDetailsMutableLiveData.setValue(response.body());

                } else {
                    Log.e("TAG", "onResponse: failed" + response.body());
                }
            }

            @Override
            public void onFailure(Call<SubCategoryModel> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getMessage());
            }
        });

    }
}