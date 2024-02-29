package com.Task;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionTask {
    public static void main(String[] args) {
       List<Transaction>traders = TransactionData.getAll().stream()
                  .filter(i->i.getYear()==2011)
                  .sorted(Comparator.comparing(Transaction::getValue))
               .collect(Collectors.toList());

        System.out.println(traders);


        //unique cities

       List<String>citiesList = TransactionData.getAll().stream()
                .map(i->i.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(citiesList);

        //cambrige traders sorted by name
          List<Trader>cambridgename = TransactionData.getAll().stream()
                .map(Transaction::getTrader)
                .filter(i->i.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(cambridgename);


        //a String for all traders name

        String names = TransactionData.getAll().stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));


        System.out.println(names);

        //based in milan
           Transaction milan =  TransactionData.getAll().stream()
                .filter(i->i.getTrader().getCity().equals("Milan"))
                .findAny().get();
        System.out.println(milan);

        //values of trader who lives cambricage

                TransactionData.getAll().stream()
                        .filter(i->i.getTrader().getCity().equals("Cambridge"))
                        .map(Transaction::getValue)
                        .forEach(System.out::println);
                //Hihgest values of transaction
       Integer max = TransactionData.getAll().stream()
                .map(i->i.getValue())
                .max(Comparator.comparingInt(Integer::intValue)).get();
        System.out.println(max);

        // min values of transactions
        Integer min = TransactionData.getAll().stream()
                .map(i->i.getValue())
                .min(Comparator.comparingInt(Integer::intValue)).get();
        System.out.println(min);


    }


}
