package pt.ipca.androidbookdwm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;


import com.google.android.material.snackbar.Snackbar;

import pt.ipca.androidbookdwm.R;
import pt.ipca.androidbookdwm.dialogs.AlertConfig;
import pt.ipca.androidbookdwm.dialogs.Dialogs;
import pt.ipca.androidbookdwm.interfaces.DialogsResult;
import pt.ipca.androidbookdwm.utils.Constants;

public class LoginActivity extends AppCompatActivity {

    private static final String DUMMY_EMAIL ="email@email";
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
        getMyPreferences();

    }



    //Ao clicar no Login.
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

        //Efeitos de clique.(Mensagens de erro ou sucesso)
        /* Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show(); */

        Snackbar.make(clMainLayout,"Success", Snackbar.LENGTH_SHORT).show();

        //Shared Preferences
        SharedPreferences prefs = getSharedPreferences(Constants.MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();

        //Se o remember estiver checkado
        if (cbRemember.isChecked())
        {

            editor.putString(Constants.EMAIL,etEmail.getText().toString());
            editor.putString(Constants.PASSWORD,etPassword.getText().toString());
        }
        // Se não:
        else
        {
            editor.remove(Constants.EMAIL);
            editor.remove(Constants.PASSWORD);
        }

        editor.putBoolean(Constants.REMEMBER, cbRemember.isChecked());
        editor.apply();

        Intent intent = new Intent (getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

    //Onclick no forget Password
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

    // Quando clicar no criar novo utilizador
    public void onCreateNewUser(View view)
    {
        Intent intent = new Intent (getApplicationContext(), CreateUserActivity.class);
        startActivity(intent);
    }

    //As minhas preferencias
    private void getMyPreferences() {

        //Shared Preferences
        SharedPreferences prefs =
                getSharedPreferences(Constants.MyPREFERENCES, Context.MODE_PRIVATE);

        String email = prefs.getString(Constants.EMAIL,null);
        String password = prefs.getString(Constants.PASSWORD,null);
        boolean remember = prefs.getBoolean(Constants.REMEMBER,false);

        if (email != null && password != null){
            etEmail.setText(email);
            etPassword.setText(password);
        }


        cbRemember.setChecked(remember);
    }



}
