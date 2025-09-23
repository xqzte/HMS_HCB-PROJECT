package com.example.demo.Controller;

import com.example.demo.DTO.NurseRegistrationDto;
import com.example.demo.Entities.Nurse;
import com.example.demo.Service.NurseService;
import com.example.demo.Service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/nurse")
public class NurseController {

    private final NurseService nurseService;
    private RegistrationService registrationService;

    public NurseController(NurseService nurseService) {
        this.nurseService = nurseService;
    }


//    @PostMapping("/register")
//    public Nurse create (@RequestBody Nurse nurse){
//        return nurseService.saveNurse( nurse);
//    }

    @GetMapping
    public List<Nurse > getAllNurses(){
        return  nurseService.getAllNurses();
    }

    @GetMapping("/{email}")
    public Nurse findByEmail (@PathVariable String email ){
        return  nurseService.findNurseByEmail(email).orElseThrow(()-> new RuntimeException("Nurse Not Found"));
    }

    @PutMapping("/{email}")
    public Nurse update (@PathVariable String email, @RequestBody Nurse nurse){
        return nurseService.updateNurse(email,nurse);
    }

    @DeleteMapping("/{email}")
    public void  delete(@PathVariable String email){
        nurseService.deleteNurse(email);
    }


    @PostMapping("/register")
    public ResponseEntity<Nurse> registerNurse(@RequestBody NurseRegistrationDto dto) {
        Nurse nurse = registrationService.registerNurse(dto);
        return ResponseEntity.ok(nurse);
    }

}