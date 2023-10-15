package com.example.helloworld;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet(name = "ImageUpload" , value = "/imageUpload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class ImageUpload extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<Part> fileParts = request.getParts();

        String uploadDirectory = "D:\\images";

        for (Part filePart : fileParts) {
            System.out.println(filePart.getName());
            String fileName = getSubmittedFileName(filePart);

            if (fileName != null) {
                String filePath = uploadDirectory + File.separator + fileName;

                try (InputStream input = filePart.getInputStream();
                     OutputStream output = new FileOutputStream(filePath)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = input.read(buffer)) > 0) {
                        output.write(buffer, 0, length);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("File uploaded: " + filePath);
            }
        }
        response.getWriter().print("The files uploaded successfully.");
    }
    private String getSubmittedFileName(Part filePart) {
        for (String contentDisposition : filePart.getHeader("content-disposition").split(";")) {
            if (contentDisposition.trim().startsWith("filename")) {
                return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
