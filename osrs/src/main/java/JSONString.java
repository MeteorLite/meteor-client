import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@Implements("JSONString")
@ObfuscatedName("org/json/JSONString")
public interface JSONString {
	@Export("toJSONString")
	@ObfuscatedName("toJSONString")
	String toJSONString();
}
