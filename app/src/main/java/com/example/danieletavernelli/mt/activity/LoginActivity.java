package com.example.danieletavernelli.mt.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.danieletavernelli.mt.R;
import com.example.tavernelli.daniele.libreriadidanieletavernelli.Methods.KeyboardMethods;

import com.exemple.danieletavernelli.mt.constant.Constants;
import com.exemple.danieletavernelli.mt.response.LoginResponse;
import com.exemple.danieletavernelli.mt.service.dummyImpl.DummyUtenteServiceImpl;
import com.exemple.danieletavernelli.mt.service.interfaccia.UtenteService;

import java.lang.ref.WeakReference;

public class LoginActivity extends AppCompatActivity {

    //view
    private AutoCompleteTextView usernameView;
    private EditText passwordView;
    private Button loginButton;
    private ProgressBar progressBar;
    private TextView errorLoginView;


    //context
    private Context context=this;

    //private
    private Animation blink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        initViews();

        setListeners();

        initAnim();
    }

    private void initAnim() {
        blink =AnimationUtils.loadAnimation(this, R.anim.blink);
    }

    private void setListeners() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LoginTask((LoginActivity) context).execute();
                loginButton.setEnabled(false);
                KeyboardMethods.hideKeyboard((Activity) context);
            }
        });

        TextWatcher focusChangeListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                errorLoginView.clearAnimation();
                errorLoginView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        usernameView.addTextChangedListener(focusChangeListener);
        passwordView.addTextChangedListener(focusChangeListener);
    }

    private void initViews() {
        usernameView = findViewById(R.id.activity_login_password_username_text);
        passwordView= findViewById(R.id.activity_login_password_edit_text);
        loginButton= findViewById(R.id.activity_login_sign_in_button);
        progressBar=findViewById(R.id.activity_login_progress_bar);
        errorLoginView = findViewById(R.id.activity_login_error_text_view);

    }


    private static class LoginTask extends AsyncTask<Void,Void,Void> {

        private WeakReference<LoginActivity> loginActivity;
        private String username;
        private String password;
        private LoginResponse loginResponse ;

        LoginTask(LoginActivity loginActivity){
            this.loginActivity=new WeakReference<>(loginActivity);
            this.username=loginActivity.usernameView.getText().toString();
            this.password=loginActivity.passwordView.getText().toString();

        }

        @Override
        protected void onPreExecute() {
            loginActivity.get().errorLoginView.clearAnimation();
            loginActivity.get().errorLoginView.setVisibility(View.INVISIBLE);
            loginActivity.get().progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
               // Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            UtenteService utenteService = new DummyUtenteServiceImpl();

            loginResponse = utenteService.authenticate(username,password);



            return null;
        }

        @Override
        protected void onPostExecute(Void param) {

            loginActivity.get().progressBar.setVisibility(View.INVISIBLE);


            if (loginResponse.getCode()==Constants.CODE_OK) {

                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putParcelable(Constants.UTENTE_PARCELABLE,loginResponse.getUtente());
                i.putExtras(b);
                i.setClass(loginActivity.get(),MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                loginActivity.get().startActivity(i);
                loginActivity.get().finish();

            } else {
                loginActivity.get().errorLoginView.setVisibility(View.VISIBLE);
                loginActivity.get().errorLoginView.setText(loginResponse.getErrore());
                loginActivity.get().errorLoginView.startAnimation(loginActivity.get().blink);
                loginActivity.get().loginButton.setEnabled(true);

            }

        }
    }

}
