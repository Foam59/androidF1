package fr.demo.android.demoandroid.api;

import java.util.List;

import fr.demo.android.demoandroid.model.CodeRepository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("{user}/drivers.json")
    Call<CodeRepository> listRepos(@Path("user") String user);
}
