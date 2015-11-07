/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.object;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author 31240550
 */
public class JSONParser {
    
    public static List<Dog> parse(String content) {
        List<Dog> dogs = new ArrayList<>();
        
        JsonReader jsonrd = Json.createReader(new StringReader(content));
        JsonObject jsonobj = jsonrd.readObject();
        jsonrd.close();
        
        JsonArray dogs2 = jsonobj.getJsonArray("pets");
        
        for (int i = 0; i < dogs2.size(); i++) {
            JsonObject d = dogs2.getJsonObject(i);
            
            String photo = d.getString("photo");
            String name = d.getString("name");
            String age = d.getString("age");
            String race = d.getString("race");
            String city = d.getString("city");
            String desc = d.getString("description");
            
            JsonObject state = d.getJsonObject("state");
            String stname = state.getString("name");
            String stinitials = state.getString("initials");
            
            JsonObject country = d.getJsonObject("country");
            String ctname = country.getString("name");
            String ctinitials = country.getString("initials");
            
            State st = new State(stname, stinitials);
            Country ct = new Country(ctname, ctinitials);
            
            Dog dog = new Dog(photo, name, age, race, ct, st, city, desc);
            dogs.add(dog);
        }
        return dogs;
    }
}
