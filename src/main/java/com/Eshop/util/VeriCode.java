package com.Eshop.util;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;


public class VeriCode {
    private static int width = 100;// width of the pic
    private static int height = 25;// height of the pic
    private static int codeCount = 4;// number of verification codes in the pic
    private static int xx = 15;
    private static int fontHeight = 18;
    private static  int codeY = 16;
    private static char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    
    /**
     * generate a set of map
     * code is the generated verification code
     * codePic is the BufferedImage object for verification code
     * @return
     */
    public static Map<String,Object> generateCodeAndPic() {
        // define image buffer
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // Graphics2D gd = buffImg.createGraphics();
        // Graphics2D gd = (Graphics2D) buffImg.getGraphics();
        Graphics gd = buffImg.getGraphics();
        //create a random value generator class
        Random random = new Random();
        //fill the pic with color white
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, width, height);

        //create font, the size of the font should be decided by the pic height
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
        // set the font
        gd.setFont(font);

        // draw the border
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, width - 1, height - 1);

        //generate 40 random distraction lines so that the verification code won't be recognized by machine
        gd.setColor(Color.BLACK);
        for (int i = 0; i < 30; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            gd.drawLine(x, y, x + xl, y + yl);
        }

        //randomCode is used to store the randomly generated veri code 
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;

        // generate random veri code
        for (int i = 0; i < codeCount; i++) {
        	//get the randomly generated veri number
            String code = String.valueOf(codeSequence[random.nextInt(36)]);
            //use randomly generated color value so that the color for each font won't be the same
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);

            //draw veri code with random generated color as one image
            gd.setColor(new Color(red, green, blue));
            gd.drawString(code, (i + 1) * xx, codeY);

            //combine 4 generated random value
            randomCode.append(code);
        }
        Map<String,Object> map  =new HashMap<String,Object>();
        //store the veri code
        map.put("code", randomCode);
        //BufferedImage object used to store the veri code
        map.put("codePic", buffImg);
        return map;
    }
}