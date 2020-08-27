package com.dxctraining.complaints.exceptions;

public class ComplaintNotFound extends RuntimeException {
    public ComplaintNotFound(String msg)
    {
        super(msg);
    }
}
