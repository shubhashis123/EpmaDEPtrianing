import java.lang.*;
import java.util.Scanner;

abstract class Employee{
    private double Salary;
    private String Designation, name;

    Employee(){ Salary = 0; Designation = "NA"; name = "NA";}

    Employee(double Salary, String Designation, String name){
        this.Salary = Salary;
        this.Designation = Designation;
        this.name = name;
    }
    Employee(double Salary, String Designation){
        this.Salary = Salary;
        this.Designation = Designation;
        this.name = "NA";
    }

    public String getName(){
        return this.name;
    }

    public void setName(String s){
        this.name = s;
    }

    public double getSalary(){
        return this.Salary;
    }

    public void setSalary(double num){
        this.Salary = num;
    }

    public String getDesignation(){
        return this.Designation;
    }

    public void setDesignation(String s){
        this.Designation = s;
    }
    abstract void JobDescription();
    abstract void applyHike();

    public void getDetails(){
        System.out.println("Name: " + name);
        System.out.println("Salary: " + Salary);
        System.out.println("Designation: " + Designation);
    }
}


class SWE extends Employee{
    String Project;
    public SWE(double Salary, String Designation, String name, String Project){
        super(Salary, Designation, name);
        this.Project = Project;
    }

    public void JobDescription(){
        System.out.println("DEVELOPS SOFTWARES");
    }

    public void applyHike(){
        double newVal = super.getSalary() * 1.25;
        setSalary(newVal);
    }

    @Override
    public void getDetails(){
        System.out.println("Name: " + super.getName());
        System.out.println("Salary: " + super.getSalary());
        System.out.println("Designation: " + super.getDesignation());
        System.out.println("Project: " + this.Project);
    }


}

class Manager extends Employee{
    String Team;
    public Manager(double Salary, String Designation, String name, String Team){
        super(Salary, Designation, name);
        this.Team = Team;
    }

    public void JobDescription(){
        System.out.println("Manages Teams");
    }

    public void applyHike(){
        double newVal = getSalary() * 1.5;
        setSalary(newVal);
    }

    @Override
    public void getDetails(){
        System.out.println("Name: " + getName());
        System.out.println("Salary: " + getSalary());
        System.out.println("Designation: " + getDesignation());
        System.out.println("Team: " + this.Team);
    }


}

class Company{
    SWE swe;
    Manager manager;

    static Company instance = null;

    private Company(SWE swe, Manager manager){
        this.swe = swe;
        this.manager = manager;
    }

    public static Company getInstance(){
        if( instance == null ){
            SWE s = new SWE(10000.0, "SWE", "Ramesh", "React Dev");
            Manager m = new Manager(20000.0, "MANAGER", "Suresh", "CICD");

            instance = new Company(s, m);
        }
        return instance;
    }

    public void getDetails(){
        swe.getDetails();
        System.out.println("\n");
        manager.getDetails();
    }
}


public class myClass {
    public static void main(String args[]){
        Company company = Company.getInstance();
        company.getDetails();
    }
}
