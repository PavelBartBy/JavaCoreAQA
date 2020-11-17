package javaclasses;

import java.util.ArrayList;
import java.util.Calendar;

public class MainTaskClasses {

//    Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
//    Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти
//    данные на консоль. В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
//    java_classes.Car: id, Марка, Модель, Год выпуска, Цвет, Цена, Регистрационный номер.
//
//    Создать массив объектов. Вывести:
//
//    a) список автомобилей заданной марки;
//
//    b) список автомобилей заданной модели, которые эксплуатируются больше n лет;
//
//    c) список автомобилей заданного года выпуска, цена которых больше указанной.

//    class java_classes.Car -> Java.java_classes.Car
    public void searchByBrand(String brand, Car[] cars){

        for (Car i:cars){
            if (i.getBrand()==brand){
                System.out.println(i.toString());
            }
        }
    }

    public ArrayList<Car> searchByModel(String model, Car[] cars){
        ArrayList<Car> carList = new ArrayList<>();
        for (Car i:cars){
            if(i.getModel()==model){
                carList.add(i);
            }
        }
        return carList;
    }

    public void searchByAge(int years, String model, Car[] cars){
        /*
          years - parameter mean "more than years"
          Cars - array of objects
         */
        Calendar calendar = Calendar.getInstance();
        int curYear=calendar.get(Calendar.YEAR);
        ArrayList<Car> carList = searchByModel(model,cars);
        for (Car i:carList){
            if((curYear-i.getYearOfIssue())>years){
                System.out.println(i.toString());
            }
        }
    }

    public ArrayList<Car> byYearOfIssue(int year, Car[] cars){
        ArrayList<Car> carList = new ArrayList();
        for (Car i:cars){
            if (i.getYearOfIssue()==year){
                carList.add(i);
            }
        }
        return carList;
    }

    public void searchByYearAndPrice(int year, int price, Car[] cars){
        // price - result mean "more than price"
        ArrayList<Car> carList = byYearOfIssue(year,cars);
        for (Car i:carList){
            if(i.getPrice()>price){
                System.out.println(i.toString());
            }
        }
    }


    public static void main(String[] args) {

    Car[] cars = new Car[5];
    cars[0] = new Car("BMW","507","red",1955, 2300000);
    cars[1] = new Car("Mercedes","AMG GT","yelow",2020, 130000);
    cars[2] = new Car("Nissan","Skyline","black",2002,40000);
    cars[3] = new Car("Mitsubishi","Lancer","blue",2014, 20000);
    cars[4] = new Car("Audi","R8","white",2010, 35000);

    MainTaskClasses mainTask = new MainTaskClasses();

//    1p.
        mainTask.searchByBrand("Nissan", cars);

//    2p.
        mainTask.searchByAge(5,"R8",cars);

//    3p.
        mainTask.searchByYearAndPrice(2002, 35000, cars);

    }

}
