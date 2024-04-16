package com.example.evenmentGst.Service;


import com.example.evenmentGst.Dto.RequestForm;

import com.example.evenmentGst.Dto.ResponseForm;

import com.example.evenmentGst.Entities.Form;

import java.util.List;

public interface FormService {

    List<ResponseForm> getAllForm();
    void createForm(RequestForm requestForm);
    ResponseForm getFormById(Long id);
    Form updateForm(Long id , RequestForm requestForm);
    boolean deleteForm(Long id);


}
