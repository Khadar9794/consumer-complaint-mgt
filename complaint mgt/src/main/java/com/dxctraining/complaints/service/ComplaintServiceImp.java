package com.dxctraining.complaints.service;

import com.dxctraining.complaints.dao.IComplaintDao;
import com.dxctraining.complaints.entities.Complaints;
import com.dxctraining.complaints.exceptions.ComplaintDescription;
import com.dxctraining.complaints.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ComplaintServiceImp implements IComplaintService{

    @Autowired
    private IComplaintDao complaintDao;


    @Override
    public Complaints add(Complaints complaints) {
      validate(complaints);
      String description=complaints.getDescription();
      if(description.isEmpty() || description==null)
      {
          throw  new ComplaintDescription("complaints cant be empty or null");
      }
      return complaintDao.add(complaints);
    }

    private void validate(Complaints complaints) {
        if(complaints==null)
        {
            throw new InvalidArgumentException("complaints cant be empty");
        }
    }

    @Override
    public Complaints complaintById(int id) {
        validateId(id);
       Complaints complaints=complaintDao.complaintById(id);
       return complaints;
    }

    private void validateId(int id) {
        if(id<1)
            throw  new InvalidArgumentException("id cant be null");
    }

    @Override
    public List<Complaints> complaintByConsumerById(int id) {
      validateId(id);
      List<Complaints>result=complaintDao.complaintByConsumerId(id);
      return result;
    }



}
