package tech.reliab.course.kutsenkomp.bank.entity;


public class PaymentAccount {
    private int id;
    private User user;
    private String bankName;
    private float money = 0;

    public PaymentAccount(int id, User user, String bankName, float money) {
        this.id = id;
        this.user = user;
        this.bankName = bankName;
        this.money = money;
    }

    public PaymentAccount(PaymentAccount paymentAccount) {
        this.id = paymentAccount.getId();
        this.user = paymentAccount.getUser();
        this.bankName = paymentAccount.getBankName();
        this.money = paymentAccount.getMoney();
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id=" + id +
                ", user=" + user +
                ", bankName='" + bankName + '\'' +
                ", money=" + money +
                '}' ;
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

}
