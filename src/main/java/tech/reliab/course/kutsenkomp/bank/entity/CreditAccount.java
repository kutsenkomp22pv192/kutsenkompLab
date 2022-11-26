package tech.reliab.course.kutsenkomp.bank.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
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
                         Date dataStart, int countMonth,
                         float interestRate, Employee employee, PaymentAccount paymentAccount) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.money = money;
        this.dataStart = dataStart;
        Calendar c = Calendar.getInstance();
        c.setTime(dataStart);
        c.add(Calendar.MONTH, countMonth);
        this.dataEnd = c.getTime();
        this.countMonth = countMonth;
        this.monthPayment = (money + money * interestRate)/countMonth;
        this.interestRate = interestRate;
        this.employee = employee;
        this.paymentAccount = paymentAccount;
    }

    public CreditAccount(CreditAccount creditAccount) {
        this.id = creditAccount.getId();
        this.user = creditAccount.getUser();
        this.bankName = creditAccount.getBankName();
        this.money = creditAccount.getMoney();
        this.dataStart = creditAccount.getDataStart();
        this.dataEnd = creditAccount.getDataEnd();
        this.countMonth = creditAccount.getCountMonth();
        this.monthPayment = creditAccount.getMonthPayment();
        this.interestRate = creditAccount.getInterestRate();
        this.employee = creditAccount.getEmployee();
        this.paymentAccount = creditAccount.getPaymentAccount();
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id=" + id +
                ", user=" + user +
                ", bankName='" + bankName + '\'' +
                ", money=" + money +
                ", dataStart=" + new SimpleDateFormat("yyyy-MM-dd").format(dataStart.getTime()) +
                ", dataEnd=" + new SimpleDateFormat("yyyy-MM-dd").format(dataEnd.getTime()) +
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
