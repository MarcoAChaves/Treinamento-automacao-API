package com.API.utils;

import java.util.ArrayList;
import java.util.List;

public class EvidenceLogger {

    public static class Step{
        public String name;
        public int status;
        public String body;

        public Step(String name, int status, String body){
            this.name=name;
            this.status=status;
            this.body=body;
        }
    }

    private static List<Step> steps = new ArrayList<>();

    public static void log(String name, int status, String body){
        steps.add(new Step(name,status,body));
    }

    public static List<Step> get(){
        return steps;
    }

    public static void clear(){
        steps.clear();
    }
}

