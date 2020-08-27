package com.dxctraining.complaints.dao;

import com.dxctraining.complaints.entities.Complaints;
import com.dxctraining.complaints.exceptions.ComplaintNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class ComplaintsDaoImp implements IComplaintDao{

    @Autowired
    private EntityManager entityManager;
    @Override
    public Complaints add(Complaints complaints) {
        entityManager.persist(complaints);
        return complaints;
    }

    @Override
    public Complaints complaintById(int id) {
      Complaints complaints=entityManager.find(Complaints.class,id);
      if(complaints==null)
      {
          throw new ComplaintNotFound("complaint not found");
      }
      return complaints;
    }

    @Override
    public List<Complaints> complaintByConsumerId(int id) {
      String query="from Complaints where consumerId=:conid";
        TypedQuery<Complaints>res=entityManager.createQuery(query,Complaints.class);
        res.setParameter("consumerid",id);
        List<Complaints>complaintslist=res.getResultList();
        return complaintslist;
    }
}
