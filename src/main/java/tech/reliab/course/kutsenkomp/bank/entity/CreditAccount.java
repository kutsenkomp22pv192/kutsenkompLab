package tech.reliab.course.kutsenkomp.bank.entity;

import java.util.Date;

public class CreditAccount  {
    private int id;
    private User user;
    private String bankName;
    float money;
    private Date dataStart;
    private Date dataEnd;
    private int countMonth;
    private float monthPayment;
    private float interestRate;
    private Employee employee;
    private PaymentAccount paymentAccount;

    public CreditAccount(int id, User user, String bankName, float money,
                         Date dataStart, Date dataEnd, int countMonth, float monthPayment,
                         float interestRate, Employee employee, PaymentAccount paymentAccount) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.money = money;
        this.dataStart = dataStart;
        this.dataEnd = dataEnd;
        this.countMonth = countMonth;
        this.monthPayment = monthPayment;
        this.interestRate = interestRate;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }

    public CreditAccount(CreditAccount creditAccount) {
        this.id = getId();
        this.user = getUser();
        this.bankName = getBankName();
        this.money = getMoney();
        this.dataStart = getDataStart();
        this.dataEnd = getDataEnd();
        this.countMonth = getCountMonth();
        this.monthPayment = getMonthPayment();
        this.interestRate = getInterestRate();
        this.employee = getEmployee();
        this.paymentAccount = getPaymentAccount();
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id=" + id +
                ", user=" + user +
                ", bankName='" + bankName + '\'' +
                ", money=" + money +
                ", dataStart=" + dataStart +
                ", dataEnd=" + dataEnd +
                ", countMonth=" + countMonth +
                ", monthPayment=" + monthPayment +
                ", interestRate=" + interestRate +
                "%, employee=" + employee +
                ", paymentAccount=" + paymentAccount +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public float getMoney() {
        return this.money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Date getDataStart() {
        return this.dataStart;
    }

    public void setDataStart(Date dataStart) {
        this.dataStart = dataStart;
    }

    public Date getDataEnd() {
        return this.dataEnd;
    }

    public void setDataEnd(Date dataEnd) {
        this.dataEnd = dataEnd;
    }

    public int getCountMonth() {
        return this.countMonth;
    }

    public void setCountMonth(int countMonth) {
        this.countMonth = countMonth;
    }

    public float getMonthPayment() {
        return this.monthPayment;
    }

    public void setMonthPayment(float monthPayment) {
        this.monthPayment = monthPayment;
    }

    public PaymentAccount getPaymentAccount() {
        return this.paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public float getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }
}
