public class Wild_berries_dec implements Dish_interface {
    private final Dish_interface dish;
    public Wild_berries_dec(Dish_interface d) { this.dish = d; }

    @Override public int return_price() { return dish.return_price() + 5; }
    @Override public String return_name() { return dish.return_name() + " со снежными ягодами"; }
}