package com.dxctraining.consumer.dao;

import com.dxctraining.consumer.entities.Consumer;


import java.util.ConcurrentModificationException;

public interface IConsumerDao {
    Consumer addConsumer(Consumer consumer);
    Consumer findConsumerById(int id);
}
