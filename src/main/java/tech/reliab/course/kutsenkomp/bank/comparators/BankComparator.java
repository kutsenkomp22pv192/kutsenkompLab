package tech.reliab.course.kutsenkomp.bank.comparators;

import tech.reliab.course.kutsenkomp.bank.entity.Bank;

import java.util.Comparator;

public class BankComparator implements Comparator<Bank> {
    @Override
    public int compare(Bank left, Bank right) {

//        var interestRateCompare = Float.compare(left.getInterestRate(),right.getInterestRate());
//        if(interestRateCompare != 0){
//            return -interestRateCompare;
//        }

        if(left.getRate() != right.getRate()){
            return left.getRate() < right.getRate() ? 1: -1;
        }
//
//        if(left.getCountClients() != right.getCountClients()){
//            return left.getCountClients() > right.getCountClients() ? 1: -1;
//        }
//
//        if(left.getCountOffices() != right.getCountOffices()){
//            return left.getCountOffices() > right.getCountOffices() ? 1: -1;
//        }
//
//        if(left.getCountAtm() != right.getCountAtm()){
//            return left.getCountAtm() > right.getCountAtm() ? 1: -1;
//        }
//
//        if(left.getCountEmployees() != right.getCountEmployees()){
//            return left.getCountEmployees() > right.getCountEmployees() ? 1: -1;
//        }

        return 0;
    }
}
