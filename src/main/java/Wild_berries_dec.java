public class Wild_berries_dec extends DishDecorator {
    public Wild_berries_dec(Dish_interface dish) {
        super(dish);
    }

    @Override
    public int return_price() {
        return super.return_price() + 5;
    }

    @Override
    public String return_name() {
        return super.return_name() + " со снежными ягодами";
    }
}