package com.company.entities;

import java.io.Serializable;

public class Phone implements Serializable {
    private final String firstName;
    private final String lastName;
    private final String patronymic;
    private final String accountNumber;
    private final int cityCallTime;
    private final int intercityCallTime;

    public Phone(String firstName, String lastName, String patronymic, String accountNumber, int cityCallTime, int intercityCallTime) {
        this.firstName =firstName;
        this.lastName =lastName;
        this.patronymic = patronymic;
        this.accountNumber = accountNumber;
        this.cityCallTime = cityCallTime;
        this.intercityCallTime =intercityCallTime;
    }
    public int getIntercityCallTime(){
        return intercityCallTime;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString(){
        return "Ім'я: " + firstName + " " + lastName + " " + patronymic + " " + "\nНомер рахунку: " + accountNumber + "\nЧас міських розмов: " + cityCallTime + "годин\nЧас міжміських розмов: " + intercityCallTime + " годин\n";

    }
}