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

    val numeroCaracteres =
    val quantidadePalavras =

    println("Texto cifrado:")
    println(textoCifrado)
    println("Palíndromos encontrados:")
    println(palindromos)
}

fun decifrarDeTeusPulos(texto: String): String {
    val r = StringBuilder()
    for (i in texto.indices) {
        val chave = if (i % 5 == 0) 8 else 16
        val novo = texto[i].code - chave
        r.append(novo.toChar())
    }
    return r.toString()
}

fun encontrarPalindromos(texto: String): List<String> {
    val palavras = texto.split(Regex("\\s+"))
    val lista = mutableListOf<String>()
    for (p in palavras) {
        val limpo = p.lowercase().filter { it.isLetter() }
        if (limpo.length > 1 && ehPalindromo(limpo)) lista.add(p)
    }
    return lista
}

fun ehPalindromo(p: String): Boolean {
    var i = 0
    var j = p.length - 1
    while (i < j) {
        if (p[i] != p[j]) return false
        i++
        j--
    }
    return true
}
