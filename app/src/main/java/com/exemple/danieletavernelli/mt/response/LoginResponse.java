package com.exemple.danieletavernelli.mt.response;

import com.exemple.danieletavernelli.mt.model.Utente;

/**
 * Created by Daniele Tavernelli on 6/25/2018.
 */

public class LoginResponse {

    Utente utente;
    String errore;
    int code;

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrore() {
        return errore;
    }

    public void setErrore(String errore) {
        this.errore = errore;
    }
}
