package com.team4.model;
import jakarta.persistence.Entity;

@Entity
public class Wild extends Card {
    
    public Wild() {
        super("", "wild");
    }

    @Override
    public String toString() {
        String result = "Wild";
        if(super.getColor() != "") {
            result = super.toString() + " Wild";
        }
        return result;
    }
}
