package tech.reliab.course.kutsenkomp.bank.entity;

public class Bank {

    private int id;
    private String name;
    private int countOffices = 0;
    private int countAtm = 0;
    private int countEmployees = 0;
    private int countClients = 0;
    private int rate;
    private float money;
    private float interestRate;

    public Bank(int id, String name, int countOffices, int countAtm, int countEmployees, int countClients, int rate, float money, float interestRate) {
        this.id = id;
        this.name = name;
        this.countOffices = countOffices;
        this.countAtm = countAtm;
        this.countEmployees = countEmployees;
        this.countClients = countClients;
        this.rate = rate;
        this.money = money;
        this.interestRate = interestRate;
    }

    public Bank(Bank bank) {
        this.id = bank.getId();
        this.name = bank.getName();
        this.countOffices = bank.getCountOffices();
        this.countAtm = bank.getCountAtm();
        this.countEmployees = bank.getCountEmployees();
        this.countClients = bank.getCountClients();
        this.rate = bank.getRate();
        this.money = bank.getMoney();
        this.interestRate = bank.getInterestRate();
    }


    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countOffices=" + countOffices +
                ", countAtm=" + countAtm +
                ", countEmployees=" + countEmployees +
                ", countClients=" + countClients +
                ", rate=" + rate +
                ", money=" + money +
                ", interestRate=" + interestRate + "%}";
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOffices() {
        return this.countOffices;
    }

    public void setCountOffices(int countOffices) {
        this.countOffices = countOffices;
    }

    public int getCountEmployees() {
        return this.countEmployees;
    }

    public void setCountEmployees(int countEmployees) {
        this.countEmployees = countEmployees;
    }

    public int getCountAtm() {
        return this.countAtm;
    }

    public void setCountAtm(int countAtm) {
        this.countAtm = countAtm;
    }

    public int getCountClients() {
        return this.countClients;
    }

    public void setCountClients(int countClients) {
        this.countClients = countClients;
    }

    public int getRate() {
        return this.rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public float getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public float getMoney() {
        return this.money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

}

