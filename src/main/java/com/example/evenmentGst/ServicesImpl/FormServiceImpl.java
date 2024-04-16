package com.example.evenmentGst.ServicesImpl;



import com.example.evenmentGst.Dto.RequestForm;
import com.example.evenmentGst.Dto.ResponseForm;
import com.example.evenmentGst.Entities.Form;
import com.example.evenmentGst.Repository.FormRepository;
import com.example.evenmentGst.Service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FormServiceImpl  {

//    @Autowired
//    private FormRepository formRepository;
//
//    @Override
//    public List<ResponseForm> getAllForm() {
//        List<Form> forms = formRepository.findAll();
//        List<ResponseForm> formFormated = new ArrayList<>();
//        for (Form form : forms) {
//            ResponseForm formF = ResponseForm.makeForm(form);
//            formFormated.add(formF);
//        }
//        return formFormated;
//    }
//
//    @Override
//    public void createForm (RequestForm requestForm) {
//            Form form = Form.builder()
////                    .type(requestForm.getType())
////                    .label(requestForm.getLabel())
////                    .name(requestForm.getName())
////                    .value(requestForm.getValue())
////                    .options(requestForm.getOptions())
////                    .required(requestForm.getRequired())
//                    .build();
//            formRepository.save(form);
//        }
//
//
//
//    @Override
//    public ResponseForm getFormById(Long id) {
//        Optional<Form> form = formRepository.findById(id);
//        return ResponseForm.makeForm(form.get());
//    }
//
//    @Override
//    public Form updateForm(Long id, RequestForm requestForm) {
//        Form form = formRepository.findById(id).orElseThrow();
//        if (requestForm.getType() != null) {
//            form.setType(requestForm.getType());
//        }
//        if (requestForm.getLabel() != null) {
//            form.setLabel(requestForm.getLabel());
//        }
//        if (requestForm.getName() != null) {
//            form.setName(requestForm.getName());
//        }
//        if (requestForm.getValue() != null) {
//            form.setValue(requestForm.getValue());
//        }
//        if (requestForm.getOptions() != null) {
//            form.setOptions(requestForm.getOptions());
//        }
//        if (requestForm.getRequired() != null) {
//            form.setRequired(requestForm.getRequired());
//        }
//        return formRepository.save(form);
//    }
//
//    @Override
//    public boolean deleteForm(Long id) {
//        if (!formRepository.existsById(id)){
//            return false ;
//        }
//        formRepository.deleteById(id);
//        return true;
//    }
}
