package com.stuff;


import com.google.gson.Gson;

import java.util.ArrayList;

public class ParseData {
    public ArrayList<String> parse(String response){
        ArrayList<String> movie = new ArrayList<String>();
        String json = null;
        Gson gson = new Gson();
        json = response;
        MyPojo myPojo = gson.fromJson(json, MyPojo.class);
        movie.add(myPojo.getTitle());
        movie.add(myPojo.getPlot());
        movie.add(myPojo.getPoster());
        return  movie;
    }
}
