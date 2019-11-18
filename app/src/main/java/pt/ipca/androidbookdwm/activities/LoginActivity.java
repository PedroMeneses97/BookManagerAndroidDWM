package pt.ipca.androidbookdwm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;


import com.google.android.material.snackbar.Snackbar;

import pt.ipca.androidbookdwm.R;
import pt.ipca.androidbookdwm.dialogs.AlertConfig;
import pt.ipca.androidbookdwm.dialogs.Dialogs;
import pt.ipca.androidbookdwm.interfaces.DialogsResult;

public class LoginActivity extends AppCompatActivity {

    private static final String DUMMY_EMAIL ="VAIS-SOZINHO@ATÉLOGO.PT";
    private static final String DUMMY_PASSWORD ="123";

    private EditText etEmail;
    private EditText etPassword;
    private CheckBox cbRemember;
    private ConstraintLayout clMainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.tboxEmail);
        etPassword = findViewById(R.id.Password);
        cbRemember = findViewById(R.id.checkBox);
        clMainLayout = findViewById(R.id.MainLayout);

    }


    public void onLoginClick(View view) {

        if (!etEmail.getText().toString().equals(DUMMY_EMAIL))
        {
            etEmail.setError(getString(R.string.invalid_email));
            etEmail.requestFocus();
            return;
        }

        if (!etPassword.getText().toString().equals(DUMMY_PASSWORD))
        {
            etPassword.setError(getString(R.string.invalid_password));
            etEmail.requestFocus();
            return;
        }
        /*
        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show(); */
        Snackbar.make(clMainLayout,"Success", Snackbar.LENGTH_SHORT).show();


    }

    public void onForgetPassword(View view) {

        AlertConfig alertConfig = new AlertConfig(getString(R.string.forgot_password_title),
                getString(R.string.forgot_password_message),
                getString(R.string.ok));

        Dialogs.showAlertDialog(this, alertConfig, new DialogsResult() {
            @Override
            public void onResult(boolean ok) {

                Snackbar.make(clMainLayout,"Carreguei no OK", Snackbar.LENGTH_SHORT).show();
            }
        });









    }

    public void onCreateNewUser(View view) {

    }
}
