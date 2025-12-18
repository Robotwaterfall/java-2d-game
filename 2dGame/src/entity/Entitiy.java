package entity;

import java.awt.image.BufferedImage;

public class Entitiy {

    public int x, y;
    public int speed;

    public boolean downwardMoving = false;
    public boolean upwardMoving = false;

    public boolean moving = false;

    public BufferedImage spriteSheet;
    public String direction = "down"; 


    public BufferedImage[] walkDownFrames = new BufferedImage[6]; // the amount per row
    public BufferedImage[] walkUpFrames = new BufferedImage[6]; // the amount per row


    int downFrameIndex = 0;
    int upFrameIndex   = 0;
    int frameCounter   = 0;
    int frameDelay     = 10;   // bigger = slower animation


}
