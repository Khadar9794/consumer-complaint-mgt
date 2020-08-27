package com.dxctraining.complaints.controllers;


import com.dxctraining.complaints.dto.ComplaintDto;

import com.dxctraining.complaints.dto.ConsumerDto;
import com.dxctraining.complaints.dto.CreateComplaint;
import com.dxctraining.complaints.entities.Complaints;
import com.dxctraining.complaints.service.IComplaintService;
import com.dxctraining.complaints.utility.ComplaintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;


@Component
@Path("/complaints")
public class ComplaintController {

    @Autowired
    private IComplaintService complaintService;

    @Autowired
    private ComplaintUtil complaintUtil;

    @Autowired
    private RestTemplate restTemplate;

    @Path("/add")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public ComplaintDto registerComplaint(@RequestBody CreateComplaintRequest requestData) {
		Complaint complaint = new Complaint(requestData.getDescription(),requestData.getConsumerId());
		service.add(complaint);
		ConsumerDto dto = fetchFromConsumerById(requestData.getConsumerId());
		ComplaintDto dto = util.complaintDto(complaint, consumerDto.getId(), consumerDto.getName());
		return dto;
	}

    private ConsumerDto fetchfromConsumerId(int consumerid) {
      String url="http://localhost:8787/consumers/get/"+consumerid;
      ConsumerDto dto=restTemplate.getForObject(url,ConsumerDto.class);
      return consumerDto;
    }


    @Path("/get/{id}")
    @GET
    @Consumes("application/json")
    @Produces("application/json")
public Response getComplaint(@PathParam("id") int id)
    {
        Complaints complaints=service.findComplaintById(1);
        int consumerid=complaints.getConsumerId();
        ConsumerDto dto = fetchfromConsumerId(consumerid);
        System.out.println("consumer name is="+consumerDto.getName());
        ComplaintDto dto = util.complaintDto(complaints,consumerid,consumerDto.getName());
        return complaintDto;
    }

    @Path("/cid/{id}")
    @Produces("application/json")
    @GET
    public List<ComplaintDto> complaintsList(@PathParam("id") int id)
    {
        List<Complaints> list=service.complaintByConsumerId(id);
        ConsumerDto consumerDto = fetchfromConsumerId(id);
        List<ComplaintDto> dto=new ArrayList<>();
        for (Complaints complaint:list){
            ComplaintDto dto =util.complaintDto(complaint,consumerid,consumerDto.getName());
            dtos.add(dto);
        }
        return dto;

    }






}
