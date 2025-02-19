package ktnostr.crypto
import fr.acinq.secp256k1.Hex
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class CryptoUtilsTest {
    @Test
    fun testGetPublicKey() {
        val secKeyHex = "6ba903b7888191180a0959a6d286b9d0719d33a47395c519ba107470412d2069"
        val pubKeyHex = "8565b1a5a63ae21689b80eadd46f6493a3ed393494bb19d0854823a757d8f35f"
        val secKeyBytes = Hex.decode(secKeyHex)
        val actualPubKeyBytes = CryptoUtils.getPublicKey(secKeyBytes)
        val actualPubKeyHex = Hex.encode(actualPubKeyBytes)
        assertEquals(pubKeyHex, actualPubKeyHex, "PubKeys do not match!")
    }

    @Test
    fun testContentHash() {
        val content = "Kotlin"
        val hashHex = "c78f6c97923e81a2f04f09c5e87b69e085c1e47066a1136b5f590bfde696e2eb"
        val actualHashHex = CryptoUtils.contentHash(content).toHexString()
        assertEquals(hashHex, actualHashHex, "Hashes do not match!")
    }
}
