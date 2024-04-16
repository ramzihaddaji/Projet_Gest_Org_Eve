package com.example.evenmentGst.Service;

import com.example.evenmentGst.Dto.RequestChoice;
import com.example.evenmentGst.Dto.ResponseChoice;
import com.example.evenmentGst.Entities.Choice;

import java.util.List;

public interface ChoiceService {
    List<ResponseChoice> getAllChoice();
    void createChoice(RequestChoice requestChoice);
    ResponseChoice getChoiceById(Long id);
    Choice updateChoice(Long id , RequestChoice requestChoice);
    boolean deleteChoice(Long id);
}
