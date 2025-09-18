package com.example.demo.Repository;

import com.example.demo.Entities.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
