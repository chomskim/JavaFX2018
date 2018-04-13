/**
 * Created on Mar 9, 2018
 * @author cskim -- hufs.ac.kr, Dept of CES
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.util;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ImageUtils {
	
	static public Image getOneColorImage (double width, double height, Color color){
		WritableImage  result = new WritableImage ((int)width, (int)height);
		PixelWriter pwriter = result.getPixelWriter(); 
		
	    for (int y = 0; y < height; y++) {
	      for (int x = 0; x < width; x++) {
	    	  pwriter.setColor(x, y, color);
	      }
	    }
		
		return result;
	}
	static public Color getAverageColor(Image tile){
		
		PixelReader pixelReader = tile.getPixelReader(); 
		
		double twidth = tile.getWidth();
		double theight =  tile.getHeight();
		double pixSize = twidth*theight;
		double sumRed = 0;
		double sumGreen = 0;
		double sumBlue = 0;

		for (int i=0; i<theight; ++i){
			for (int j=0; j<twidth; ++j){
				Color pixColor = pixelReader.getColor(i,j);
				sumRed += pixColor.getRed();
				sumGreen += pixColor.getGreen();
				sumBlue += pixColor.getBlue();
			}
		}
		double avgRed = sumRed/pixSize;
		double avgGreen = sumGreen/pixSize;
		double avgBlue = sumBlue/pixSize;
		return Color.color(avgRed, avgGreen, avgBlue);
	}

	static public Image getSubImage(Image origImage, int x, int y, int width, int height) {
		PixelReader reader = origImage.getPixelReader();
		WritableImage newImage = new WritableImage(reader, x, y, width, height);
		
		return newImage;
	}

}
