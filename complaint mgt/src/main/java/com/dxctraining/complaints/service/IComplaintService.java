package com.dxctraining.complaints.service;

import com.dxctraining.complaints.entities.Complaints;

import java.util.List;

public interface IComplaintService {
    Complaints add(Complaints complaints);
    Complaints complaintById(int id);
    List<Complaints> complaintByConsumerById(int id);

}
