package org.hse.example;

import java.util.function.Predicate;

/**
 * Интерфейс для реализации паттерна Посетитель
 */
public interface Visitable<T> {
    /**
     * Реализация по умолчанию, при необходимости переопределить
     *
     * @param visitor предекат, инкапсулирующий необходимую операцию
     * @return по умолчанию true
     */
    default boolean accept(Predicate<T> visitor) {
        return true;
    }
}
