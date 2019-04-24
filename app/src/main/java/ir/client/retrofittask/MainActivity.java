package ir.client.retrofittask;

import androidx.appcompat.app.AppCompatActivity;
import ir.client.retrofittask.response.MovieClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RetrofitRequestInterface requestInterface = RetrofitServiceGenerator.createService(RetrofitRequestInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtMovieName = findViewById(R.id.edtMovieName);
        Button btnGetMovieInfo = findViewById(R.id.btnGetMovieInfo);
        final TextView txtTitle = findViewById(R.id.txtTitle);
        final TextView txtCountry = findViewById(R.id.txtCountry);
        final TextView txtYear = findViewById(R.id.txtYear);
        final TextView txtGenre = findViewById(R.id.txtGenre);
        final TextView txtType = findViewById(R.id.txtType);
        final TextView txtWriter = findViewById(R.id.txtWriter);
        final TextView txtDirector = findViewById(R.id.txtDirector);
        final TextView txtActors = findViewById(R.id.txtActors);
        final TextView txtAwards = findViewById(R.id.txtAwards);
        final TextView txtLanguage = findViewById(R.id.txtLanguage);
        final TextView txtRate = findViewById(R.id.txtRate);
        Button btnBack = findViewById(R.id.btnBack);



        requestInterface.getMovieInfo("interstella", "70ad462a").enqueue(new Callback<MovieClass>() {
            @Override
            public void onResponse(Call<MovieClass> call, Response<MovieClass> response) {

                txtTitle.setText(response.body().getTitle());
                txtCountry.setText(response.body().getCountry());
                txtYear.setText(response.body().getYear());
                txtGenre.setText(response.body().getGenre());
                txtType.setText(response.body().getType());
                txtWriter.setText(response.body().getWriter());
                txtDirector.setText(response.body().getDirector());
                txtActors.setText(response.body().getActors());
                txtAwards.setText(response.body().getAwards());
                txtLanguage.setText(response.body().getLanguage());
                txtRate.setText(response.body().getImdbRating());
            }

            @Override
            public void onFailure(Call<MovieClass> call, Throwable t) {

            }
        });
    }
}
