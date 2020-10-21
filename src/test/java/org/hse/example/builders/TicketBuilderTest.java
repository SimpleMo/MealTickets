package org.hse.example.builders;

import org.hse.example.MealTicket;
import org.hse.example.Ticket;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Набор тестов для класса {@link TicketBuilder}
 */
public class TicketBuilderTest {

    /**
     * Проверяет, что билдер возвращает такой же билет, который вернул бы конструктор
     */
    @Test
    public void builderWorksSameAsConstructor() {
        //given
        Long ticketNumber = 100500L;
        MealTicketBuilder builder = new TicketBuilder();

        //when
        MealTicketBuilder builtTicket = builder.ticket(ticketNumber);

        //then
        assertEquals(new Ticket(ticketNumber), builtTicket.build());
    }

    /**
     * Проверяет, что билдер нельзя использовать повторно
     */
    @Test
    public void builderCouldNotBeReused(){
        //given
        MealTicketBuilder builder = new TicketBuilder();
        builder.ticket(100500).build();

        //when
        Exception exception = null;
        try {
            builder.build();
        } catch (Exception e) {
            exception = e;
        }

        //then
        assertNotNull(exception);
        assertEquals(IllegalStateException.class, exception.getClass());
        assertEquals("Данный Строитель использовался ранее!", exception.getMessage());
    }
    //todo добавить тесты на граничные случаи

}