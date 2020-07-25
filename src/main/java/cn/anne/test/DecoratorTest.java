package cn.anne.test;

import org.junit.Test;

import java.sql.SQLOutput;

public class DecoratorTest {


    @Test
    public void decoratorTest(){
        Drink drink = new Milk();
        drink = new AddSurgeDrink(drink);   //加糖
        drink = new AddChooseDrink(drink);  //加巧克力
        System.out.println(drink.cost());
    }
}


interface Drink{
    public int cost();
}

class Coffee implements Drink{

    @Override
    public int cost() {
        return 12;
    }
}

class Milk implements Drink{

    @Override
    public int cost() {
        return 14;
    }
}

class AddSurgeDrink implements Drink{

    public Drink drink;
    public AddSurgeDrink(Drink drink){
        this.drink = drink;
    }
    @Override
    public int cost() {
        return drink.cost()+1;
    }
}

class AddChooseDrink implements Drink{

    public Drink drink;

    public AddChooseDrink(Drink drink) {
        this.drink = drink;
    }

    @Override
    public int cost() {
        return drink.cost()+3;
    }
}

