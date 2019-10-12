import org.apache.commons.codec.binary.Hex
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class Main

    fun main (args: Array<String>) {
        println("Caso 1:")
        print("Conteúdo: ")
        val encrypt = encrypt("ABCDE", "FURB")
        println("Size " + encrypt.length)
        println("")

        println("Caso 2:")
        print("Conteúdo: ")
        val encrypt1 = encrypt("ABCDE", "COMPUTADOR")
        println("Size " + encrypt1.length)
        println("")

        println("Caso 3:")
        print("Conteúdo: ")
        val encrypt2 = encrypt("ABCDE", "SABONETE")
        println("Size " + encrypt2.length)
        println("")

        println("Caso 4:")
        print("Conteúdo: ")
        val encrypt3 = encrypt("ABCDE", "SABONETESABONETESABONETE")
        println("Size " + encrypt3.length)
        println("")

        println("Caso 5")
        print("Conteúdo: ")
        val encrypt4 = encrypt("ABCDE", "FURB","CBC")
        println("Size " + encrypt4.length)
        println("")
        print("Decrifrado: " )
        decrypt("ABCDE", "FURB", "CBC")
        println("")

        println("Caso 6")
        print("Conteúdo: ")
        val encrypt5 = encrypt("ABCDE", "FURB", "CBC", true, byteArrayOf(1, 1, 2, 2, 3, 3, 4, 4))
        println("Size " + encrypt5.length)
        println("")

        println("Caso 7")
        print("Conteúdo: ")
        val encrypt6 = encrypt("ABCDE","SABONETESABONETESABONETE","CBC", true, byteArrayOf(1, 1, 2, 2, 3, 3, 4, 4))
        println("Size " + encrypt6.length)
        println("")

        println("Caso 8")
        print("Conteúdo: ")
        val encrypt7 = encrypt("ABCDE","SABONETESABONETESABONETE","CBC", true, byteArrayOf(10,20,30,40,50,60,70,80))
        println("Size " + encrypt7.length)
        println("")

        println("Caso 9")
        print("Conteúdo: ")
        val encrypt8 = encrypt("ABCDE", "FURB")
        println("Size: " + encrypt8.length)
        print("Descriptografado: ")
        decrypt("11111", encrypt8)
    }

    fun encrypt(key: String, text: String, type: String = "ECB", usesIv: Boolean = false, iv: ByteArray? = null): String {

        val secretKeySpec = SecretKeySpec(key.toByteArray(), "Blowfish")
        val cipher = Cipher.getInstance("Blowfish/" + type + "/PKCS5Padding")

        if (usesIv) {
            val ivParam = IvParameterSpec(iv)
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParam)
        } else {
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec)
        }

        val encrypted = cipher.doFinal(text.toByteArray())
        println(Hex.encodeHexString(encrypted))

        return Hex.encodeHexString(encrypted)

    }

    fun decrypt(key: String, text: String, type: String = "ECB") {

        val secretKeySpec = SecretKeySpec(key.toByteArray(), "Blowfish")
        val cipher = Cipher.getInstance("Blowfish/" + type + "/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec)
        val decrypted = cipher.doFinal(text.toByteArray());
        println(decrypted);
    }
