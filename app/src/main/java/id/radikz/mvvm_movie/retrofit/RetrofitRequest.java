package id.radikz.mvvm_movie.retrofit;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import id.radikz.mvvm_movie.util.TLSSocketFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://api.themoviedb.org/3/discover/";


    public static Retrofit getRetrofitInstance() {
        OkHttpClient client=new OkHttpClient();
        try {
            client = new OkHttpClient.Builder()
                    .sslSocketFactory(new TLSSocketFactory())
                    .build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
