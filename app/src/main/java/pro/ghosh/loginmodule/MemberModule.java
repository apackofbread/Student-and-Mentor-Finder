package pro.ghosh.loginmodule;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import pro.ghosh.loginmodule.models.User;
import pro.ghosh.loginmodule.services.UserService;

public class MemberModule extends AppCompatActivity {
    private User user;
    private UserService userService;
    private TextView tvEmail;
    private TextView btnLogout;
    TextView btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_module);

        userService = UserService.getInstance();
        user = userService.getUser();

        tvEmail = (TextView) findViewById(R.id.tvEmail);
        btnLogout = (TextView) findViewById(R.id.btnLogout);
        btnContinue = (TextView) findViewById(R.id.btnContinue);

        if (user == null) {
            super.finish();
        } else {
            tvEmail.setText(getIntent().getStringExtra("Name"));
        }

        btnLogout.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Logout")
                    .setMessage("Are you sure you want to log out?")
                    .setPositiveButton(android.R.string.ok, (dialog, which) -> logoutUser())
                    .setNegativeButton(android.R.string.cancel, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        });

        Intent intent = new Intent(MemberModule.this, BioDetails.class);

        btnContinue.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),BioDetails.class);
                i.putExtra("Name", getIntent().getStringExtra("Name"));
                startActivity(i);

            }
        });
    }

    private void logoutUser() {
        userService.logout();
        Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
        super.finish();
    }
}