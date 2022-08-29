package eg.gov.iti.juicemagic.data;

import eg.gov.iti.juicemagic.pojo.UsersModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsersInterface {
    @POST("add-client.php")
    public Call<UsersModel> signup(@Body UsersModel usersModel);
}
