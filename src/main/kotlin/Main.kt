import org.apache.commons.codec.binary.Hex
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class Main

    fun main (args: Array<String>) {

        val secreKey = generateSecretKeySpec("ABCDE")

        println("Caso 1:")
        print("Conteúdo: ")
        val encrypt = encrypt(secreKey, "FURB")
        println("Size " + encrypt.length)
        println("")

        println("Caso 2:")
        print("Conteúdo: ")
        val encrypt1 = encrypt(secreKey, "COMPUTADOR")
        println("Size " + encrypt1.length)
        println("")

        println("Caso 3:")
        print("Conteúdo: ")
        val encrypt2 = encrypt(secreKey, "SABONETE")
        println("Size " + encrypt2.length)
        println("")

        println("Caso 4:")
        print("Conteúdo: ")
        val encrypt3 = encrypt(secreKey, "SABONETESABONETESABONETE")
        println("Size " + encrypt3.length)
        println("")

        println("Caso 5")
        print("Conteúdo: ")
        val encrypt4 = encrypt(secreKey, "FURB","CBC")
        println("Size " + encrypt4.length)
        println("")
//        print("Decrifrado: " )
//        decrypt("ABCDE", "FURB", "CBC")
//        println("")

        println("Caso 6")
        print("Conteúdo: ")
        val encrypt5 = encrypt(secreKey, "FURB", "CBC", true, IvParameterSpec(byteArrayOf(1, 1, 2, 2, 3, 3, 4, 4)))
        println("Size " + encrypt5.length)
        println("")

        println("Caso 7")
        print("Conteúdo: ")
        val encrypt6 = encrypt(secreKey,"SABONETESABONETESABONETE","CBC", true, IvParameterSpec(byteArrayOf(1, 1, 2, 2, 3, 3, 4, 4)))
        println("Size " + encrypt6.length)
        println("")

        println("Caso 8")
        print("Conteúdo: ")
        val ivParamUnique = IvParameterSpec(byteArrayOf(10,20,30,40,50,60,70,80))
        val encrypt7 = encrypt(secreKey,"SABONETESABONETESABONETE","CBC", true, ivParamUnique)
        println("Size " + encrypt7.length)
        println("")
        print("Decript: ")
        decrypt(secreKey, encrypt7, "CBC", true, ivParamUnique)
        println("")

        println("Caso 9")
        print("Conteúdo: ")
        val encrypt8 = encrypt(secreKey, "FURB")
        println("Size: " + encrypt8.length)
        print("Descriptografado: ")
        decrypt(generateSecretKeySpec("11111"), encrypt8)
    }

    fun encrypt(secretKeySpec: SecretKeySpec, text: String, type: String = "ECB", usesIv: Boolean = false, iv: IvParameterSpec? = null): String {

        val cipher = Cipher.getInstance("Blowfish/" + type + "/PKCS5Padding")

        if (usesIv) {
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv)
        } else {
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec)
        }

        val encrypted = cipher.doFinal(text.toByteArray())
        println(Hex.encodeHexString(encrypted))

        return Hex.encodeHexString(encrypted)

    }

    fun decrypt(secretKeySpec: SecretKeySpec, text: String, type: String = "ECB", usesIv: Boolean = false, iv: IvParameterSpec? = null) {

        val cipher = Cipher.getInstance("Blowfish/" + type + "/PKCS5Padding")

        if (usesIv) {
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv)
        } else {
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec)
        }
        val decrypted = cipher.doFinal(Hex.decodeHex(text))

        println(String(decrypted))
    }

    fun generateSecretKeySpec(key: String): SecretKeySpec {
        val secretKeySpec = SecretKeySpec(key.toByteArray(), "Blowfish")
        return secretKeySpec
    }
