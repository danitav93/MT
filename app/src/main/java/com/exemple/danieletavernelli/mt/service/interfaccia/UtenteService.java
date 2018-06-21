package com.exemple.danieletavernelli.mt.service.interfaccia;

import com.exemple.danieletavernelli.mt.model.Utente;

import java.util.List;

/**
 * Created by Daniele Tavernelli on 6/21/2018.
 */

public interface UtenteService {

     Utente authenticate(String username, String password);

     Utente getUtenteById(int id);

     List<Utente> getUtenteByIds(List<Integer> ids);

}
