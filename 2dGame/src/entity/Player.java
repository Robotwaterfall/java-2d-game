package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entitiy;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entitiy {
    GamePanel gp;
    KeyHandler keyH;


    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();// 1. load spriteSheet
        
        
    }

    public void setDefaultValues(){

        x = 100;
        y = 100;
        speed = 4;
    }

    public void createAnimationDown(){

      

        for (int index = 0; index < walkDownFrames.length; index++ ){

            walkDownFrames[index] = spriteSheet.getSubimage(
                index * 48,
                4 * 40, //row 5
                48, 
                40

            );

            

        }

    }


    public void createAnimationUp(){

      

        for (int index = 0; index < walkUpFrames.length; index++ ){

            walkUpFrames[index] = spriteSheet.getSubimage(
                index * 48,
                6 * 40, //row 3
                48, 
                40

            );

            

        }

    }

    public void createAnimationIdle(){

      

        for (int index = 0; index < idleFrames.length; index++ ){

            idleFrames[index] = spriteSheet.getSubimage(
                index * 48,
                0 * 40, 
                48, 
                40

            );

            

        }

    }

    public void createAnimationRight(){

        for (int index = 0; index < walkRightFrames.length; index++){

            walkRightFrames[index] = spriteSheet.getSubimage(
                index * 48,
                5 * 40, 
                48, 
                40

            );

        }
    }

    public void createAnimationLeft(){

        for (int index = 0; index < walkLeftFrames.length; index++){

            walkLeftFrames[index] = spriteSheet.getSubimage(
                index * 48,
                5 * 40, 
                48, 
                40

            );

        }
    }

    public void getPlayerImage() {

        try{

            spriteSheet = ImageIO.read(
                
                getClass().getResourceAsStream("/res/Player/player.png")
            );

        }catch(IOException e){

            e.printStackTrace();
            
        }

        
    }

    public void update(){

        if(keyH.upPressed == true){
            y -= speed; 
            direction = "up";
            moving = true;
            createAnimationUp();
            
        } else if(keyH.downPressed == true){
            y += speed; 
            direction = "down";
            moving = true;
            createAnimationDown();

        } else if(keyH.leftPressed == true){
            x -= speed;
            direction = "left";
            moving = true;
            createAnimationLeft();

        }else if(keyH.rightPressed == true){
            x += speed;
            direction = "right";
            moving = true;
            createAnimationRight();

        } else{

            downwardMoving = false;
            upwardMoving = false;
            direction = "idle";
            createAnimationIdle();
        }

        if (moving) {
            frameCounter++;
            if (frameCounter >= frameDelay) {
                frameCounter = 0;
        
                if ("down".equals(direction)) {
                    downFrameIndex = (downFrameIndex + 1) % walkDownFrames.length;
                    idleFrameIndex = 0;

                } else if ("up".equals(direction)) {
                    upFrameIndex = (upFrameIndex + 1) % walkUpFrames.length;
                    idleFrameIndex = 0;

                } else if("right".equals(direction)){
                    rightFrameIndex = (rightFrameIndex + 1) % walkRightFrames.length;
                    idleFrameIndex = 0;
                
                }else if("left".equals(direction)){
                    leftFrameIndex = (leftFrameIndex + 1) % walkLeftFrames.length;
                    idleFrameIndex = 0;
                    
                }else if ("idle".equals(direction)){
                    idleFrameIndex = (idleFrameIndex + 1) % idleFrames.length;
                    downFrameIndex = 0;
                    upFrameIndex = 0;
                    rightFrameIndex = 0;
                }
            }
        }
         

    }

    public void draw(Graphics2D g2){

        int scale = 2;

        int w = gp.tileSize * scale;
        int h = gp.tileSize * scale;
    
        BufferedImage frame = null;


        switch (direction) {   // direction = "up","down","left","right"
        case "up":
            frame = walkUpFrames[upFrameIndex];
            break;
        case "down":
            frame = walkDownFrames[downFrameIndex];
            break;
        case "right":
            frame = walkRightFrames[rightFrameIndex];
        break;
        case "left":
            g2.drawImage(walkLeftFrames[leftFrameIndex],
                x + w, y,
                -w, h,
                null);
        break;
        case "idle":
            frame = idleFrames[idleFrameIndex];
        
        } 

        g2.drawImage(frame, x, y, w, h, null);

    }
}

