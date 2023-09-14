package com.vvvital.teamchallenge.servise;

import com.vvvital.teamchallenge.entity.Categories;
import com.vvvital.teamchallenge.entity.Psychologist;
import com.vvvital.teamchallenge.repository.jdbc.PsychologistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PsychologistService {
    Logger logger= LoggerFactory.getLogger(PsychologistService.class);
    private final PsychologistRepository psychologistRepository;

    @Autowired
    public PsychologistService(PsychologistRepository psychologistRepository) {
        this.psychologistRepository = psychologistRepository;
    }

    public Psychologist create(Psychologist psychologist) {
        return psychologistRepository.create(psychologist);
    }

    public Psychologist login(String email, String password) {
        Psychologist psychologist = psychologistRepository.getEmail(email);
        if (psychologist.getPassword().equals(password)) {
            return psychologist;
        } else {
            return null;
        }
    }

    public List<Psychologist> getAll(Set<Categories> categoriesSet){
        List<Psychologist>psychologists=psychologistRepository.getAll();
            if (!categoriesSet.isEmpty()){
                for (Psychologist p:psychologists
                     ) {
                    
                }
            }

        return psychologists;
    }

    public Psychologist get(Integer id){
        return psychologistRepository.get(id);
    }

    public void delete(Integer id){
        psychologistRepository.delete(id);
    }

    public String queryByLocation(String location){
        return switch  (location){
            case ("KYIV")-> "SELECT * FROM psychologist WHERE location='KYIV'";
            case ("LVIV")-> "SELECT * FROM psychologist WHERE location='LVIV'";
            case ("ODESSA")-> "SELECT * FROM psychologist WHERE location='ODESSA'";
            case ("DNIPRO")-> "SELECT * FROM psychologist WHERE location='DNIPRO'";
            default -> throw new IllegalStateException("Unexpected value: " + location);
        };
    }
}
