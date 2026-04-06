public class Sauce_dec extends DishDecorator {
    public Sauce_dec(Dish_interface dish) {
        super(dish);
    }

    @Override
    public int return_price() {
        return super.return_price() + 10;
    }

    @Override
    public String return_name() {
        return super.return_name() + " с огненным соусом";
    }
}