package com.api.utils;

import java.io.FileWriter;
import java.time.LocalDateTime;

public class ReportManager {

    public static void generate(String testName){

        try{
            String file = "report_" + testName + ".html";
            FileWriter writer = new FileWriter(file);

            writer.write("<h1>Relatório</h1>");
            writer.write("<p>Teste: "+testName+"</p>");
            writer.write("<p>Data: "+ LocalDateTime.now()+"</p>");

            for(EvidenceLogger.Step s : EvidenceLogger.get()){
                writer.write("<hr>");
                writer.write("<b>"+s.name+"</b><br>");
                writer.write("Status: "+s.status+"<br>");
                writer.write("<pre>"+s.body+"</pre>");
            }

            writer.close();
            EvidenceLogger.clear();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void addLog(String text) {
    }
}
