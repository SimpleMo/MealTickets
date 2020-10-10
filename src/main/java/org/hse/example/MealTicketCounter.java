package org.hse.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Сервис, выполняющий подсчёт счастливых билетов
 */
public class MealTicketCounter implements Supplier<Long> {
    private final Iterator<MealTicket> ticketIterator;

    public MealTicketCounter(final Iterator<MealTicket> ticketIterator) {
        this.ticketIterator = ticketIterator;
    }

    /**
     * Выводит счастливые билеты в консоль и возвращает их количество
     *
     * @return количество счастливых билетов
     */
    @Override
    public Long get() {
        Iterable<MealTicket> tickets = () -> ticketIterator;
        return StreamSupport
                    .stream(tickets.spliterator(), false)
                    .filter(MealTicket::isMealTicket)
                    .peek(System.out::println)
                    .count();
    }
}
