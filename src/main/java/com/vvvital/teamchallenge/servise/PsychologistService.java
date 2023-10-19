package com.vvvital.teamchallenge.servise;

import com.vvvital.teamchallenge.entity.Categories;
import com.vvvital.teamchallenge.entity.Location;
import com.vvvital.teamchallenge.entity.Psychologist;
import com.vvvital.teamchallenge.entity.PsychologistToSend;
import com.vvvital.teamchallenge.repository.jdbc.PsychologistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PsychologistService {
    Logger logger = LoggerFactory.getLogger(PsychologistService.class);
    private final PsychologistRepository psychologistRepository;

    @Autowired
    public PsychologistService(PsychologistRepository psychologistRepository) {
        this.psychologistRepository = psychologistRepository;
    }

    public Psychologist create(Psychologist psychologist) {
        return psychologistRepository.create(psychologist);
    }

    public PsychologistToSend update(Psychologist psychologist){
        return DataAccessUtils.singleResult(psychologistToSends(psychologistRepository.update(psychologist)));
    }

    public Psychologist login(String email, String password) {
        Psychologist psychologist = psychologistRepository.getEmail(email);
        if (psychologist.getPassword().equals(password)) {
            return psychologist;
        } else {
            return null;
        }
    }

    public List<PsychologistToSend> getAll(Set<Categories> categoriesSet, Location location, Integer priceMin, Integer priceMax,
                                           Integer experienceMin, Integer experienceMax,Integer ratingMin, Integer ratingMax,String order) {
        List<Psychologist> psychologists = psychologistRepository.getAll();
        List<Psychologist> psychologistList = new ArrayList<>();
        //psychologistList = selectByExperience(experienceMin, experienceMax, selectByPrice(priceMin, priceMax, selectByLocation(location, selerctByCategories(categoriesSet, psychologists))));
        psychologistList = selerctByCategories(categoriesSet, psychologists);
        psychologistList = selectByLocation(location, psychologistList);
        psychologistList = selectByPrice(priceMin, priceMax, psychologistList);
        psychologistList = selectByExperience(experienceMin, experienceMax, psychologistList);
        psychologistList= selectByRating(ratingMin,ratingMax,psychologistList);
        if (order!=null&&order.equals("price")) {
            psychologistList.sort(Comparator.comparing(Psychologist::getPrice));
        }else if (order!=null&&order.equals("rating")){
            psychologistList.sort(Comparator.comparing(Psychologist::getRating));
        }else {
            psychologistList.sort(Comparator.comparing(Psychologist::getId));
        }
        return psychologistToSends(psychologistList);
    }

    public PsychologistToSend get(Integer id) {
        return DataAccessUtils.singleResult(psychologistToSends(psychologistRepository.get(id)));
    }

    public void delete(Integer id) {
        psychologistRepository.delete(id);
    }

    public List<Psychologist> selerctByCategories(Set<Categories> categories, List<Psychologist> psychologists) {
        List<Psychologist> psychologistList = new ArrayList<>();
        if (!categories.isEmpty()) {
            for (Psychologist p : psychologists
            ) {
                if (categories.stream().anyMatch(cat1 -> p.getCategories().stream().anyMatch(cat1::equals))) {
                    psychologistList.add(p);
                }
            }
            return psychologistList;
        }
        return psychologists;
    }

    public List<Psychologist> selectByLocation(Location location, List<Psychologist> psychologists) {
        logger.info("************* select by location {}",location);
        List<Psychologist> psychologistList = new ArrayList<>();
        if (location != null) {
            for (Psychologist p : psychologists
            ) {
                if (p.getLocation() == location) {
                    psychologistList.add(p);
                }
            }
            return psychologistList;
        }
        return psychologists;
    }

    public List<Psychologist> selectByPrice(Integer priceMin, Integer priceMax, List<Psychologist> psychologists) {
        List<Psychologist> psychologistList = new ArrayList<>();
        if (priceMin == null) priceMin = 0;
        if (priceMax == null) priceMax = 99999999;
        if (priceMin != 0 || priceMax != 0) {
            for (Psychologist p : psychologists
            ) {
                if (p.getPrice() >= priceMin && p.getPrice() <= priceMax) {
                    psychologistList.add(p);
                }
            }
            return psychologistList;
        }
        return psychologists;
    }

    public List<Psychologist> selectByExperience(Integer experienceMin, Integer experienceMax, List<Psychologist> psychologists) {
        logger.info("**************experienceMin = {}, experienceMax = {}", experienceMin, experienceMax);
        if (experienceMin == null) experienceMin = 0;
        if (experienceMax == null) experienceMax = 100;
        List<Psychologist> psychologistList = new ArrayList<>();
        if (experienceMin != 0 || experienceMax != 0) {
            for (Psychologist p : psychologists
            ) {
                if (p.getExperience() >= experienceMin && p.getExperience() <= experienceMax) {
                    psychologistList.add(p);
                }
            }
            return psychologistList;
        }
        return psychologists;
    }

    public List<Psychologist> selectByRating(Integer ratingMin, Integer ratingMax, List<Psychologist> psychologists) {
        logger.info("**************ratingMin = {}, ratingMax = {}", ratingMin, ratingMax);
        if (ratingMin == null) ratingMin = 0;
        if (ratingMax == null) ratingMax = 100;
        List<Psychologist> psychologistList = new ArrayList<>();
        if (ratingMin != 0 || ratingMax != 0) {
            for (Psychologist p : psychologists
            ) {
                if (p.getExperience() >= ratingMin && p.getExperience() <= ratingMax) {
                    psychologistList.add(p);
                }
            }
            return psychologistList;
        }
        return psychologists;
    }

    public List<PsychologistToSend> psychologistToSends(List<Psychologist> psychologists) {
        List<PsychologistToSend> psychologistToSendList = new ArrayList<>();
        if (!psychologists.isEmpty()) {
            for (Psychologist p : psychologists
            ) {
                psychologistToSendList.add(new PsychologistToSend(p.getId(), p.getName(), p.getSurName(), p.getEmail(), p.getPhone(),
                        p.getPrice(), p.getLocation().toString(), p.getExperience(), p.getRating(), p.getDescription(), p.getPhotoLink(), p.getCategories()));
            }
            return psychologistToSendList;
        }
        return null;
    }
}
