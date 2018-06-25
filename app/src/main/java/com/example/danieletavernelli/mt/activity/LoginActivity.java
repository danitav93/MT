package com.example.danieletavernelli.mt.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.danieletavernelli.mt.R;
import com.example.tavernelli.daniele.libreriadidanieletavernelli.Methods.IntentMethods;
import com.example.tavernelli.daniele.libreriadidanieletavernelli.Methods.KeyboardMethods;
import com.example.tavernelli.daniele.libreriadidanieletavernelli.Methods.ToastMethods;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        initViews();

        setListeners();
    }

    private void setListeners() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LoginTask(getBaseContext(),progressBar,usernameView,passwordView,errorLoginView).execute();
                KeyboardMethods.hideKeyboard((Activity) context);
            }
        });
    }

    private void initViews() {
        usernameView = findViewById(R.id.activity_login_password_username_text);
        passwordView= findViewById(R.id.activity_login_password_edit_text);
        loginButton= findViewById(R.id.activity_login_sign_in_button);
        progressBar=findViewById(R.id.activity_login_progress_bar);
        errorLoginView = findViewById(R.id.activity_login_error_text_view);
    }


    private static class LoginTask extends AsyncTask<Void,Void,Void> {

        private WeakReference<Context> context;
        private WeakReference<ProgressBar> progressBar;
        private WeakReference<TextView> errorLoginView;
        private String username;
        private String password;
        private LoginResponse loginResponse ;

        LoginTask(Context context, ProgressBar progressBar, AutoCompleteTextView usernameView, EditText passwordView,TextView errorLoginView){
            this.context=new WeakReference<>(context);
            this.progressBar=new WeakReference<>(progressBar);
            this.errorLoginView=new WeakReference<>(errorLoginView);
            this.username=usernameView.getText().toString();
            this.password=passwordView.getText().toString();

        }

        @Override
        protected void onPreExecute() {
            errorLoginView.get().setVisibility(View.INVISIBLE);
            progressBar.get().setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            UtenteService utenteService = new DummyUtenteServiceImpl();

            loginResponse = utenteService.authenticate(username,password);



            return null;
        }

        @Override
        protected void onPostExecute(Void param) {
            progressBar.get().setVisibility(View.GONE);

            if (loginResponse.getCode()==Constants.CODE_OK) {

                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putParcelable(Constants.UTENTE_PARCELABLE,loginResponse.getUtente());
                i.putExtras(b);
                i.setClass(context.get(),MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.get().startActivity(i);

            } else {
                errorLoginView.get().setVisibility(View.VISIBLE);
                errorLoginView.get().setText(loginResponse.getErrore());
            }

        }
    }

}
