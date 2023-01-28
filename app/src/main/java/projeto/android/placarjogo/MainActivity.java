package projeto.android.placarjogo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import projeto.android.placarjogo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        //observes
        viewModel.valorLocal.observe(this, integer -> binding.localScoreText.setText(Integer.toString(integer)));

        viewModel.valorVisitante.observe(this, integer -> binding.visitorScoreText.setText(Integer.toString(integer)));

        botoes();

        binding.resultsButton.setOnClickListener(view1 -> {
            Intent inte = new Intent(getApplicationContext(), ActivityFinal.class);
            startActivity(inte);

            Intent in = new Intent(getApplicationContext(), ActivityFinal.class);
            in.putExtra(ActivityFinal.LOCAL_KEY, viewModel.valorLocal.getValue());
            in.putExtra(ActivityFinal.VISITANTE_KEY, viewModel.valorVisitante.getValue());
            startActivity(in);
            finish();

        });

    }

    private void botoes() {

        binding.localMinusButton.setOnClickListener(view -> viewModel.decrementoLocal());

        binding.restartButton.setOnClickListener(view -> viewModel.reset());

        binding.localPlusButton.setOnClickListener(view -> viewModel.incrementUmLocal());

        binding.localTwoPointsButton.setOnClickListener(view -> viewModel.incrementDoisLocal());

        binding.visitorMinusButton.setOnClickListener(view -> viewModel.decrementoVisitante());

        binding.visitorPlusButton.setOnClickListener(view -> viewModel.incrementUmVisitante());

        binding.visitorTwoPointsButton.setOnClickListener(view -> viewModel.incrementDoisVisitante());

    }
}
