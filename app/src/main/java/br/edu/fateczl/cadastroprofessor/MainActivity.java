package br.edu.fateczl.cadastroprofessor;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fateczl.cadastroprofessor.controller.CadastroHorista;
import br.edu.fateczl.cadastroprofessor.controller.CadastroTitular;
import br.edu.fateczl.cadastroprofessor.controller.ICadastroFactory;
import br.edu.fateczl.cadastroprofessor.model.Professor;

public class MainActivity extends AppCompatActivity {
    private Professor prof;

    EditText inputEspFirst;
    EditText inputEspSecond;

    RadioButton rbHorista;
    RadioButton rbTitular;

    EditText inputName;
    EditText inputMatricula;
    EditText inputAge;

    TextView output1;
    TextView output2;
    private ICadastroFactory cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbHorista = findViewById(R.id.rbHorista);
        rbHorista.setChecked(true);
        rbHorista.setOnClickListener(cH -> changeHints());

        rbTitular = findViewById(R.id.rbTitular);
        rbTitular.setOnClickListener(cH -> changeHints());

        inputEspFirst = findViewById(R.id.inputEspFirst);
        inputEspSecond = findViewById(R.id.inputEspSecond);

        inputName = findViewById(R.id.inputName);
        inputMatricula = findViewById(R.id.inputMatricula);
        inputAge = findViewById(R.id.inputAge);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);

        Button btnCad = findViewById(R.id.btnCad);
        Button btnCon = findViewById(R.id.btnCon);
        btnCad.setOnClickListener(op -> realizarCadastro());
        btnCon.setOnClickListener(op -> {
            try {
                computeSalario();
            } catch (Exception e) {
                output1.setText(e.getMessage());
            }
        });
    }

    private void realizarCadastro() {
        output1.setText(getString(R.string.output_1));
        checkProfessor(); //Change the type of Professor based on which radioButton is selected
        try {
            String nome = inputName.getText().toString();
            if(nome.isEmpty()) {
                throw new Exception("empty_string");
            }
            String cod = inputMatricula.getText().toString();
            if(cod.isEmpty()) {
                throw new Exception("empty_string");
            }
            int idade = Integer.parseInt(inputAge.getText().toString());
            int hora_or_ano = Integer.parseInt(inputEspFirst.getText().toString());
            double valHora_or_salarioAtual = Double.parseDouble(inputEspSecond.getText().toString());
            prof = cadastro.cadastrarProf(nome, cod, idade, hora_or_ano, valHora_or_salarioAtual);
        } catch (Exception e) {
            output1.setText(getString(R.string.empty_string));
        }
    }

    private void computeSalario() throws Exception {
        checkProfessor(); //Does the same as commented above
        if (prof == null) {
            throw new Exception(getString(R.string.empty_register));
        } else {
            output1.setText(prof.toString());
            double salario = prof.calcSalario();
            String output = String.format(getString(R.string.output_2), salario);
            output2.setText(output);
        }
    }

    private void changeHints() {
        if (rbHorista.isChecked()) {
            inputEspFirst.setHint(R.string.prof_horasH);
            inputEspSecond.setHint(R.string.prof_valorH);
        }
        if (rbTitular.isChecked()) {
            inputEspFirst.setHint(R.string.prof_anosT);
            inputEspSecond.setHint(R.string.prof_salarioT);
        }
    }

    private void checkProfessor() {
        if (rbHorista.isChecked()) {
            cadastro = new CadastroHorista();
        }
        if (rbTitular.isChecked()) {
            cadastro = new CadastroTitular();
        }
    }
}