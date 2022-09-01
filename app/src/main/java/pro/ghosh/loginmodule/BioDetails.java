package pro.ghosh.loginmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class BioDetails extends AppCompatActivity {
    TextView tvAge;
    TextView tvBio;
    TextView tvInterests;
    EditText etAge;
    EditText etBio;
    RadioButton rbCompsci;
    RadioButton rbFinance;
    RadioButton rbPsychology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tvAge = (TextView) findViewById(R.id.tvAge);
        tvBio = (TextView) findViewById(R.id.tvBio);
        tvInterests = (TextView) findViewById(R.id.tvInterests);
        etAge = (EditText) findViewById(R.id.etAge);
        etBio = (EditText) findViewById(R.id.etBio);
        rbCompsci = (RadioButton) findViewById(R.id.rbCompsci);
        rbFinance = (RadioButton) findViewById(R.id.rbFinance);
        rbPsychology = (RadioButton) findViewById(R.id.rbPsychology);

        tvAge.setText(R.string.a);
        tvBio.setText(R.string.b);
        tvInterests.setText(R.string.Int);
        etAge.setText(R.string.wya);
        etBio.setText(R.string.hey+" "+getIntent().getExtras().getString("Name"));



    }

}