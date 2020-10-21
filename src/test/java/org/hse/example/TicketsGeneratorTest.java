package org.hse.example;

import org.hse.example.builders.MealTicketBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class TicketsGeneratorTest {
    @Configuration
    public static class TestConfig {
        @Bean
        Iterator<MealTicket> getGenerator(){
            return new TicketsGenerator();
        }

        @Bean("ticketBuilder")
        MealTicketBuilder getBuilder(){
            MealTicketBuilder mealTicketBuilder = Mockito.mock(MealTicketBuilder.class);
            Mockito.doNothing().when(mealTicketBuilder).ticket(Mockito.anyLong());
            Mockito.when(mealTicketBuilder.build()).thenReturn(new Ticket(1001));

            return mealTicketBuilder;
        }
    }

    @Autowired
    Iterator<MealTicket> ticketsGenerator;

    @Test
    public void iterationCount(){
        //given
        long counter = 0;

        //when
        for(; ticketsGenerator.hasNext(); ticketsGenerator.next());

        //then
        assertEquals(1000000, counter);
    }

}