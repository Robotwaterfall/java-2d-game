package main;

import entity.Entitiy;

public class collisionChecker {

    GamePanel gp;

    public collisionChecker(GamePanel gp){

        this.gp = gp;


    }

    public void checkTile(Entitiy entitiy){

        int entitiyLeftWorldX = entitiy.worldX + entitiy.solidArea.x;
        int entitiyRightWorldX = entitiy.worldX + entitiy.solidArea.x + entitiy.solidArea.width;
        int entitiyTopWorldY = entitiy.worldY + entitiy.solidArea.y;
        int entitiyBottomWorldY = entitiy.worldY + entitiy.solidArea.y + entitiy.solidArea.height;

        int entitiyLeftCol = entitiyLeftWorldX/gp.tileSize;
        int entitiyRightCol = entitiyRightWorldX/gp.tileSize;
        int entitiyTopRow = entitiyTopWorldY/gp.tileSize;
        int entitiyBottomRow = entitiyBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch(entitiy.direction){
            case "up":
                entitiyTopRow = (entitiyTopWorldY - entitiy.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entitiyLeftCol][entitiyTopRow];
                tileNum2 = gp.tileM.mapTileNum[entitiyRightCol][entitiyTopRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){

                    entitiy.collisionOn = true;

                }

                break;
            case "down":
            entitiyBottomRow = (entitiyBottomWorldY + entitiy.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entitiyLeftCol][entitiyBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entitiyRightCol][entitiyBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){

                    entitiy.collisionOn = true;

                }

                break;
            case "left":
            entitiyLeftCol = (entitiyLeftWorldX - entitiy.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entitiyLeftCol][entitiyTopRow];
                tileNum2 = gp.tileM.mapTileNum[entitiyLeftCol][entitiyBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){

                    entitiy.collisionOn = true;

                }

                break;
            case "right":
            entitiyRightCol = (entitiyRightWorldX + entitiy.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entitiyRightCol][entitiyTopRow];
                tileNum2 = gp.tileM.mapTileNum[entitiyRightCol][entitiyBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){

                    entitiy.collisionOn = true;

                }

                break;
        }


    }

}
