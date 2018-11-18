package ohtu;

public class Submission {
    private int week;
    private int hours;
    private int[] exercises;
    private String course;

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }

    public String getExercises() {
        String ex = "";
        for(int e : exercises){
            ex = ex + e + ", ";
        }
        ex.substring(0, ex.length()-1);

        return ex;
    }

    public int getMaara(){
        return exercises.length;
    }

    public int getMaksimi(int x){
        return exercises[x];
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    public String getCourse() {
        return course;
    }

    

    
    @Override
    public String toString() {
        return ""+week+""+hours;
    }
    
}