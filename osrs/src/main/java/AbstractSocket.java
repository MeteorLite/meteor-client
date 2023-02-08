import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ov")
@Implements("AbstractSocket")
public abstract class AbstractSocket {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(II)Z",
            garbageValue = "-38626951"
    )
    public abstract boolean isAvailable(int var1) throws IOException;

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "50"
    )
    public abstract int available() throws IOException;

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1455058201"
    )
    public abstract int readUnsignedByte() throws IOException;

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "([BIII)I",
            garbageValue = "2061560315"
    )
    public abstract int read(byte[] var1, int var2, int var3) throws IOException;

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "([BIIS)V",
            garbageValue = "26113"
    )
    public abstract void write(byte[] var1, int var2, int var3) throws IOException;

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "2"
    )
    public abstract void close();
}
