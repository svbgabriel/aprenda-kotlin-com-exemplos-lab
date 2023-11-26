// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val idade: Int, val cpf: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()
    
    fun adicionarConteudo(conteudo: ConteudoEducacional) = conteudos.add(conteudo)
    fun removerConteudo(conteudo: ConteudoEducacional) = conteudos.remove(conteudo)
    
    fun printConteudos() = println("Conteudos da formação: $conteudos")
    
    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            println("Usuário ${usuario.nome} já está matriculado na formação $nome!")
            return;
        }
        
        inscritos.add(usuario);
        println("Usuário ${usuario.nome} foi matriculado na formação $nome com sucesso!")
    }
}

fun main() {
    val usuario1 = Usuario("João", 23, "11111111111")
    val usuario2 = Usuario("Pedro", 32, "11111111112")
    val usuario3 = Usuario("Maria", 40, "11111111113")
    
    val formacao1 = Formacao("Iniciando com Kotlin")
    val formacao2 = Formacao("Rust Avançado")
    val formacao3 = Formacao("Iniciando rápido com Go")
    
    val conteudoKotlin1 = ConteudoEducacional("Variáveis em Kotlin", 10)
    val conteudoKotlin2 = ConteudoEducacional("Funções em Kotlin", 20)
    val conteudoRust1 = ConteudoEducacional("O que é Ownership", 20)
    val conteudoGo1 = ConteudoEducacional("Variáveis em Go", 5)
    
    // Adiciona os conteúdos para a formação de Kotlin
    formacao1.adicionarConteudo(conteudoKotlin1)
    formacao1.adicionarConteudo(conteudoKotlin2)
    formacao1.adicionarConteudo(conteudoRust1)
    formacao1.printConteudos()
    // Ops um conteúdo errado foi adicionado
    formacao1.removerConteudo(conteudoRust1)
    // Corrigido!
    formacao1.printConteudos()
    formacao2.adicionarConteudo(conteudoRust1)
    formacao2.printConteudos()
    formacao3.adicionarConteudo(conteudoGo1)
    formacao3.printConteudos()
    
    // Matricula os alunos
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario1)
    formacao3.matricular(usuario2)
    formacao2.matricular(usuario3)
    formacao2.matricular(usuario2)
}
