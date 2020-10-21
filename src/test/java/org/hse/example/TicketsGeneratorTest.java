package org.hse.example;

import org.hse.example.builders.MealTicketBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class TicketsGeneratorTest {
    @Configuration
    public static class TestConfig {
        @Bean
        Iterator<MealTicket> getGenerator(){
            return new TicketsGenerator();
        }
    }

    MealTicketBuilder mealTicketBuilder;

    @Autowired
    Iterator<MealTicket> ticketsGenerator;

    @Before
    public void mockMealTicketBuilder(){
        Mockito.doNothing().when(mealTicketBuilder).ticket(Mockito.anyLong());
        Mockito.when(mealTicketBuilder.build()).thenReturn(new Ticket(1001));
    }

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