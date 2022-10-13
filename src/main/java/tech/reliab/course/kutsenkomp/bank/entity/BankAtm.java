package tech.reliab.course.kutsenkomp.bank.entity;


public class BankAtm  {
    private int id;
    private String name;
    private String address;
    private String status;
    private Bank bank;
    private BankOffice bankOffice;
    private Employee employee;
    private Boolean canGiveMoney;
    private boolean canInputMoney;
    private float money;
    protected float monthCost;

    public BankAtm(int id, String name, String address,
                      String status, Bank bank, BankOffice bankOffice,
                      Employee employee, boolean canGiveMoney,  boolean canInputMoney,
                      float money, float monthCost) {
        this.bank = bank;
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.canGiveMoney = canGiveMoney;
        this.canInputMoney = canInputMoney;
        this.bankOffice = bankOffice;
        this.employee = employee;
        this.money = money;
        this.monthCost = monthCost;
    }

    public BankAtm(BankAtm bankAtm) {
        this.bank = bankAtm.getBank();
        this.id = bankAtm.getId();
        this.name = bankAtm.getName();
        this.address = bankAtm.getAddress();
        this.status = bankAtm.getStatus();
        this.canGiveMoney = bankAtm.getCanInputMoney();
        this.canInputMoney = bankAtm.getCanInputMoney();
        this.bankOffice = bankAtm.getBankOffice();
        this.employee = bankAtm.getEmployee();
        this.money = bankAtm.getMoney();
        this.monthCost = bankAtm.getMonthCost();
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
                ", bankOffice=" + bankOffice +
                ", employeeId=" + employee +
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

    public BankOffice getBankOffice() {
        return this.bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employeeId) {
        this.employee = employeeId;
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
