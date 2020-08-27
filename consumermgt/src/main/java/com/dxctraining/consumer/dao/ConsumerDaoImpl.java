package com.dxctraining.consumer.dao;

import com.dxctraining.consumer.entities.Consumer;

import com.dxctraining.consumer.exceptions.ConsumerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ConsumerDaoImpl implements IConsumerDao{

   @PersistenceContext
   @Autowired
    private EntityManager entityManager;

    @Override
    public Consumer ConsumerById(int id) {
        Consumer consumer=entityManager.find(Consumer.class,id);
        if(consumer==null)
        {
            throw new ConsumerNotFoundException("consumer not found");
        }
        return consumer;
    }
    
    @Override
    public Consumer addConsumer(Consumer consumer) {
       entityManager.persist(consumer);
       return consumer;
    }
}
