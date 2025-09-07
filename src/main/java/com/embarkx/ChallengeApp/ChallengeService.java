package com.embarkx.ChallengeApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
    //private List<Challenge> challenges = new ArrayList<>();
    private Long nextId = 1L;

    @Autowired
    ChallengeRepository challengeRepository;

//    public ChallengeService(){
//        Challenge challenge1 = new Challenge(1L,"January","Learn Spring");
//        challenges.add(challenge1);
//    }

    //public List<Challenge> getAllChallenges(){
    //return challenges;}

    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }
    // ERROR FIX 1: Removed extra closing brace "}" here - it was closing the class too early
    // Original had: } after getAllChallenges() which made all methods below outside the class

    public Boolean addChallenge(Challenge challenge){
        if(challenge!=null) {
            challenge.setId(nextId++);
            //challenges.add(challenge);
            challengeRepository.save(challenge);
            return true;
        }else{
            return false;
        }
    }

    public Challenge getChallenges(String month) {
        Optional<Challenge> challenge= challengeRepository.findByMonthIgnoreCase(month);
//        for(Challenge challenge: challenges){
//            if(challenge.getMonth().equalsIgnoreCase(month)){
//                return challenge;
//            }
//        }
//        return null;
        return challenge.orElse(null);
    }

    public boolean updateChallenge(Long id, Challenge updatedChallenge) {
        Optional<Challenge> challengeOptional = challengeRepository.findById(id);
        if(challengeOptional.isPresent()) {
            Challenge challengeToUpdate = challengeOptional.get();
            challengeToUpdate.setMonth(updatedChallenge.getMonth());
            challengeToUpdate.setDescription(updatedChallenge.getDescription());
            challengeRepository.save(challengeToUpdate);
            return true;
        }
        return false; // ERROR FIX 2: Added missing return statement - method must return boolean in all cases

//    for(Challenge challenge: challenges){
//            if(challenge.getId()==id) {
//                challenge.setMonth(updatedChallenge.getMonth());
//                challenge.setDescription(updatedChallenge.getDescription());
//                return true;
//            }
//        }
//        return false;
    }

    public boolean deleteChallenge(Long id) {
        //return challenges.removeIf(challenge -> challenge.getId() == id);
        Optional<Challenge> challenge= challengeRepository.findById(id);
        if(challenge.isPresent()) {
            challengeRepository.deleteById(id);
            return true;
        }
        return false; // ERROR FIX 3: Added proper spacing/newline - original had "}return false;" without space
    }
} // ERROR FIX 4: Ensured proper class closing brace is present