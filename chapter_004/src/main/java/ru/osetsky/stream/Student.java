package ru.osetsky.stream;

public class Student {
    private int score;
    private String surname;

    public Student(String surname, int score){
        this.surname = surname;
        this.score = score;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
