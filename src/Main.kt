import java.io.File

fun main() {
    val arquivo = File("Aval03/provinhaBarbadinha.txt")

    if (!arquivo.exists()) {
        println("Arquivo não encontrado!")
        return
    }

    val texto = arquivo.readText()
    println(texto)
}
