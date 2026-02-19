package com.api.utils;

import com.api.utils.EvidenceLogger.Step;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportGenerator {

    public static void gerar(String testName, List<Step> steps) {

        try {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String path = "reports/pdf/" + testName + "_" + timestamp + ".pdf";

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();

            // ===== TÍTULO =====
            Font titulo = new Font(Font.HELVETICA, 20, Font.BOLD);
            Paragraph title = new Paragraph("Relatório de Evidência", titulo);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("\n"));

            document.add(new Paragraph("Teste: " + testName));
            document.add(new Paragraph("Data: " + LocalDateTime.now()));
            document.add(new Paragraph("\n--------------------------------------------------\n"));

            // ===== STEPS =====
            for (Step step : steps) {

                Font stepFont = new Font(Font.HELVETICA, 14, Font.BOLD);
                document.add(new Paragraph("Step: " + step.name, stepFont));

                // cor baseada no status
                Font statusFont;
                if ("FAIL".equalsIgnoreCase(step.status))
                    statusFont = new Font(Font.HELVETICA, 12, Font.BOLD, Color.RED);
                else if ("PASS".equalsIgnoreCase(step.status))
                    statusFont = new Font(Font.HELVETICA, 12, Font.BOLD, Color.GREEN);
                else
                    statusFont = new Font(Font.HELVETICA, 12, Font.NORMAL, Color.BLUE);

                document.add(new Paragraph("Status: " + step.status, statusFont));

                // só mostra body se existir
                if (step.body != null && !step.body.isBlank()) {
                    document.add(new Paragraph("Body:", new Font(Font.HELVETICA, 12, Font.BOLD)));
                    document.add(new Paragraph(step.body));
                }

                document.add(new Paragraph("\n---------------------------------------------\n"));
            }

            document.close();

            System.out.println("PDF gerado em: " + path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generate(String displayName) {
    }
}
