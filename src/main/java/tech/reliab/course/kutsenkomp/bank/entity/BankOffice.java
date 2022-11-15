package tech.reliab.course.kutsenkomp.bank.entity;


public class BankOffice {

    private Bank bank;
    private int id;
    private String name;
    private String address;
    private String status;
    private boolean canGiveMoney;
    private boolean canInputMoney;
    private boolean canReplaceAtm;
    private int countAtm;
    private boolean canGiveCredit;
    private float money;
    protected float monthCost;

    public BankOffice(Bank bank, int id, String name, String address,
                      String status, boolean canGiveMoney,  boolean canInputMoney,
                      boolean canReplaceAtm, int countAtm,
                      boolean canGiveCredit, float money, float monthCost) {
        bank.setCountOffices(bank.getCountOffices() + 1);
        this.bank = bank;
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.canGiveMoney = canGiveMoney;
        this.canInputMoney = canInputMoney;
        this.canReplaceAtm = canReplaceAtm;
        this.countAtm = countAtm;
        this.canGiveCredit = canGiveCredit;
        this.money = money;
        this.monthCost = monthCost;
    }

    public BankOffice(BankOffice bankOffice) {
        this.bank = bankOffice.getBank();
        this.id = bankOffice.getId();
        this.name = bankOffice.getName();
        this.address = bankOffice.getAddress();
        this.status = bankOffice.getStatus();
        this.canGiveMoney = bankOffice.getCanInputMoney();
        this.canInputMoney = bankOffice.getCanInputMoney();
        this.canReplaceAtm = bankOffice.getCanReplaceAtm();
        this.countAtm = bankOffice.getCountAtm();
        this.canGiveCredit = bankOffice.getCanGiveCredit();
        this.money = bankOffice.getMoney();
        this.monthCost = bankOffice.getMonthCost();
    }


    @Override
    public String toString() {
        return "BankOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", bank=" + bank +
                ", status=" + status +
                ", canGiveMoney=" + canGiveMoney +
                ", canInputMoney=" + canInputMoney +
                ", canReplaceAtm=" + canReplaceAtm +
                ", countAtm=" + countAtm +
                ", canGiveCredit=" + canGiveCredit +
                ", money=" + money +
                ", monthCost=" + monthCost +
                '}';
    }

    public Bank getBank() {
        return this.bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getCanGiveMoney() {
        return this.canGiveMoney;
    }

    public void setCanGiveMoney(boolean canGiveMoney) {
        this.canGiveMoney = canGiveMoney;
    }

    public boolean getCanInputMoney() {
        return this.canInputMoney;
    }

    public void setCanInputMoney(boolean canInputMoney) {
        this.canInputMoney = canInputMoney;
    }

    public boolean getCanReplaceAtm() {
        return this.canReplaceAtm;
    }

    public void setCanReplaceAtm(boolean canReplaceAtm) {
        this.canReplaceAtm = canReplaceAtm;
    }

    public int getCountAtm() {
        return this.countAtm;
    }

    public void setCountAtm(int countAtm) {
        this.countAtm = countAtm;
    }

    public boolean getCanGiveCredit() {
        return this.canGiveCredit;
    }

    public void setCanGiveCredit(boolean canGiveCredit) {
        this.canGiveCredit = canGiveCredit;
    }

    public float getMoney() {
        return this.money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public float getMonthCost() {
        return this.monthCost;
    }

    public void setMonthCost(float monthCost) {
        this.monthCost = monthCost;
    }

}




