public class Nordic_bread_dec extends DishDecorator {
    public Nordic_bread_dec(Dish_interface dish) {
        super(dish);
    }

    @Override
    public int return_price() {
        return super.return_price() + 7;
    }

    @Override
    public String return_name() {
        return super.return_name() + " с нордской лепешкой";
    }
}