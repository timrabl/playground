package com.timrabl;

import java.util.ArrayList;
import java.util.Locale;

public class GradeProcessor {
    ArrayList<Integer> gradeList = new ArrayList<>();
    String gradeMode = "plain";

    GradeProcessor() {}

    GradeProcessor(ArrayList<Integer> gradeList) {
        this.setGradelist(gradeList);
    }

    // grade section //

    public void addGrade(int grade) throws InvalidGrade {
        if ( (grade > 6 ) ) {
            throw new InvalidGrade(grade);
        }

        if ( grade <= 0 ) {
            throw new InvalidGrade(grade);
        }

        if ( this.getGradeMode().toLowerCase(Locale.ROOT).equals("plain") ) {
            this.addPlain(grade);
        }

        if ( this.getGradeMode().toLowerCase(Locale.ROOT).equals("half") ) {
            this.addHalf(grade);
        }
    }

    private void addPlain(int grade) {
        this.gradeList.add( grade );
    }

    private void addHalf(int grade) {
        this.gradeList.add( grade / 2 );
    }

    // gradeMode section //

    boolean changeGradeMode(String mode) {
        if ( mode.toLowerCase(Locale.ROOT).equals("s") ) {
            this.setGradeMode("plain");
            return true;
        }

        if ( mode.toLowerCase(Locale.ROOT).equals("e") ) {
            this.setGradeMode("half");
            return true;
        }

        if ( mode.toLowerCase(Locale.ROOT).equals("x") ) {
            this.setGradeMode("exit");
            return true;
        }

        return false;
    }

    private void setGradeMode(String mode) {
        this.gradeMode = mode;
    }

    public String getGradeMode() {
        return this.gradeMode;
    }

    // gradeList section //

    public ArrayList<Integer> getGradeList() {
        return this.gradeList;
    }

    private void setGradelist(ArrayList<Integer> gradelist) {
        this.gradeList = gradelist;
    }

    public float getGradeListAverage() {
        int summary = 0;
        ArrayList<Integer> gradeList = this.getGradeList();

        if ( !(gradeList.isEmpty()) ) {
            for (int grade : gradeList) {
                summary += grade;
            }
            return (float)summary / gradeList.size();
        }
        return (float)summary;
    }

    // gradeFunction //

    public ArrayList<Integer> getMissingGradesToLower() {

        ArrayList<Integer> missingGrades = new ArrayList<Integer>();

        GradeProcessor processor = new GradeProcessor(this.gradeList);
        processor.changeGradeMode("half");

        while (true) {

            float avg = processor.getGradeListAverage();
            int lower = (int) Math.floor(avg);
            float min = (float) (lower + 0.4);

            if ( avg <= min ) {
               return missingGrades;
            }

            try {
                processor.addGrade(lower);
                missingGrades.add(lower);
            } catch (InvalidGrade invalidGrade) {
                invalidGrade.printStackTrace();
            }
        }
    }
}
