package pl.backlog.green;

import org.opencv.core.Mat;

import static org.opencv.core.Core.NATIVE_LIBRARY_NAME;
import static org.opencv.core.Core.addWeighted;
import static org.opencv.imgcodecs.Imgcodecs.*;
import static org.opencv.imgproc.Imgproc.*;

public class PutWatermarkOnImage {
    public static void main(String[] args) {
        System.loadLibrary(NATIVE_LIBRARY_NAME);

        Mat image = imread("resources/inputImage.jpg", IMREAD_COLOR);
        cvtColor(image, image, COLOR_BGR2BGRA);

        Mat watermark = imread("resources/watermark.png", IMREAD_UNCHANGED);
        resize(watermark, watermark, image.size());

        Mat result = new Mat();
        addWeighted(image, 1, watermark, 1, 0, result);
        imwrite("resources/finalImage.png", result);
    }
}
