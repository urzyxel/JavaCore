package Lavel2.Lesson03.home;

public class Box<T extends Fruit> {
    private final T fruit;
    private int currentItemsCount = 0;

    public Box(T fruit, int count) {
            this.fruit = fruit;
            currentItemsCount = count;
        }

    public int getCurrentItemsCount() {
        return currentItemsCount;
    }

    public void addFruits(int count) {
        currentItemsCount += count;
    }

    public float getWeight() {
        float weight = fruit.getFruitWeight();
        return weight * currentItemsCount;
    }

    public Box<T> unite(Box<T> srcBox) {
        currentItemsCount += srcBox.currentItemsCount;
        srcBox.currentItemsCount = 0;
        return this;
    }

    public boolean compare(Box<? extends Fruit> o) {
        if (this.getWeight() == o.getWeight()) {
            return true;
        }
        return false;
    }
}
