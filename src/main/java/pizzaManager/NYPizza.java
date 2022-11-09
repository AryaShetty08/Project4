package pizzaManager;

public class NYPizza implements PizzaFactory{
    @Override
    public Pizza createDeluxe() {
        return new Deluxe(this);
    }

    @Override
    public Pizza createMeatzza() {
        return new Meatzza(this);
    }

    @Override
    public Pizza createBBQChicken() {
        return new BBQ_Chicken(this);
    }

    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(this);
    }
}
