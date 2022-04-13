package fr.demo.android.demoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

import fr.demo.android.demoandroid.api.GitHubService;
import fr.demo.android.demoandroid.model.CodeRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = findViewById(R.id.myButton);
        myButton.setOnClickListener(v -> {
            Log.d("MYAPP", "Bouton cliqué");
            callAPI();
        });
    }

    void callAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ergast.com/api/f1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);
        service.listRepos("2021").enqueue(new Callback<CodeRepository>() {
            @Override
            public void onResponse(Call<CodeRepository> call, Response<CodeRepository> response) {
                CodeRepository repositories = response.body();
                if (repositories != null){
                    Log.d("RESPONSE API2", repositories.toString());
                }
            }

            @Override
            public void onFailure(Call<CodeRepository> call, Throwable t) {

                Log.e("err",t.toString());

            }
        });
    }
}