package com.example.kotlin_extensions.extensions

/**
 * Masks part of a CPF (Cadastro de Pessoas Físicas) value for privacy.
 * This function returns a masked version of the CPF where only the first two and last digits are visible.
 *
 * Example:
 * - Input: "12345678901"
 * - Output: "12*.***.***01"
 *
 * @param cpf The CPF to be masked.
 * @return The masked CPF string.
 */
fun maskCpf(cpf: String): String {
    if (cpf.length != 11) return cpf // If CPF is not 11 characters long, return as-is
    return "${cpf.substring(0, 2)}*.***.***${cpf.substring(9)}" // Masks the middle part of the CPF
}