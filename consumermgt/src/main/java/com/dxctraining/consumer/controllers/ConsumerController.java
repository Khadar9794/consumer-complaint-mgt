package com.dxctraining.consumer.controllers;


import com.dxctraining.consumer.dto.CreateConsumerRequest;
import com.dxctraining.consumer.dto.ConsumerDto;
import com.dxctraining.consumer.entities.Consumer;
import com.dxctraining.consumer.service.IConsumerService;
import com.dxctraining.consumer.util.ConsumerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/consumers")
@Component
public class ConsumerController {

    @Autowired
    private IConsumerService Consumerservice;

    @Autowired
    private ConsumerUtility util;

    @Path("/add")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public ConsumerDto add(CreateRequest ConsumerData) {
        System.out.println("inside add");
        Consumer consumer = new Consumer(consumerData.getName());
               
       consumer=service.save(consumer);
        ConsumerDto dto = util.ConsumerDto(Consumer);
        return dto;
    }


    @Path("/get/{id}")
    @Produces("application/json")
    @GET
    public Response getConsumer(@PathParam("id") int id) {
    	Consumer consumer = service.findConsumerById(id);
    	ConsumerDto dto = util.ConsumerDto(Consumer);
        Response response=Response.status(Response.Status.OK)
                .entity(dto)
                .build();
        return response;
    }


}