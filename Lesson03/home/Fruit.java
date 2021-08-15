package Lavel2.Lesson03.home;

public abstract class Fruit {
    protected float fruitWeight;

    public Fruit(float fruitWeight) {
        this.fruitWeight = fruitWeight;
    }

    public float getFruitWeight() {
        return fruitWeight;
    }
}
