package com.complain.service;

import com.complain.data.Complain;
import com.complain.data.ComplainRepository;
import com.complain.service.interservice.ContractService;
import com.complain.service.interservice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ComplainService {
    @Autowired
    private ComplainRepository compRepo;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ContractService contractService;

    public Complain createComplain(Complain comp){
        if (!customerService.CustomerExists(comp.getCustomerId())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer was not found");
        }
        comp.setDate(new Date());
        comp.setStatus("In Progress");
        return compRepo.save(comp);
    }

    public List<Complain> getAllComplains(){
        return compRepo.findAll();
    }

    public Complain getComplainById(int id){
        Optional<Complain> com =  compRepo.findById(id);
        if(com.isPresent()){
            return com.get();
        }
        return null;
    }

    public List<Complain> getComplainsByCustomerId(int id){
        return compRepo.getComplainsByCustomerId(id);

    }

    public Complain updateComplain(Complain comp){
        if (!customerService.CustomerExists(comp.getCustomerId())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer was not found");
        }
        comp.setDate(new Date());
        comp.setStatus("In Progress");
        return compRepo.save(comp);

    }

    public void deleteComplain(int id){
        compRepo.deleteById(id);
    }

    @Transactional
    public void updateComplainStatus(int id){
         compRepo.updateComplainStatus(id);
    }
}
