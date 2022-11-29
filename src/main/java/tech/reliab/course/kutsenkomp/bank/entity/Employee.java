package tech.reliab.course.kutsenkomp.bank.entity;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private int id;
    private String fullName;
    private Date birthDate;
    private String position;
    private Bank bank;
    private boolean worksInOffice;
    private BankOffice bankOffice;
    private boolean canGiveCredit;
    private float monthIncome;

    public Employee(int id, String fullName, Date birthDate,
                    String position, Bank bank, boolean worksInOffice,
                    BankOffice bankOffice, boolean canGiveCredit, float monthIncome) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.position = position;
        this.bankOffice = bankOffice;
        this.bank = bank;
        this.worksInOffice = worksInOffice;
        this.canGiveCredit = canGiveCredit;
        this.monthIncome = monthIncome;
    }

    public Employee(Employee employee) {
        this.id = employee.getId();
        this.fullName = employee.getFullName();
        this.birthDate = employee.getBirthDate();
        this.position = employee.getPosition();
        this.bankOffice = employee.getBankOffice();
        this.bank = employee.getBank();
        this.worksInOffice = employee.getWorksInOffice();
        this.canGiveCredit = employee.getCanGiveCredit();
        this.monthIncome = employee.getMonthIncome();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate='" + new SimpleDateFormat("yyyy-MM-dd").format(birthDate.getTime()) + '\''+
                ", position='" + position + '\'' +
                ", bank=" + bank +
                ", bankOffice=" + bankOffice +
                ", worksInOffice=" + worksInOffice +
                ", canGiveCredit=" + canGiveCredit +
                ", monthIncome=" + monthIncome +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Bank getBank() {
        return this.bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankOffice getBankOffice() {
        return this.bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean getWorksInOffice() {
        return this.worksInOffice;
    }

    public void setWorksInOffice(boolean worksInOffice) {
        this.worksInOffice = worksInOffice;
    }

    public float getMonthIncome() {
        return this.monthIncome;
    }

    public void setMonthIncome(float monthIncome) {
        this.monthIncome = monthIncome;
    }

    public boolean getCanGiveCredit() {
        return this.canGiveCredit;
    }

    public void setCanGiveCredit(boolean canGiveCredit) {
        this.canGiveCredit = canGiveCredit;
    }

}
