package com.variedadesbyj.byj.servicio;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class CludinaryService {
    private final Cloudinary cloudinary;

    public CludinaryService(
            @Value("${cloudinary.cloud_name}") String cloudName,
            @Value("${cloudinary.api_key}") String apiKey,
            @Value("${cloudinary.api_secret}") String apiSecret) {

        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret,
                "secure", true
        ));
    }
    public String uploadFile(MultipartFile file) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        return (String) uploadResult.get("secure_url");
    }
    // Método para eliminar imágenes por URL
    public void eliminarImagenesPorUrls(List<String> urls) {
        for (String url : urls) {
            String publicId = extraerPublicIdDeUrl(url);
            if (publicId != null) {
                try {
                    Map result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
                    System.out.println("Eliminada: " + publicId + " - Resultado: " + result);
                } catch (Exception e) {
                    System.err.println("Error eliminando: " + publicId);
                    e.printStackTrace();
                }
            } else {
                System.err.println("No se pudo extraer el public_id de la URL: " + url);
            }
        }
    }

    // Método para extraer el public_id desde la URL
    private String extraerPublicIdDeUrl(String url) {
        try {
            // Encuentra la parte después de "/upload/"
            int indexDeUpload = url.indexOf("/upload/");
            if (indexDeUpload == -1) {
                throw new IllegalArgumentException("La URL no tiene el formato esperado.");
            }

            // Obtén la parte de la URL después de "/upload/"
            String subUrl = url.substring(indexDeUpload + 8); // 8 = longitud de "/upload/"

            // Elimina la versión (por ejemplo, "v123456789/"), si existe
            if (subUrl.startsWith("v")) {
                int indexSlash = subUrl.indexOf("/");
                if (indexSlash != -1) {
                    subUrl = subUrl.substring(indexSlash + 1);
                }
            }

            // Elimina la extensión (.jpg, .png, etc.)
            int indexDeExtension = subUrl.lastIndexOf(".");
            if (indexDeExtension != -1) {
                subUrl = subUrl.substring(0, indexDeExtension);
            }
            System.out.println(subUrl);
            return subUrl;
        } catch (Exception e) {
            System.err.println("Error al extraer el public_id de la URL: " + url);
            e.printStackTrace();
            return null;
        }
    }
}
