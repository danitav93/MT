package com.exemple.danieletavernelli.mt.service.dummyImpl;

import com.exemple.danieletavernelli.mt.model.Sezione;

import com.exemple.danieletavernelli.mt.service.interfaccia.SezioneService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniele Tavernelli on 6/21/2018.
 */

public class DummySezioneServiceImpl implements SezioneService {

    @Override
    public List<Sezione> getList() {
        return generateDummyList();
    }

    private List<Sezione> generateDummyList() {

        List<Sezione> list = new ArrayList<>();

        for (int i=0;i<10;i++) {
            list.add(generateDummyModel());
        }

        return list;

    }

    private Sezione generateDummyModel() {
        return new Sezione();
    }


}
