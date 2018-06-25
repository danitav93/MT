package com.exemple.danieletavernelli.mt.service.dummyImpl;

import com.exemple.danieletavernelli.mt.model.Utente;
import com.exemple.danieletavernelli.mt.response.LoginResponse;
import com.exemple.danieletavernelli.mt.service.interfaccia.UtenteService;

import java.util.ArrayList;
import java.util.List;

import static com.exemple.danieletavernelli.mt.constant.Constants.CODE_GENERIC_ERROR;
import static com.exemple.danieletavernelli.mt.constant.Constants.CODE_OK;

/**
 * Created by Daniele Tavernelli on 6/21/2018.
 */

public class DummyUtenteServiceImpl implements UtenteService {

    @Override
    public LoginResponse authenticate(String username, String password) {

        LoginResponse loginResponse = new LoginResponse();


        if (username.equals("testUsername")&& password.equals("testPassword")) {

            loginResponse.setUtente(generateDummyModel());
            loginResponse.setCode(CODE_OK);
        } else {
            loginResponse.setCode(CODE_GENERIC_ERROR);
            loginResponse.setErrore("Credenziali errate");
        }

        return loginResponse;


    }

    @Override
    public Utente getUtenteById(int id) {
        return generateDummyModel();
    }

    @Override
    public List<Utente> getUtenteByIds(List<Integer> ids) {
        return generateDummylist();
    }

    private List<Utente> generateDummylist() {

        List<Utente> list = new ArrayList<>();

        for (int i=0;i<10;i++) {
            list.add(generateDummyModel());
        }

        return list;

    }

    private Utente generateDummyModel() {
        Utente utente= new Utente();
        utente.setUsername("userTest");
        return utente;
    }

}
