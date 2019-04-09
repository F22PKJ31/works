package com.arop.works.controller;

import com.arop.works.entity.Painting;
import com.arop.works.repository.PaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bo.fan
 * @date 2019-04-09
 */

@RestController
@RequestMapping("/painting")
public class PaintingController {

    @Autowired
    private PaintingRepository repository;

    @RequestMapping("save")
    public boolean save(@RequestBody Painting painting) {
        return repository.saveAndFlush(painting).getId() != null;
    }


    @RequestMapping("delete")
    public void delete(@RequestBody Painting painting) {
        repository.deleteById(painting.getId());
    }

    @RequestMapping("list")
    public List<Painting> list(){
        return repository.findAll(Sort.by("update_time"));
    }

    @RequestMapping("find")
    public List<Painting> find(@RequestBody Painting painting){
        return repository.findAll(Example.of(painting));
    }


}
