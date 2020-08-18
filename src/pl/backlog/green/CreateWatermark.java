package pl.backlog.green;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class CreateWatermark {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat image = new Mat(200, 200, CvType.CV_8UC4);

        String text = "Doktor Ziel";
        Point position = new Point(10, 110);
        Scalar color = new Scalar(90, 60, 90, 255);
        int font = Imgproc.FONT_HERSHEY_SIMPLEX;
        int scale = 1;
        int thickness = 4;
        Imgproc.putText(image,text, position, font, scale, color, thickness);

        Imgcodecs.imwrite("resources/watermark.png", image);
    }
}
