package com.example.exemploapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APICep {
    @GET("/ws/{cep}/json/")
    Call<Local>getLocal(@Path("cep")String cep);
}
