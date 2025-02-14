package aIdrivenresumescreeningsystem;

import java.util.*;

// Abstract JobRole Class
abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public abstract String requiredSkills();
}

// Specific Job Roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public String requiredSkills() {
        return "Skills: Java, Python, Data Structures, Algorithms.";
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public String requiredSkills() {
        return "Skills: Machine Learning, Python, Statistics, Data Analysis.";
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public String requiredSkills() {
        return "Skills: Business Strategy, Market Research, Team Management.";
    }
}

// Generic Resume Class
class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public void displayResume() {
        System.out.println("Candidate: " + candidateName);
        System.out.println("Applying for: " + jobRole.getRoleName());
        System.out.println(jobRole.requiredSkills());
        System.out.println();
    }
}

// Resume Screening Utility Class
class ResumeScreeningSystem {
    public static void processResumes(List<? extends JobRole> jobRoles) {
        System.out.println("Processing Resumes for Multiple Job Roles...");
        for (JobRole role : jobRoles) {
            System.out.println("Screening for: " + role.getRoleName());
            System.out.println(role.requiredSkills());
            System.out.println();
        }
    }
}

// Main Class
public class ResumeScreening {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResume = new Resume<>("Alice Johnson", new SoftwareEngineer());
        Resume<DataScientist> dsResume = new Resume<>("Bob Smith", new DataScientist());
        Resume<ProductManager> pmResume = new Resume<>("Charlie Davis", new ProductManager());

        System.out.println("Individual Resume Screening:");
        seResume.displayResume();
        dsResume.displayResume();
        pmResume.displayResume();

        // Using wildcard method to process resumes dynamically
        List<JobRole> jobRoles = Arrays.asList(new SoftwareEngineer(), new DataScientist(), new ProductManager());

        System.out.println("Batch Resume Processing:");
        ResumeScreeningSystem.processResumes(jobRoles);
    }
}

