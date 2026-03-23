public class Nordic_bread_dec implements Dish_interface {
    private final Dish_interface dish;
    public Nordic_bread_dec(Dish_interface d) { this.dish = d; }

    @Override public int return_price() { return dish.return_price() + 7; }
    @Override public String return_name() { return dish.return_name() + " с нордской лепешкой"; }
}