package com.dxctraining.complaints.utility;

import com.dxctraining.complaints.dto.ComplaintDto;
import com.dxctraining.complaints.entities.Complaints;
import org.springframework.stereotype.Component;

@Component
public class ComplaintUtil {

    public ComplaintDto complaintDto(Complaints complaints, int consumerid, String name) {
        ComplaintDto complaintDto=new ComplaintDto(complaints.getId(),complaints.getDescp(),
                complaints.getConsumerId(),name);
        return complaintDto;
    }
}
