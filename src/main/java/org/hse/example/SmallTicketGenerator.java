package org.hse.example;

import java.util.Iterator;

/**
 * Генератор билетов из 4-х цифр. Реализует {@link java.util.Iterator}
 */
public class SmallTicketGenerator implements Iterator<MealTicket> {
    private long current = 0;

    /**
     * @return true, если есть билеты в текущей последовательности
     */
    @Override
    public boolean hasNext() {
        return current < 1E4;
    }

    /**
     * @return следующий билет
     */
    @Override
    public MealTicket next() {
        MealTicket ticket = new SmallTicket(current);
        current++;
        return ticket;
    }
}
