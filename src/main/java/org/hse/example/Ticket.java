package org.hse.example;

import java.util.Arrays;

/**
 * Класс для моделирования билета
 */
public class Ticket implements MealTicket {
    private int[] ticket;

    /**
     * @param ticket номер билета в виде целого числа
     */
    private Ticket(long ticket) {
        this.ticket = new int[]{0, 0, 0, 0, 0, 0};
        int j = 5;
        while (ticket > 0) {
            this.ticket[j] = (int) ticket % 10;
            ticket = ticket / 10;
            j--;
        }
    }

    /**
     * @return возвращает построитель {@link MealTicket}
     */
    public static TicketBuilder builder() {
        return new TicketBuilder();
    }

    /**
     * @return true, если билет счастливый
     */
    @Override
    public boolean isMealTicket() {
        int firstSum = ticket[0] + ticket[1] + ticket[2];
        int lastSum = ticket[3] + ticket[4] + ticket[5];

        return firstSum == lastSum;
    }

    @Override
    public String toString() {
        return "Ticket{" + Arrays.toString(ticket) + "}";
    }

    /**
     * Построитель билетов
     */
    public static class TicketBuilder {
        private long ticket;
        private boolean alreadyUsed = false;

        private TicketBuilder() {
        }

        public TicketBuilder ticket(long ticket) {
            this.ticket = ticket;
            return this;
        }

        /**
         * Возвращает сформированный экземпляр {@link MealTicket}. Может использоваться только один раз!
         *
         * @return {@link Ticket}
         */
        public Ticket build() {
            if (alreadyUsed) {
                throw new IllegalStateException("This builder is already used!");
            }
            return new Ticket(ticket);
        }

    }
}
