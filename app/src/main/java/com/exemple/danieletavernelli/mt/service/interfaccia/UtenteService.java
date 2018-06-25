package com.exemple.danieletavernelli.mt.service.interfaccia;

import com.exemple.danieletavernelli.mt.model.Utente;
import com.exemple.danieletavernelli.mt.response.LoginResponse;

import java.util.List;

/**
 * Created by Daniele Tavernelli on 6/21/2018.
 */

public interface UtenteService {

     LoginResponse authenticate(String username, String password);

     Utente getUtenteById(int id);

     List<Utente> getUtenteByIds(List<Integer> ids);

}
