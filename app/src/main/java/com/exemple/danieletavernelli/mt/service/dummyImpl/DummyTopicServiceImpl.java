package com.exemple.danieletavernelli.mt.service.dummyImpl;

import com.exemple.danieletavernelli.mt.model.Topic;
import com.exemple.danieletavernelli.mt.service.interfaccia.TopicService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniele Tavernelli on 6/21/2018.
 */

public class DummyTopicServiceImpl implements TopicService {
    @Override
    public List<Topic> getListByIdSezione(int idSezione) {
        return generateDummyList();
    }

    private List<Topic> generateDummyList() {

        List<Topic> list = new ArrayList<>();

        for (int i=0;i<10;i++) {
            list.add(generateDummyModel());
        }

        return list;

    }

    private Topic generateDummyModel() {
        return new Topic();
    }
}
