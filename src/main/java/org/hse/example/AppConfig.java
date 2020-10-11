package org.hse.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import java.util.Iterator;
import java.util.function.Supplier;

/**
 * Класс-конфигуратор
 */
@Configuration
@ComponentScan("org.hse.example")
public class AppConfig {

    /**
     * @return длина билета
     */
    @Bean("ticketLength")
    public Integer getTicketLength(){
        return 4;
    }

    @Bean("mealTicketCounter")
    @Primary
    @Autowired
    public Supplier<Long> getTicketCounter(@Qualifier("smallTicketGenerator")
                                           final Iterator<MealTicket> ticketIterator){
        return new MealTicketCounter(ticketIterator);
    }

    /**
     * @return возвращает построитель счастливых билетов
     */
    @Bean
    @Scope("prototype")
    public Ticket.TicketBuilder getMealTicketBuilder(){
        return Ticket.builder();
    }

    /**
     * @return возвращает построитель "коротких" счастливых билетов
     */
    @Bean
    @Scope("prototype")
    public SmallTicket.SmallTicketBuilder getSmallTicketBuilder(){
        return SmallTicket.builder();
    }
}
