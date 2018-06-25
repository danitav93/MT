package com.example.danieletavernelli.mt.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.danieletavernelli.mt.R;
import com.example.tavernelli.daniele.libreriadidanieletavernelli.Methods.ToastMethods;
import com.exemple.danieletavernelli.mt.constant.Constants;
import com.exemple.danieletavernelli.mt.model.Utente;

public class MainActivity extends AppCompatActivity {

    private Utente utente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            utente = b.getParcelable(Constants.UTENTE_PARCELABLE);
            ToastMethods.showShortToast(this,utente.getUsername());
        }



    }
}
