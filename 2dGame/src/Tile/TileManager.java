package Tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;

import main.GamePanel;

public class TileManager {

    GamePanel gp;
    Tiles[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp = gp;

        tile = new Tiles[10]; // creates 10 kinds of tiles
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/res/Maps/world01.txt");
    }

    public void getTileImage(){

        try{

            tile[0] = new Tiles();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/tile_0000.png/")); // grass

            tile[1] = new Tiles();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/tile_0043.png/")); // cobble stone pathway

            tile[2] = new Tiles();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/tile_0001.png/")); // grassey Leave area

            tile[3] = new Tiles();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Water.png/")); // water

            tile[4] = new Tiles();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Tree.png/")); // tree

            tile[5] = new Tiles();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/tile_0126.png/")); // cobble stone

            tile[6] = new Tiles();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/res/Tiles/Sand.png/")); // Sand


        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void loadMap(String filePath){
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){

                String line = br.readLine();

                while (col < gp.maxWorldCol ){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]); // use col as an index for the array

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
            
        }catch(Exception e){

        }
    }

    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;
    

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){


            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if( worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY
            ){
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }

            worldCol++;
        

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow ++;
            }
        }

    }

}
