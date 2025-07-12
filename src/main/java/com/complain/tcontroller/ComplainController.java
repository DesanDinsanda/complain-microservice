package com.complain.tcontroller;

import com.complain.tdata.Complain;
import com.complain.tservice.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @PostMapping(path = "/complains")
    public Complain createComplain(@RequestBody Complain comp){
        return complainService.createComplain(comp);
    }

    @GetMapping(path = "/complains")
    public List<Complain> getAllComplains(){
        return complainService.getAllComplains();
    }

    @GetMapping(path = "complains/{id}")
    public Complain getComplainById(@PathVariable int id){
        return complainService.getComplainById(id);
    }

    @GetMapping(path = "complains", params = {"id"})
    public List<Complain> getComplainsByCustomerId(@RequestParam int id){
        return complainService.getComplainsByCustomerId(id);
    }

    @PutMapping(path = "complains")
    public Complain updateComplain(@RequestBody Complain comp){
        return complainService.updateComplain(comp);
    }

    @DeleteMapping(path = "complains/{id}")
    public void deleteComplain(@PathVariable int id){
        complainService.deleteComplain(id);
    }

    @PutMapping(path = "/complains", params = {"id"})
    public void updateComplainStatus(@RequestParam int id){
         complainService.updateComplainStatus(id);
    }
}
