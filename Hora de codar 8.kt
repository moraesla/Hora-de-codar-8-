class Bichinho(val nome: String){
    var fome = 50
    var felicidade = 50
    var cansaco = 0
    var idade = 0
    var vontadeDeIrAoBanheiro = 0
    var sujeira = 0

    fun alimentar(){
        fome -= 10
        if (fome < 0) fome = 0
        vontadeDeIrAoBanheiro += 15
        println("$nome foi alimentado. Agora está menos faminto, mas com vontade de ir ao banheiro.")
    }

    fun brincar(){
        felicidade += 10
        if (felicidade > 100) felicidade = 100
        cansaco += 15
        sujeira += 20
        println("$nome brincou! Está mais feliz, mas mais cansado e sujinho.")
    }

    fun descansar(horas: Int){
        if (horas >= 8) {
            cansaco = 0
            println("$nome descansou bem e está renovado!")
        } else {
            cansaco -= horas * 10
            if (cansaco < 0) cansaco = 0
            println("$nome descansou um pouco e se sente melhor.")
        }
    }

    fun usarBanheiro(){
        vontadeDeIrAoBanheiro = 0
        println("$nome usou o banheiro e está aliviado.")
    }

    fun tomarBanho(){
        sujeira = 0
        println("$nome tomou banho e está limpinho.")
    }

    fun mostrarStatus(){
        println("\nStatus de $nome:")
        println("Idade: $idade")
        println("Fome: $fome")
        println("Felicidade: $felicidade")
        println("Cansaço: $cansaco")
        println("Vontade de ir ao banheiro: $vontadeDeIrAoBanheiro")
        println("Sujeira: $sujeira")
    }

    fun passarTempo(){
        idade += 1
        fome += 3
        felicidade -= 3
        cansaco += 10

        if (felicidade < 0) felicidade = 0
        if (fome > 100) fome = 100
        if (cansaco > 100) cansaco = 100
        if (vontadeDeIrAoBanheiro > 100) vontadeDeIrAoBanheiro = 100
        if (sujeira > 100) sujeira = 100

        println("Um dia passou para $nome...")
    }

    fun perdeu(): Boolean{
        if (fome >= 100) {
            println("$nome ficou com muita fome e não aguentou.")
            return true
        }
        if (felicidade <= 0){
            println("$nome ficou muito triste e desistiu.")
            return true
        }
        if (cansaco >= 100){
            println("$nome ficou exausto.")
            return true
        }
        if (vontadeDeIrAoBanheiro >= 100) {
            println("$nome não conseguiu mais segurar o xixi...")
            return true
        }
        if (sujeira >= 100) {
            println("$nome ficou sujinho demais e ficou doente.")
            return true
        }
        return false
    }

    fun venceu(): Boolean {
        if (idade >= 50) {
            println("Parabéns! Você cuidou muito bem de $nome até os 50 anos!")
            return true
        }
        return false
    }
}

// função principal do jogo
fun main() {
    println("Bem-vindo ao jogo do bichinho virtual!")
    print("Digite o nome do seu bichinho: ")
    val nome = readLine() ?: "Fofo"
    val pet = Bichinho(nome)

    while (true) {
        println("\nO que você quer fazer?")
        println("1. Alimentar")
        println("2. Brincar")
        println("3. Descansar")
        println("4. Levar ao banheiro")
        println("5. Dar banho")
        println("6. Ver status")
        println("7. Sair")

        val opcao = readLine()?.toIntOrNull() ?: continue

        when (opcao) {
            1 -> pet.alimentar()
            2 -> pet.brincar()
            3 -> {
                print("Quantas horas ele vai descansar? ")
                val horas = readLine()?.toIntOrNull() ?: 0
                pet.descansar(horas)
            }
            4 -> pet.usarBanheiro()
            5 -> pet.tomarBanho()
            6 -> pet.mostrarStatus()
            7 -> {
                println("Até a próxima! :)")
                break
            }
            else -> println("Escolha uma opção válida.")
        }

        pet.passarTempo()

        if (pet.perdeu() || pet.venceu()) {
            break
        }
    }
}

