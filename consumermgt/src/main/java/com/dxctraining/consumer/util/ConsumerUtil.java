package com.dxctraining.consumer.util;

import com.dxctraining.consumer.dto.ConsumerDto;
import com.dxctraining.consumer.entities.Consumer;
import org.springframework.stereotype.Component;

@Component
public class ConsumerUtil {


    public ConsumerDto consumerDto(Consumer consumer) {
        ConsumerDto dto=new ConsumerDto(consumer.getId(),consumer.getName());
        return consumerDto;

    }
}
