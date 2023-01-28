package projeto.android.placarjogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import projeto.android.placarjogo.databinding.ActivityFinalBinding;
import projeto.android.placarjogo.databinding.ActivityMainBinding;

public class ActivityFinal extends AppCompatActivity {

    ActivityFinalBinding binding;
    public int vencedor;
    public int perderdor;

    public static final String LOCAL_KEY = "local_valor";
    public static final String VISITANTE_KEY = "local_visitante";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        binding = ActivityFinalBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        try {
            int localValor = getIntent().getExtras().getInt(LOCAL_KEY);
            int visitanteValor = getIntent().getExtras().getInt(VISITANTE_KEY);

            if (localValor > visitanteValor) {
                binding.whoWonText.setText("Local Venceu!");
                vencedor = localValor;
                perderdor = visitanteValor;
            } else if (visitanteValor > localValor) {
                binding.whoWonText.setText("Visitante Venceu!");
                vencedor = visitanteValor;
                perderdor = localValor;
            } else {
                binding.whoWonText.setText("EMPATE!!!!!!");
            }

            binding.scoreText.setText(Integer.toString(vencedor) + " X " + Integer.toString(perderdor));

        } catch (NullPointerException e) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}