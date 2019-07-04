/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aspose.imaging.examples.images;

import com.aspose.imaging.Image;
import com.aspose.imaging.RasterImage;
import com.aspose.imaging.Rectangle;
import com.aspose.imaging.examples.Utils;
import com.aspose.imaging.fileformats.svg.SvgImage;
import com.aspose.imaging.fileformats.svg.graphics.SvgGraphics2D;

/**
 *
 * @author mfazi
 */
public class DrawRasterImageOnSVG {
    
    public static void main(String[] args)  {
         
         //ExStart:DrawRasterImageOnSVG
     
        String dir = Utils.getSharedDataDir(DrawRasterImageOnSVG.class) + "images/";
        
        RasterImage imageToDraw = (RasterImage)Image.load(dir + "asposenet_220_src01.png");
        try
        {
            // Load the image for drawing on it (drawing surface)
            SvgImage  canvasImage = (SvgImage )Image.load(dir + "asposenet_220_src02.svg");
            try
            {
                SvgGraphics2D graphics = new SvgGraphics2D(canvasImage);

                // Draw a rectagular part of the raster image within the specified bounds of the vector image (drawing surface).
                // Note that because the source size is not equal to the destination one, the drawn image is stretched horizontally and vertically.
                graphics.drawImage(
                        new Rectangle(0, 0, imageToDraw.getWidth(), imageToDraw.getHeight()),
                        new Rectangle(67, 67, imageToDraw.getWidth(), imageToDraw.getHeight()),
                        imageToDraw);

                // Save the result image
                SvgImage  resultImage = graphics.endRecording();
                try
                {
                    resultImage.save(dir + "asposenet_220_src02.DrawImage.svg");
                }
                finally
                {
                    resultImage.close();
                }
            }
            finally
            {
                canvasImage.close();
            }
        }
        finally
        {
            imageToDraw.close();
        }
        //ExEnd:DrawRasterImageOnSVG
    }
    
}
