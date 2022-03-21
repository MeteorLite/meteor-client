package dev.hoot.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TileFlag
{
	private int x;
	private int y;
	private int z;
	private int flag;
	private int region;
}
