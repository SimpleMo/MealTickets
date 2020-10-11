package org.hse.example;

import java.util.Arrays;

/**
 * Билет из 4-я цифр
 */
public class SmallTicket implements MealTicket {
    private int[] ticket;
    /**
     * @param ticket номер билета в виде целого числа
     */
    private SmallTicket(long ticket) {
        this.ticket = new int[]{0, 0, 0, 0};
        int j = 3;
        while (ticket > 0) {
            this.ticket[j] = (int) ticket % 10;
            ticket = ticket / 10;
            j--;
        }
    }

    /**
     * @return возвращает построитель {@link MealTicket}
     */
    public static SmallTicketBuilder builder() {
        return new SmallTicketBuilder();
    }

    @Override
    public boolean isMealTicket() {
        int firstSum = ticket[0] + ticket[1];
        int lastSum = ticket[2] + ticket[3];
        return firstSum == lastSum;
    }

    @Override
    public String toString() {
        return "SmallTicket{" + Arrays.toString(ticket) + "}";
    }

    /**
     * Построитель билетов
     */
    public static class SmallTicketBuilder {
        private long ticket;
        private boolean alreadyUsed = false;

        private SmallTicketBuilder() {
        }

        public SmallTicketBuilder ticket(long ticket) {
            this.ticket = ticket;
            return this;
        }

        /**
         * Возвращает сформированный экземпляр {@link MealTicket}. Может использоваться только один раз!
         *
         * @return {@link SmallTicket}
         */
        public SmallTicket build() {
            if (alreadyUsed) {
                throw new IllegalStateException("This builder is already used!");
            }
            return new SmallTicket(ticket);
        }
    }
}
