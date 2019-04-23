package ir.client.retrofittask;

import ir.client.retrofittask.response.MovieClass;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitRequestInterface {
    @GET("/")
    Call<MovieClass>getMovieInfo();
}
