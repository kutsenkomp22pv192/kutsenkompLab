package tech.reliab.course.kutsenkomp.bank.entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String fullName;
    private Date birthDate;
    private String workAddress;
    private float monthIncome;
    private List<Bank> banks = new ArrayList<>();
    private float rate;

    public User(int id, String fullName, Date birthDate,  String workAddress,
                float monthIncome, Bank bank) {
        bank.setCountClients(bank.getCountClients() + 1);
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.workAddress = workAddress;
        this.monthIncome = monthIncome;
        this.banks.add(bank);
        this.rate = monthIncome/10;
    }

    public User(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.birthDate = user.getBirthDate();
        this.workAddress = user.getWorkAddress();
        this.monthIncome = user.getMonthIncome();
        this.banks = user.getBanks();
        this.rate = user.getRate();
    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate='"+ new SimpleDateFormat("yyyy-MM-dd").format(birthDate.getTime())+
                ", workAddress=" + workAddress +
                ", monthIncome=" + monthIncome +
                ", bank=" + banks +
                ", rate=" + rate +
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

    public String getWorkAddress() {
        return this.workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public List<Bank> getBanks() {
        return this.banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    public float getMonthIncome() {
        return this.monthIncome;
    }

    public void setMonthIncome(float monthIncome) {
        this.monthIncome = monthIncome;
    }

    public float getRate() {
        return this.rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
