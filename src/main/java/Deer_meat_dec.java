public class Deer_meat_dec extends DishDecorator {
    public Deer_meat_dec(Dish_interface dish) {
        super(dish);
    }

    @Override
    public int return_price() {
        return super.return_price() + 20;
    }

    @Override
    public String return_name() {
        return super.return_name() + " с двойной порцией оленины";
    }
}