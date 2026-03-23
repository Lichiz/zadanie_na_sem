public class Sauce_dec implements Dish_interface {
    private final Dish_interface dish;
    public Sauce_dec(Dish_interface d) { this.dish = d; }

    @Override public int return_price() { return dish.return_price() + 10; }
    @Override public String return_name() { return dish.return_name() + " с огненным соусом"; }
}