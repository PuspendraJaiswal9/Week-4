package coursemanagementsystem;

import java.util.Arrays;
import java.util.List;

// Abstract CourseType Class
abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public abstract String getEvaluationMethod();
}

// Specific Course Types
class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getEvaluationMethod() {
        return "Exam-Based Evaluation";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based Evaluation";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }

    @Override
    public String getEvaluationMethod() {
        return "Research-Based Evaluation";
    }
}

// Generic Course Class
class Course<T extends CourseType> {
    private T courseType;
    private String department;

    public Course(T courseType, String department) {
        this.courseType = courseType;
        this.department = department;
    }

    public T getCourseType() {
        return courseType;
    }

    public String getDepartment() {
        return department;
    }

    public void displayCourseInfo() {
        System.out.println("Department: " + department);
        System.out.println("Course: " + courseType.getCourseName());
        System.out.println("Evaluation Method: " + courseType.getEvaluationMethod());
        System.out.println();
    }
}

// Utility Class for Handling Courses Dynamically
class UniversityUtil {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println("Course: " + course.getCourseName() + " | Evaluation: " + course.getEvaluationMethod());
        }
    }
}

// Main Class
public class UniversityManagement {
    public static void main(String[] args) {
        Course<ExamCourse> csExam = new Course<>(new ExamCourse("Data Structures"), "Computer Science");
        Course<AssignmentCourse> mathAssignment = new Course<>(new AssignmentCourse("Calculus"), "Mathematics");
        Course<ResearchCourse> physicsResearch = new Course<>(new ResearchCourse("Quantum Physics"), "Physics");

        System.out.println("Individual Course Details:");
        csExam.displayCourseInfo();
        mathAssignment.displayCourseInfo();
        physicsResearch.displayCourseInfo();

        // Using wildcard to display all courses dynamically
        List<CourseType> allCourses = Arrays.asList(
                new ExamCourse("Operating Systems"),
                new AssignmentCourse("Linear Algebra"),
                new ResearchCourse("Artificial Intelligence")
        );

        System.out.println("All Available Courses:");
        UniversityUtil.displayAllCourses(allCourses);
    }
}

