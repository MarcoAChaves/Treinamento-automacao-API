package com.api.utils;

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

    public static void log(String text){
        System.out.println(text);
        ReportManager.addLog(text);
    }

    public static List<Step> get(){
        return steps;
    }

    public static void clear(){
        steps.clear();
    }
}

