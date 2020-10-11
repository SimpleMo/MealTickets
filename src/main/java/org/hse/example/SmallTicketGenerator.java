package org.hse.example;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Генератор билетов из 4-х цифр. Реализует {@link java.util.Iterator}
 */
@Service("smallTicketGenerator")
public class SmallTicketGenerator implements Iterator<MealTicket>, ApplicationContextAware {

    private ApplicationContext applicationContext;

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
        SmallTicket.SmallTicketBuilder builder = applicationContext.getBean(SmallTicket.SmallTicketBuilder.class);
        SmallTicket.SmallTicketBuilder ticketBuilder = builder.ticket(current);
        current++;
        return ticketBuilder.build();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
