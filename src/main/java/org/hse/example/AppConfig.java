package org.hse.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Iterator;
import java.util.function.Supplier;

/**
 * Класс-конфигуратор
 */
@Configuration
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
    public Supplier<Long> getTicketCounter(@Qualifier("ticketsGenerator")
                                           final Iterator<MealTicket> ticketIterator){
        return new MealTicketCounter(ticketIterator);
    }
}
