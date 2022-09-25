package eg.gov.iti.juicemagic.data;

import eg.gov.iti.juicemagic.pojo.Additions_Model;
import eg.gov.iti.juicemagic.pojo.AuthModel;
import eg.gov.iti.juicemagic.pojo.JuiceModel;
import eg.gov.iti.juicemagic.pojo.ParentCategoryModel;
import eg.gov.iti.juicemagic.pojo.Remove_Response;
import eg.gov.iti.juicemagic.pojo.SubCategoryModel;
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

    @POST("login.php?")
    public Call<AuthModel> login(@Body UsersModel usersModel);

    @GET("get-parent-categories.php?")
    public Call<ParentCategoryModel> getCategory(@Query("lang") String lang);

    @GET("get-sub-categories.php?")
    public Call<SubCategoryModel> getSubCategory(@Query("lang") String lang, @Query("client_id") String clientId,
                                                 @Query("parent_category_id") String parentcategoryId);

    @GET("get-sub-category-by-id.php")
    public Call<SubCategoryModel> getDetails(@Query("lang") String lang, @Query("client_id") String clientId,
                                             @Query("sub_category_id") String subCategoryId);

    @GET("get-addition-prices.php?")
    public Call<Additions_Model> get_Additions(@Query("lang") String lang, @Query("country_id") String country_id,
                                               @Query("sub_category_id") String parent_category_id);

    @GET("get-removes.php")
    public Call<Remove_Response> get_removes(@Query("lang") String lang,
                                             @Query("sub_category_id") String parent_category_id);
}
