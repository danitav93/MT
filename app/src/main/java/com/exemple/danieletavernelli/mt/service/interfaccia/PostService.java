package com.exemple.danieletavernelli.mt.service.interfaccia;

import com.exemple.danieletavernelli.mt.model.Post;

import java.util.List;

/**
 * Created by Daniele Tavernelli on 6/21/2018.
 */

public interface PostService {

     List<Post> getListByIds(List<Integer> ids);

     Post getById(int id);

     List<Post> getPostRecenti();

     List<Post> getListByIdUtente(int idUtente);

     List<Post> getListByIdArgomento(int idArgomento);

     int saveNewPost(Post post);

}
