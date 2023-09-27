package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone(1, "Poradkiv", "Vova", "Olegov", "12426", 1, 0));
        phones.add(new Phone(2, "Romantiv", "Roma", "Romanovich", "57457", 12, 4));
        phones.add(new Phone(3, "Ostrovcky", "Diana", "Tarasivna", "23653", 9, 5));

        int maxchasmiskixrosmov = 12;
        System.out.println("З більшим часов міських розмов" + maxchasmiskixrosmov + "всього годин:");
        for (Phone phone : phones) {
            if (phone.getChasMistksixRosmov() > maxchasmiskixrosmov) {
                System.out.println("ID:" + phone.getId() + ", Прізвище: " + phone.getPrisvishe() + ", Імя: " + phone.getImya() + ", По-батькові: " + phone.getPobatkovi());
            }
        }

        System.out.println("Абоненти, що користувалися міжміським зв'язком:");
        for (Phone phone : phones) {
            if (phone.getChasMishmistskixRosmov() > 0.0) {
                System.out.println("ID:" + phone.getId() + ", Прізвище: " + phone.getPrisvishe() + ", Імя: " + phone.getImya() + ", По-батькові: " + phone.getPobatkovi());
            }
        }

        String pochatkoviyNomer = "10000";
        String kintseviyNomer = "40000";
        System.out.println("Абоненти з номерами рахунку діапазоном від" + pochatkoviyNomer + "до " + kintseviyNomer);
        for (Phone phone : phones) {
            String nomerRaxynky = phone.getnomerRaxynky();
            if (nomerRaxynky.compareTo(pochatkoviyNomer) >= 0 && nomerRaxynky.compareTo(kintseviyNomer) <= 0) {
                System.out.println("ID:" + phone.getId() + ", Прізвище: " + phone.getPrisvishe() + ", Імя: " + phone.getImya() + ", По-батькові: " + phone.getPobatkovi() + " Номер рахунку: " + phone.getnomerRaxynky());
            }
        }
    }
}

