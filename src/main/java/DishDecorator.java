public abstract class DishDecorator implements Dish_interface {
    protected final Dish_interface dish;

    public DishDecorator(Dish_interface dish) {
        this.dish = dish;
    }

    @Override
    public String return_name() {
        return dish.return_name();
    }

    @Override
    public int return_price() {
        return dish.return_price();
    }
}