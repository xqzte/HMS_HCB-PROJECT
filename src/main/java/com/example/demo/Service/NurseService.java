package com.example.demo.Service;

import com.example.demo.Entities.Nurse;
import com.example.demo.Repository.NurseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NurseService {
    private NurseRepository nurseRepository;

    public NurseService(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    public Nurse saveNurse(Nurse nurse){
       return nurseRepository.save(nurse);
    }

    public List<Nurse> getAllNurses (){
        return nurseRepository.findAll();
    }

    public Optional <Nurse> getNurseById (Long id){
        return nurseRepository.findById(id);
    }

    public Nurse updateNurse (Long id, Nurse nurse){

        return nurseRepository.findById(id)
                .map(existing ->{
                    existing.setDepartment(nurse.getDepartment());

                    return nurseRepository.save(existing);
                }) .orElseThrow(()-> new RuntimeException("Nurse Not Found"));

    }

    public void deleteNurse (Long id){
        nurseRepository.delete(id);
    }


}
