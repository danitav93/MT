package com.exemple.danieletavernelli.mt.service.dummyImpl;

import com.exemple.danieletavernelli.mt.model.Utente;
import com.exemple.danieletavernelli.mt.service.interfaccia.UtenteService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniele Tavernelli on 6/21/2018.
 */

public class DummyUtenteServiceImpl implements UtenteService {

    @Override
    public Utente authenticate(String username, String password) {
        return generateDummyModel();
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
        return new Utente();
    }

}
