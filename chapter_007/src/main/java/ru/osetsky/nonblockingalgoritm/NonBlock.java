package ru.osetsky.nonblockingalgoritm;


import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * Created by koldy on 10.03.2018.
 */
public class NonBlock<E extends User> {
    /*
     * Поле хэшкарты
     */
    private ConcurrentHashMap<Integer, E> map = new ConcurrentHashMap();
    public void add(User cacheUs) {
        // Проверяю нет ли хэша с этим id
        if (!this.map.containsKey(cacheUs.getKey())) {
            // Добавляю новый хэш
            this.map.put(cacheUs.getKey(), (E) cacheUs);
        } else {
            System.out.println("Такой элемент уже существует");
        }
    }
    public void update(int key, E cacheUs) {
        // Проверяю есть ли хеш с таким id
        if (this.map.containsKey(key)) {
            this.map.computeIfPresent(cacheUs.getKey(), new BiFunction<Integer, E, E>() {
                @Override
                public E apply(Integer integer, E element) {
                    // сверяю версии файлов прежде чем записать
                    if (cacheUs.getVersion() == element.getVersion()) {
                        element.setValue(cacheUs.getValue());
                    } else {
                        try {
                            throw new OplimisticException("Ошибка версии");
                        } catch (OplimisticException e) {
                            e.printStackTrace();
                        }
                    }
                    return element;
                }
            });
        } else {
            System.out.println("Элемент не найденн");
        }
    }
    public void delete(int key) {
        // Проверяю есть ли хэш с этим id
        if (this.map.containsKey(key)) {
            this.map.remove(key);
        } else {
            System.out.println("Элемент не найденн");
        }
    }
    // Метод возвращает количество хешей в хешкарте(необходимо для тестирования)
    public int size() {
        return map.size();
    }

}
