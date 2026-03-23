public class Deer_meat_dec implements Dish_interface {
    private final Dish_interface dish;
    public Deer_meat_dec(Dish_interface d) { this.dish = d; }

    @Override public int return_price() { return dish.return_price() + 20; }
    @Override public String return_name() { return dish.return_name() + " с двойной порцией оленины"; }
}