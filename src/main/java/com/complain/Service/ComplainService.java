package com.complain.Service;

import com.complain.Data.Complain;
import com.complain.Data.ComplainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ComplainService {
    @Autowired
    private ComplainRepository compRepo;

    public Complain createComplain(Complain comp){
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
