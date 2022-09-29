import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nc")
@Implements("User")
public class User implements Comparable {
	@ObfuscatedName("ln")
	@ObfuscatedSignature(
		descriptor = "Lkw;"
	)
	@Export("dragInventoryWidget")
	static Widget dragInventoryWidget;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lqo;"
	)
	@Export("username")
	Username username;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lqo;"
	)
	@Export("previousUsername")
	Username previousUsername;

	User() {
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Lnc;I)I",
		garbageValue = "-1401768476"
	)
	@Export("compareTo_user")
	public int compareTo_user(User var1) {
		return this.username.compareToTyped(var1.username);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		descriptor = "(I)Lqo;",
		garbageValue = "-697795421"
	)
	@Export("getUsername")
	public Username getUsername() {
		return this.username;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "-62"
	)
	@Export("getName")
	public String getName() {
		return this.username == null ? "" : this.username.getName();
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "115"
	)
	@Export("getPreviousName")
	public String getPreviousName() {
		return this.previousUsername == null ? "" : this.previousUsername.getName();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lqo;Lqo;I)V",
		garbageValue = "-1422962530"
	)
	@Export("set")
	void set(Username var1, Username var2) {
		if (var1 == null) {
			throw new NullPointerException();
		} else {
			this.username = var1;
			this.previousUsername = var2;
		}
	}

	public int compareTo(Object var1) {
		return this.compareTo_user((User)var1);
	}
}
