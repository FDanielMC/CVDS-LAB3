package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;
public class Registry {

    private ArrayList<Integer> persons;

    public Registry(){
        persons = new ArrayList<Integer>();
    }

    public RegisterResult registerVoter(Person p) {
        // TODO Validate person and return real result.
        RegisterResult registerVoter = RegisterResult.VALID;
        if(!isDuplicated(p) || persons.isEmpty()){
            if(p.isAlive()){
                if(p.getAge() >= 18 && p.getAge() <= 100){
                    registerVoter = registerVoter.VALID;
                    persons.add(p.getId());
                }
                else if(p.getAge() > 0 && p.getAge() < 18) registerVoter = RegisterResult.UNDERAGE;
                else registerVoter = RegisterResult.INVALID_AGE;
            }
            else registerVoter = RegisterResult.DEAD;
        }
        else registerVoter = RegisterResult.DUPLICATED;
        return registerVoter;
    }

    /***
    *
    *
     */
    private boolean isDuplicated(Person p){
        boolean flag = false;
        if(persons.isEmpty()) flag = false;
        else{
            for(int id: persons){
                if(id == p.getId()) flag = true;
            }
        }
        return flag;
    }


}