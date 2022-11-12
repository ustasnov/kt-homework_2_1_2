package ru.netology

fun calculateMaestroCommission(totalAmount: Int, amount: Int): Int {
    val result = if (totalAmount > 75_000) {
        (amount * 0.006).toInt() + 20
    } else 0
    return result
}

fun calculateVisaCommission(amount: Int): Int {
    val standardCommission = (amount * 0.0075).toInt()
    val result = if (standardCommission > 35) standardCommission else 35
    return result
}

fun calculateCommission(amount: Int, cardType: String = "VK Pay", amountOfPreviousTransfers: Int = 0) =
    when (cardType) {
        "Maestro" -> calculateMaestroCommission(amountOfPreviousTransfers + amount, amount)
        "Mastercard" -> calculateMaestroCommission(amountOfPreviousTransfers + amount, amount)
        "Visa" -> calculateVisaCommission(amount)
        "MIR" -> calculateVisaCommission(amount)
        else -> 0
    }

fun main() {
    val amount = 50_000
    val cardType = "Visa"
    val amountOfPreviousTransfers = 0
    val result = calculateCommission(amount, cardType, amountOfPreviousTransfers)
    println("Amount: $amount RUB. Card type: $cardType RUB. Amount of previous transfers: $amountOfPreviousTransfers RUB. Commission: $result RUB.")
}