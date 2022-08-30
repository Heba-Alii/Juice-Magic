package eg.gov.iti.juicemagic.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JuiceRetrofit {

    private static final String BASE_URL = "http://magicjuice.emcan-group.com/system/api/";
    private JuiceInterface juiceInterface;
    public static JuiceRetrofit instance;


    public JuiceRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        juiceInterface = retrofit.create(JuiceInterface.class);
    }

    public static JuiceRetrofit getInstance() {
        if (instance == null) {
            instance = new JuiceRetrofit();
        }
        return instance;
    }

    public JuiceInterface getJuice() {
        return juiceInterface;
    }




}
