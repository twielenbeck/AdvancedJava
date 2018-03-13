package lab2;

public class Startup {
    public static void main(String [ ] args){
        lab2.IntroToProgrammingCourse course = new lab2.IntroToProgrammingCourse
                ("Intro to Programming", "53551", 3, "None");
        lab2.IntroJavaCourse java = new lab2.IntroJavaCourse
                ("Intro to Java", "53552", 3, "Intro to programming");
        lab2.AdvancedJavaCourse advJava = new lab2.AdvancedJavaCourse
                ("Advanced Java", "53553", 4, "Intro to programming, Intro to Java");
        System.out.println(course.getCourseName() + " | " + course.getCourseNumber() + " | " + course.getCredits());
        System.out.println(java.getCourseName() + " | " + java.getCourseNumber() + " | " + java.getCredits());
        System.out.println(advJava.getCourseName() + " | " + advJava.getCourseNumber() + " | " + advJava.getCredits());
    }
}
