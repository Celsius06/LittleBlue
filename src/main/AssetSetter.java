// Parent class handles the placement of the objects
package main;

import object.OBJ_Key;

public class AssetSetter {
	GamePanel gp;
	// Constructor
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	// Methods
	public void setObject() {
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 23 * gp.tileSize;
		gp.obj[0].worldY = 7 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldX = 23 * gp.tileSize;
		gp.obj[1].worldY = 40 * gp.tileSize;
	}
}
