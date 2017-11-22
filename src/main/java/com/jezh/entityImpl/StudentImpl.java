package com.jezh.entityImpl;

import com.jezh.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//@Component("student")
public class StudentImpl implements Student {

    private String name = "default_name_value";
    private String surname = "default_surname_value";
    private String country = "select_country";

    private String favoriteRockBand;
    private LinkedHashMap<String, String> favoriteRockBandOptions;

    // это поле заполнится на странице ОДНИМ ИЗ значений выпадающего списка:
    private String favoriteDish;

    // Создаем LinkedHashMap, что гарантирует, что выпадающий список будет иметь тот порядок, который ему здесь укажем
    public StudentImpl() {
        favoriteRockBandOptions = new LinkedHashMap<>();
//        здесь <K, V> будут являться для выпадающего списка значениями <value, label>
        favoriteRockBandOptions.put("Beatles", "B");
        favoriteRockBandOptions.put("Rolling Stones", "RS");
        favoriteRockBandOptions.put("Pink Floyd", "PF");
        favoriteRockBandOptions.put("Jethro Tall", "JT");
        // сортируем мапу - пробуем следующий метод:
// public abstract <R, A> R collect(java.util.stream.Collector<? super T, A, R> collector)
        // Мы можем получить объект интерфейса Collector с помощью метода toMap() класса Collectors:
// public static <T, K, U> Collector<T, ?, Map<K, U>> toMap(Function<? super T,? extends K> keyMapper,
//                                                          Function<? super T,? extends U> valueMapper)
//Function принимает T, возвращает K; и Function принимает T, возвращает U

//        favoriteRockBandOptions = new LinkedHashMap<>(favoriteRockBandOptions.entrySet().stream()
//                .sorted(Comparator.comparing(Map.Entry::getValue))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        // Работает, но неправильно чегой-то. Попробуем применить другую перегрузку метода collect():
// <R> R collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
//        supplier: создает объект коллекции типа R
//        accumulator: добавляет в коллекцию R элемент T
//        combiner: бинарная функция, которая объединяет два объекта (добавляет в первую коллекцию R вторую коллекцию R)
// В нашем случае этот метод должен выглядеть так:
//    LinkedHashMap<String, String> collect(Supplier<LinkedHashMap<String, String>>,
//                                          BiConsumer<LinkedHashMap<String, String>, ? super Entry<String, String>>,
//                                          BiConsumer<LinkedHashMap<String, String>, LinkedHashMap<String, String>>)
        favoriteRockBandOptions = favoriteRockBandOptions.entrySet().stream()
// здесь создаем новый Comparator, поскольку мы должны указать, как мы сравниваем объекты Map.Entry: по key или по value:
                .sorted(Comparator.comparing(Map.Entry::getValue)) // или: (o1, o2) -> o1.getValue().compareTo(o2.getValue())
                .collect(LinkedHashMap::new, //   или: () -> new LinkedHashMap<String, String>()
                        (mapa, entry) -> mapa.put(entry.getKey(), entry.getValue()),
                        Map::putAll); // или:  (map, mapa) -> map.putAll(mapa)
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavoriteRockBand() {
        return favoriteRockBand;
    }

    public void setFavoriteRockBand(String favoriteRockBand) {
        this.favoriteRockBand = favoriteRockBand;
    }

    public LinkedHashMap<String, String> getFavoriteRockBandOptions() {
        return favoriteRockBandOptions;
    }

    public void setFavoriteRockBandOptions(LinkedHashMap<String, String> favoriteRockBandOptions) {
        this.favoriteRockBandOptions = favoriteRockBandOptions;
    }

    public String getFavoriteDish() {
        return favoriteDish;
    }

    public void setFavoriteDish(String favoriteDish) {
        this.favoriteDish = favoriteDish;
    }
}
