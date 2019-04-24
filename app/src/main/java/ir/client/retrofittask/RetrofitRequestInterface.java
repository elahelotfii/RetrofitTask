package ir.client.retrofittask;

import ir.client.retrofittask.response.MovieClass;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitRequestInterface {
    @GET("/")
    Call<MovieClass>getMovieInfo(@Query("t") String movieName, @Query("apikey") String key);
}
