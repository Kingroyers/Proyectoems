/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author EDER
 */
public class Nomina {
    
    private String name;
    private int iden;
    private String job;
    private int salary;
    private int commissions;
    private int bonuses;
    private int total;

    public Nomina() {
    }

    public Nomina(String name, int iden, String job, int salary, int commissions, int bonuses, int total) {
        this.name = name;
        this.iden = iden;
        this.job = job;
        this.salary = salary;
        this.commissions = commissions;
        this.bonuses = bonuses;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIden() {
        return iden;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommissions() {
        return commissions;
    }

    public void setCommissions(int commissions) {
        this.commissions = commissions;
    }

    public int getBonuses() {
        return bonuses;
    }

    public void setBonuses(int bonuses) {
        this.bonuses = bonuses;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
}
