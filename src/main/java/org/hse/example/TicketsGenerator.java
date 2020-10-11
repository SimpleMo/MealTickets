package org.hse.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Генерирует все возможные билеты, реализует {@link java.util.Iterator}
 */
@Service("ticketsGenerator")
@Primary
public class TicketsGenerator implements Iterator<MealTicket>, ApplicationContextAware {

    private ApplicationContext applicationContext;

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
    public MealTicket next() {
        Ticket.TicketBuilder builder = applicationContext.getBean(Ticket.TicketBuilder.class);
        Ticket.TicketBuilder ticketBuilder = builder.ticket(current);
        current++;
        return ticketBuilder.build();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
