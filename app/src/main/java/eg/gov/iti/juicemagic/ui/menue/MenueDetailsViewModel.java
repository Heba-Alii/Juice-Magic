package eg.gov.iti.juicemagic.ui.menue;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import eg.gov.iti.juicemagic.data.JuiceRetrofit;
import eg.gov.iti.juicemagic.pojo.SubCategoryModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenueDetailsViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    public MutableLiveData<SubCategoryModel> menueDetailsMutableLiveData = new
            MutableLiveData<>();

    public void getSubCategory(String parentCategoryId) {
        Call<SubCategoryModel> call = JuiceRetrofit.getInstance().getJuice().getSubCategory("en", "", parentCategoryId);
        call.enqueue(new Callback<SubCategoryModel>() {
            @Override
            public void onResponse(Call<SubCategoryModel> call, Response<SubCategoryModel> response) {
                if (response.body().getSuccess() == 1) {
                    menueDetailsMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<SubCategoryModel> call, Throwable t) {

            }
        });
    }
}