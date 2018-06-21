package com.exemple.danieletavernelli.mt.service.dummyImpl;

import com.exemple.danieletavernelli.mt.model.Post;
import com.exemple.danieletavernelli.mt.service.interfaccia.PostService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniele Tavernelli on 6/21/2018.
 */

public class DummyPostServiceImpl implements PostService {

    @Override
    public List<Post> getListByIds(List<Integer> ids) {

        return generateDummyList();
    }

    @Override
    public Post getById(int id) {
        return generateDummyModel();
    }

    @Override
    public List<Post> getPostRecenti() {
        return generateDummyList();
    }

    @Override
    public List<Post> getListByIdUtente(int idUtente) {
        return generateDummyList();
    }

    @Override
    public List<Post> getListByIdArgomento(int idArgomento) {
        return generateDummyList();
    }

    @Override
    public int saveNewPost(Post post) {
        return 0;
    }


    private List<Post> generateDummyList() {

        List<Post> list = new ArrayList<>();

        for (int i=0;i<10;i++) {
            list.add(generateDummyModel());
        }

        return list;

    }

    private Post generateDummyModel() {
        return new Post();
    }

}
