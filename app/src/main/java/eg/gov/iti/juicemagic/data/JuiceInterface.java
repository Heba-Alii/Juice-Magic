package eg.gov.iti.juicemagic.data;

import eg.gov.iti.juicemagic.pojo.AuthModel;
import eg.gov.iti.juicemagic.pojo.JuiceModel;
import eg.gov.iti.juicemagic.pojo.UsersModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JuiceInterface {
    @GET("home-page.php")
    public Call<JuiceModel> getJuice(@Query("client_id") String clientId, @Query("lang") String lang);

    @POST("add-client.php")
    public Call<AuthModel> signup(@Body UsersModel usersModel);

}
