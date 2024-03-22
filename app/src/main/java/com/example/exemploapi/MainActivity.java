package com.example.exemploapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText edtEntrada;
    private Button btnEnviar;
    private TextView txtSaida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEntrada = findViewById(R.id.edtEntrada);
        btnEnviar = findViewById(R.id.btnEnviar);
        txtSaida = findViewById(R.id.txtSaida);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // codigo quando o botao enviar for acionado
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://viacep.com.br/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                APICep requestLocal = retrofit.create(APICep.class);
                requestLocal.getLocal(edtEntrada.getText().toString()).enqueue(new Callback<Local>() {
                    @Override
                    public void onResponse(Call<Local> call, Response<Local> response) {
                        txtSaida.setText(response.body().getCep());
                        txtSaida.append("\n"+response.body().getLogradouro());
                        txtSaida.append("\n"+response.body().getComplemento());
                    }

                    @Override
                    public void onFailure(Call<Local> call, Throwable t) {
                        txtSaida.setText(t.getMessage());
                    }
                });
            }
        });
    }
}