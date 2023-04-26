package org.example.N42840;


public class Main {
}

class Solution {

    public int[] solution(int[] answer) {
        Student stu1 = new Student(1, new int[]{1, 2, 3, 4, 5});
        Student stu2 = new Student(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        Student stu3 = new Student(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        int stu1Total = scoring(answer, stu1.getSubmit());
        int stu2Total = scoring(answer, stu2.getSubmit());
        int stu3Total = scoring(answer, stu3.getSubmit());

        ranking(stu1Total, stu2Total, stu3Total);

        return answer;
    }


    private int scoring(int[] answers, int[] submit) {
        int score = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == submit[i % submit.length]) {
                score++;
            }
        }
        return score;
    }

    private int[] ranking(int stu1Score, int stu2Score, int stu3Score) {
        int[] rank = new int[3];

        for (int i = 0; i < rank.length; i++) {

        }

        return rank;
    }


}

class Student {
    private final int studentNum;
    private final int[] submit;
    public Student(int studentNum, int[] submit) {
        this.studentNum = studentNum;
        this.submit = submit;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public int[] getSubmit() {
        return submit;
    }
}