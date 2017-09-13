package ru.pro.generic;

/**
 * Created by koldy on 08.09.2017.
 */
public class UserStore implements Store<Base> {
    /**
     * Field size is constant of type integer.
     */
    private int size = 10;
    /**
     * sim is object of class SimpleArray.
     */
    private SimpleArray<Base> sim = new SimpleArray<>(size);
    @Override
    public void add(Base value) {
        this.sim.add(value);
    }

    @Override
    public void update(Base valueOld, Base valueNew) {
        for (int i = 0; i < this.size; i++) {
            if (this.sim.get(i) == valueOld) {
                this.sim.update(i, valueNew);
                break;
            }
        }
    }

    @Override
    public void delete(Base value) {
        for (int i = 0; i < this.size; i++) {
            if (this.sim.get(i) == value) {
                this.sim.delete(i);
                break;
            }
        }
    }

    /**
     * Method getSim is type SimpleArray.
     * @return object sim.
     */
    public SimpleArray<Base> getSim() {
        return this.sim;
    }
}
