package org.example.springsec.ecomm.dto;

public enum PaymentMethod {
        CREDIT_CARD,
        DEBIT_CARD,
        PAYPAL,
        BANK_TRANSFER,
        CASH;

        public static PaymentMethod fromInt(int code) {
            return switch (code) {
                case 1 -> CREDIT_CARD;
                case 2 -> DEBIT_CARD;
                case 3 -> PAYPAL;
                case 4 -> BANK_TRANSFER;
                case 5 -> CASH;
                default -> throw new IllegalArgumentException("Invalid Payment Method: " + code);
            };
        }
}
