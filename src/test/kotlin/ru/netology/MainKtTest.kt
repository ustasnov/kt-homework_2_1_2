package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateCommission_VisaMinCommission() {
        val amount = 100
        val cardType = "Visa"
        val amountOfPreviousTransfers = 0

        val result = calculateCommission(
            amount,
            cardType,
            amountOfPreviousTransfers
        )

        assertEquals(0, result)
    }

    @Test
    fun calculateCommission_VisaStandardCommission() {
        val amount = 50_000
        val cardType = "Visa"
        val amountOfPreviousTransfers = 0

        val result = calculateCommission(
            amount,
            cardType,
            amountOfPreviousTransfers
        )

        assertEquals(375, result)
    }

    @Test
        fun calculateCommission_MIRWithoutCommission() {
            val amount = 100
            val cardType = "MIR"
            val amountOfPreviousTransfers = 0

            val result = calculateCommission(
                amount,
                cardType,
                amountOfPreviousTransfers
            )

            assertEquals(35, result)
        }

    @Test
    fun calculateCommission_MIRStandardCommission() {
        val amount = 50_000
        val cardType = "MIR"
        val amountOfPreviousTransfers = 0

        val result = calculateCommission(
            amount,
            cardType,
            amountOfPreviousTransfers
        )

        assertEquals(375, result)
    }

    @Test
    fun calculateCommission_MastercardWithoutCommission() {
        val amount = 50_000
        val cardType = "Mastercard"
        val amountOfPreviousTransfers = 1_000

        val result = calculateCommission(
            amount,
            cardType,
            amountOfPreviousTransfers
        )

        assertEquals(0, result)
    }

    @Test
    fun calculateCommission_MastercardWithCommission() {
        val amount = 50_000
        val cardType = "Mastercard"
        val amountOfPreviousTransfers = 30_000

        val result = calculateCommission(
            amount,
            cardType,
            amountOfPreviousTransfers
        )

        assertEquals(320, result)
    }


    @Test
    fun calculateCommission_MaestroWithoutCommission() {
        val amount = 50_000
        val cardType = "Maestro"
        val amountOfPreviousTransfers = 1_000

        val result = calculateCommission(
            amount,
            cardType,
            amountOfPreviousTransfers
        )

        assertEquals(0, result)
    }

    @Test
    fun calculateCommission_MaestroWithCommission() {
       val amount = 50_000
       val cardType = "Maestro"
       val amountOfPreviousTransfers = 30_000

       val result = calculateCommission(
           amount,
           cardType,
           amountOfPreviousTransfers
       )

       assertEquals(320, result)
    }

    @Test
    fun calculateCommission_VKPay1() {
        val amount = 50_000
        val cardType = "VK Pay"
        val amountOfPreviousTransfers = 1_000

        val result = calculateCommission(
            amount,
            cardType,
            amountOfPreviousTransfers
        )

        assertEquals(0, result)
    }

    @Test
    fun calculateCommission_VKPay2() {
        val amount = 50_000
        val cardType = "VK Pay"
        val amountOfPreviousTransfers = 30_000

        val result = calculateCommission(
            amount,
            cardType,
            amountOfPreviousTransfers
        )

        assertEquals(0, result)
    }


    @Test
    fun calculateCommission_DefaultParams1() {
        val amount = 50_000
        val result = calculateCommission(amount)

        assertEquals(0, result)
    }

    @Test
    fun calculateCommission_DefaultParams2() {
        val amount = 50_000
        val cardType = "Visa"

        val result = calculateCommission(
            amount,
            cardType
        )

        assertEquals(375, result)
    }

    @Test
    fun calculateCommission_DefaultParams3() {
        val amount = 50_000
        val amountOfPreviousTransfers = 1_000

        val result = calculateCommission(
            amount, amountOfPreviousTransfers=amountOfPreviousTransfers
        )

        assertEquals(0, result)
    }

    @Test
    fun calculateCommission_NonLegalCardType() {
        val amount = 50_000
        val cardType = ""
        val amountOfPreviousTransfers = 1_000

        val result = calculateCommission(
            amount,
            cardType,
            amountOfPreviousTransfers
        )

        assertEquals(0, result)
    }

}