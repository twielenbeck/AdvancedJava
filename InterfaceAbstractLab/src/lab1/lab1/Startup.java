package lab1;

public class Startup {
    public static void main(String [ ] args){
        lab1.IntroToProgrammingCourse course = new lab1.IntroToProgrammingCourse
                ("Intro to Programming", "53551", 3, "None");
        System.out.println(course.getCourseName() + " " + course.getCourseNumber() + " " + course.getPrerequisites() + " " + course.getCredits());

    }
}
