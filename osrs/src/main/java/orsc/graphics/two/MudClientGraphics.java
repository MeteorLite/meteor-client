package orsc.graphics.two;

import com.openrsc.client.entityhandling.EntityHandler;
import com.openrsc.client.model.Sprite;

import orsc.Config;
import orsc.mudclient;
import orsc.util.GenUtil;

public final class MudClientGraphics extends GraphicsController {
	public static mudclient mudClient;

	public MudClientGraphics(int var1, int var2, int var3) {
		super(var1, var2, var3);
	}

	@Override
	public final void drawEntity(int index, int x, int y, int width, int height, int overlayMovement, int topPixelSkew) {
		try {
			if (Config.S_WANT_BANK_NOTES && index == -1) {
				mudClient.drawItemAt(-1, x, y, width, height, topPixelSkew);
			}
			else if (index < 50000) {
				if (index < 40000) {
					if (index >= 20000) {
						mudClient.drawNPC(index - 20000, x, y, width, height, topPixelSkew, 105,
							overlayMovement);
					} else if (index < 5000) {
						Sprite projectile = spriteSelect(EntityHandler.projectiles.get(index-mudclient.spriteProjectile));
						super.drawSprite(projectile, x, y, width, height, 5924);
					} else {
						mudClient.drawPlayer(index - 5000, x, y, width, height, topPixelSkew, 20,
							overlayMovement);
					}
				} else {
					mudClient.drawItemAt(index - 40000, x, y, width, height, topPixelSkew);
				}
			} else {
				mudClient.drawTeleportBubble(index - 50000, x, y, width, height, topPixelSkew, 2);
			}
		} catch (RuntimeException var10) {
			throw GenUtil.makeThrowable(var10, "ba.B(" + overlayMovement + ',' + index + ',' + height + ',' + x + ','
				+ y + ',' + width + ',' + 29 + ',' + topPixelSkew + ')');
		}
	}
}
