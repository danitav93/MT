package com.exemple.danieletavernelli.mt.service.dummyImpl;

import com.exemple.danieletavernelli.mt.model.Argomento;
import com.exemple.danieletavernelli.mt.model.Post;
import com.exemple.danieletavernelli.mt.service.interfaccia.ArgomentoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniele Tavernelli on 6/21/2018.
 */

public class DummyArgomentoServiceImpl implements ArgomentoService {
    @Override
    public List<Argomento> getListByIdTopic(int idTopic) {

        return generateDummyList();
    }




    private List<Argomento> generateDummyList() {

        List<Argomento> list = new ArrayList<>();

        for (int i=0;i<10;i++) {
            list.add(generateDummyModel());
        }

        return list;

    }

    private Argomento generateDummyModel() {
        return new Argomento();
    }

}
