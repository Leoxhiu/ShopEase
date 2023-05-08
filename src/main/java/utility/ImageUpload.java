package utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUpload {

//    public static byte[] getImageAsByte(String filepath) throws IOException {
//        File fi = new File("/profile.svg");
//        System.out.println(new File(".").getAbsoluteFile());
//        byte[] fileContent = Files.readAllBytes(fi.toPath());
//
//        return fileContent;
//    }

    public static byte[] getImageAsByte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, len);
        }
        return byteArrayOutputStream.toByteArray();
    }

}
