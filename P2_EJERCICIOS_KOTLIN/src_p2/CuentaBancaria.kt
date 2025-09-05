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
    
    fun realizarRetiro(monto: Double) {
        when {
            monto <= 0 -> println("Error: El monto debe ser positivo")
            monto > limiteRetiro -> println("Error: Excede el límite de retiro")
            monto > saldo -> println("Error: Fondos insuficientes")
            else -> {
                saldo -= monto
                println("Retiro exitoso. Saldo restante: $saldo")
            }
        }
    }
}

fun ejecutarCuentaBancaria() {
    println("\n=== CUENTA BANCARIA ===")
    val cuenta = CuentaBancaria()

    print("Ingrese el saldo inicial: ")
    val saldoInicial = readln().toDouble()
    cuenta.setSaldo(saldoInicial)

    print("Ingrese el límite de retiro: ")
    val limite = readln().toDouble()
    cuenta.setLimiteRetiro(limite)

    var continuar = true
    while (continuar) {
        println("\nSaldo actual: ${cuenta.getSaldo()}")
        println("Límite de retiro: ${cuenta.getLimiteRetiro()}")
        print("Ingrese el monto a retirar (0 para salir): ")
        val monto = readln().toDouble()

        if (monto == 0.0) {
            continuar = false
        } else {
            cuenta.realizarRetiro(monto)
        }
    }
}
