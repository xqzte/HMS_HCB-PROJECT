package com.example.demo.Controller;



import com.example.demo.Entities.Nurse;
import com.example.demo.Service.NurseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class NurseController {

    private final NurseService nurseService;

    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }


    @PostMapping
    public Nurse  create (@RequestBody Nurse nurse){
        return nurseService.saveNurse( nurse);
    }

    @GetMapping
    public List<Nurse > getAllNurses(){
        return  nurseService.getAllNurses();
    }

    public Nurse findById (@PathVariable Long id){
        return  nurseService.getNurseById(id).orElseThrow(()-> new RuntimeException("Nurse Not Found"));
    }

    public Nurse update (@PathVariable Long id, @RequestBody Nurse nurse){
        return nurseService.updateNurse(id,nurse);
    }

    public void  delete(@PathVariable Long id){
        nurseService.deleteNurse(id);
    }



}
