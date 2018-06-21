package com.exemple.danieletavernelli.mt.service.interfaccia;

import com.exemple.danieletavernelli.mt.model.Topic;

import java.util.List;

/**
 * Created by Daniele Tavernelli on 6/21/2018.
 */

public interface TopicService {

    List<Topic> getListByIdSezione(int idSezione);

}
