package com.dxctraining.consumer.service;

import com.dxctraining.consumer.dao.IConsumerDao;

import com.dxctraining.consumer.entities.Consumer;
import com.dxctraining.consumer.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ConsumerServiceImp implements IConsumerService{

    @Autowired
    private IConsumerDao consumerDao;

    @Override
    public Consumer add(Consumer consumer) {
        validate(consumer);
        consumerDao.add(consumer);
        return consumer;
    }
    private void validate(Object arg) {
        if(arg==null)
        {
            throw  new InvalidArgumentException("invalid argument and consumer cant be null");

        }
    }

    @Override
    public Consumer findConsumerById(int id){
        Consumer consumer=consumerDao.ConsumerById(id);
        return consumer;
    }
}
