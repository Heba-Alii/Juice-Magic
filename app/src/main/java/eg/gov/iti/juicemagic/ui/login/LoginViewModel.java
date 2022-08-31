//package eg.gov.iti.juicemagic.ui.login;
//
//import android.util.Log;
//
//import androidx.lifecycle.MutableLiveData;
//import androidx.lifecycle.ViewModel;
//
//import eg.gov.iti.juicemagic.data.JuiceRetrofit;
//import eg.gov.iti.juicemagic.pojo.AuthModel;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class LoginViewModel extends ViewModel {
//
//    public MutableLiveData<AuthModel> loginMutableLiveData = new MutableLiveData<>();
//
//    public void getUsers() {
//        Call<AuthModel> call = JuiceRetrofit.getInstance().getJuice().login();
//        call.enqueue(new Callback<AuthModel>() {
//            @Override
//            public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {
//                if (response.body().getSuccess() == 1) {
//                    loginMutableLiveData.setValue(response.body());
//                    Log.e("TAG", "onResponse: onsuccess" + response.message());
//                } else {
//                    Log.e("TAG", "onResponse:not success " + response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<AuthModel> call, Throwable t) {
//                Log.e("TAG", "onFailure: notuser" + t.getMessage());
//
//            }
//        });
//    }
//
//}