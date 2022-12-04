package com.xrest.nchl.service;

import com.xrest.nchl.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface BaseService<C,I> {
     C findOne(I id);

     List<C> findAll();

     C save(C c);

     @Transactional
     @Modifying
     void deleteById(I id);
}
