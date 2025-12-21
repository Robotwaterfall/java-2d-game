package entity;

import java.awt.image.BufferedImage;

public class Entitiy {

    public int worldX, worldY;
    public int speed;

    public boolean downwardMoving = false;
    public boolean upwardMoving = false;
    public boolean rightMoving = false;
    public boolean leftMoving = false;

    public boolean moving = false;

    public BufferedImage spriteSheet;
    public String direction = "idle"; 


    public BufferedImage[] walkDownFrames = new BufferedImage[6]; // the amount per row
    public BufferedImage[] walkUpFrames = new BufferedImage[6]; // the amount per row
    public BufferedImage[] idleFrames = new BufferedImage[6];
    public BufferedImage[] walkRightFrames = new BufferedImage[6];
    public BufferedImage[] walkLeftFrames = new BufferedImage[6];

    public BufferedImage[] attackFrames = new BufferedImage[4];


    int downFrameIndex = 0;
    int upFrameIndex   = 0;
    int idleFrameIndex = 0;
    int rightFrameIndex = 0;
    int leftFrameIndex = 0;
    int attackFrameIndex = 0;

    int frameCounter   = 0;
    int frameDelay     = 10;   // bigger = slower animation


}
