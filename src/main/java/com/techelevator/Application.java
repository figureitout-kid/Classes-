package com.techelevator;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    /**
     * The main entry point in the application
     * @param args
     */
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private Map<String, Project> projects = new HashMap<>();
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
    private void createDepartments() {
        Department Marketing = new Department(1, "Marketing");
        Department Sales = new Department(2, "Sales");
        Department Engineering = new Department(3, "Engineering");

        departments.add(Marketing);
        departments.add(Sales);
        departments.add(Engineering);


    }

    /**
     * Print out each department in the collection.
     */
    private void printDepartments() {
        System.out.println("------------- DEPARTMENTS ------------------------------");
        for(Department department : departments){ System.out.println(department.getName());}

    }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        Employee DeanJohnson = new Employee();
        DeanJohnson.setEmployeeId(1);
        DeanJohnson.setFirstName("Dean");
        DeanJohnson.setLastName("Johnson");
        DeanJohnson.setEmail("djohnson@teams.com");
        DeanJohnson.setSalary(60000);
        DeanJohnson.setDepartment(departments.get(2));
        DeanJohnson.setHireDate("08/21/2020");

        Employee AngieSmith = new Employee(2L,"Angie", "Smith", "asmith@teams.com", departments.get(2),"08/21/2020");
        Employee MargaretThompson = new Employee(3L,"Margaret", "Thompson", "mthompson@teams.com", departments.get(0),"08/21/2020");
        AngieSmith.raiseSalary(10);

        employees.add(DeanJohnson);
        employees.add(AngieSmith);
        employees.add(MargaretThompson);
    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        System.out.println("\n------------- EMPLOYEES ------------------------------");
        for (Employee employee : employees) {
            System.out.println(employee.getFullName() + " " + String.valueOf(employee.getSalary()) + " " + (employee.getDepartment().getName()));

        }
    }
    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        Project TEams = new Project("TEams", "Project Management Software", "10/10/2020", "11/10/2020" );

        for (Employee employee : employees) {
            if(employee.getDepartment().getDepartmentId() == 3){
               TEams.teamMembers.add(employee);
            }
        }
        projects.put("TEams", TEams);
    }

    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project MarketingLandingPage = new Project("Marketing Landing Page", "Lead Capture Landing Page for Marketing", "10/10/2020", "10/17/2020" );
        for (Employee employee : employees){
            if(employee.getDepartment().getDepartmentId() == 1){
                MarketingLandingPage.teamMembers.add(employee);
            }
        }
        projects.put("Marketing Landing Page", MarketingLandingPage);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for(Map.Entry<String, Project> project : projects.entrySet()){
            System.out.println(project.getKey() + ": " + project.getValue().teamMembers.size());
        }

        }
    }


