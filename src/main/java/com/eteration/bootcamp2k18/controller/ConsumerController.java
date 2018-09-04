package com.eteration.bootcamp2k18.controller;


import com.eteration.bootcamp2k18.model.Artist;
import com.eteration.bootcamp2k18.model.Consumer;
import com.eteration.bootcamp2k18.repositories.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    ConsumerRepository consumerRepository;

    @GetMapping("/all")
    public List<Consumer> getAllConsumer(){
        return consumerRepository.findAll();
    }

    @GetMapping("id/id")
    public Consumer getConsumer(@PathVariable long id) {
        return consumerRepository.findById(id).get();
    }

    @PostMapping
    public void createConsumer(@RequestBody Consumer consumer){

        consumerRepository.save(consumer);
    }

    @DeleteMapping("id/{id}")
    public void deleteConsumerById(@PathVariable("id") Long id){

        consumerRepository.delete(consumerRepository.getOne(id));

    }

    @PutMapping("id/{id}")
    public void updateConsumer(@RequestBody Consumer consumer){
        consumerRepository.save(consumer);
    }
}
