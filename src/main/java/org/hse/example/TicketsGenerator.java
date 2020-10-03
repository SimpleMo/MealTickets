package org.hse.example;

import java.util.Iterator;

/**
 * Генерирует все возможные билеты, реализует {@link java.util.Iterator}
 */
public class TicketsGenerator implements Iterator<Ticket> {
    private long current = 0;

    /**
     * @return true, если остались билеты в текущей последовательности
     */
    @Override
    public boolean hasNext() {
        return current < 1E6;
    }

    /**
     * @return следующий билет
     */
    @Override
    public Ticket next() {
        Ticket nextTicket = new Ticket(current);
        current++;
        return nextTicket;
    }
}
