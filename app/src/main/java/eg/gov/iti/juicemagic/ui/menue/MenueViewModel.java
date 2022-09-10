package eg.gov.iti.juicemagic.ui.menue;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import eg.gov.iti.juicemagic.data.JuiceRetrofit;
import eg.gov.iti.juicemagic.pojo.ParentCategoryModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenueViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public MutableLiveData<ParentCategoryModel> menueMutableliveData = new MutableLiveData<>();

    public void getMenue() {
        Call<ParentCategoryModel> call = JuiceRetrofit.getInstance().getJuice().getCategory("en");
        call.enqueue(new Callback<ParentCategoryModel>() {
            @Override
            public void onResponse(Call<ParentCategoryModel> call, Response<ParentCategoryModel> response) {
                if (response.body().getSuccess()==1){
                    menueMutableliveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ParentCategoryModel> call, Throwable t) {

            }
        });


    }
}