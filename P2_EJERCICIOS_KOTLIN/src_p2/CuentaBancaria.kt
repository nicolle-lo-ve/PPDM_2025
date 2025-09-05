class CuentaBancaria {
    private var saldo: Double = 0.0
    private var limiteRetiro: Double = 1000.0

    fun setSaldo(nuevoSaldo: Double) {
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo
        } else {
            println("Error: El saldo no puede ser negativo")
        }
    }

    fun getSaldo(): Double = saldo

    fun setLimiteRetiro(nuevoLimite: Double) {
        if (nuevoLimite >= 0) {
            limiteRetiro = nuevoLimite
        } else {
            println("Error: El límite no puede ser negativo")
        }
    }

    fun getLimiteRetiro(): Double = limiteRetiro
}
