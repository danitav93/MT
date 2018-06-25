package com.exemple.danieletavernelli.mt.service.interfaccia;

import com.exemple.danieletavernelli.mt.model.Argomento;

import java.util.List;

/**
  Created by Daniele Tavernelli on 6/21/2018.
 */

public interface ArgomentoService {

    List<Argomento> getListByIdTopic(int idTopic);

}
