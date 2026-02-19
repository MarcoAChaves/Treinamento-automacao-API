package com.api.utils;

import java.util.ArrayList;
import java.util.List;

public class EvidenceLogger {

    private static final List<Step> steps = new ArrayList<>();

    public static void log(String name) {
        Step step = new Step();
        step.name = name;
        step.status = "INFO";
        steps.add(step);
    }

    public static void addStep(String name, String status, String body) {
        Step step = new Step();
        step.name = name;
        step.status = status;
        step.body = body;
        steps.add(step);
    }

    public static List<Step> get() {
        return steps;
    }

    public static void clear() {
        steps.clear();
    }

    public static class Step {
        public String name;
        public String status;
        public String body;
    }
}
