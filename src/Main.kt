import java.io.File

fun main() {
    val arquivo = File("Aval03/provinhaBarbadinha.txt")

    if (!arquivo.exists()) {
        println("Arquivo não encontrado!")
        return
    }

    val textoCifrado = arquivo.readText()
    val textoDecifrado = decifrarDeTeusPulos(textoCifrado)
    val textoComQuebras = textoDecifrado.replace("@", "\n")
    val palindromos = encontrarPalindromos(textoComQuebras)

    println("Texto cifrado:")
    println(textoCifrado)
    println("\nTexto decifrado:")
    println(textoComQuebras)
    println("\nPalíndromos encontrados:")
    println(palindromos)
}

fun decifrarDeTeusPulos(texto: String): String {
    val r = StringBuilder()
    for (i in texto.indices) {
        val chave = if (i % 5 == 0) 8 else 16
        r.append((texto[i].code - chave).toChar())
    }
    return r.toString()
}

fun encontrarPalindromos(texto: String): List<String> {
    val palavras = texto.split(Regex("\\s+"))
    val lista = mutableListOf<String>()
    for (p in palavras) {
        val limpo = p.lowercase().filter { it.isLetter() }
        if (limpo.length > 1 && limpo == limpo.reversed()) lista.add(p)
    }
    return lista
}
