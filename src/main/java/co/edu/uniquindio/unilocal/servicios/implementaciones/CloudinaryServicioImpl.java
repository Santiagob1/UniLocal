package co.edu.uniquindio.unilocal.servicios.implementaciones;

import co.edu.uniquindio.unilocal.servicios.interfaces.CloudinaryServicio;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CloudinaryServicioImpl implements CloudinaryServicio {
    private final Cloudinary cloudinary;
    public CloudinaryServicioImpl(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dgy7ziwcu");
        config.put("api_key", "694643844847689");
        config.put("api_secret", "K_cekVK6gR27kzT5W-7CqoB1e7s");
        cloudinary = new Cloudinary(config);
    }
    @Override
    public Map subirImagen(File file, String carpeta) throws Exception{

        return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder",
                String.format("uniquindio/unilocal/%s", carpeta)));
    }
    @Override
    public Map eliminarImagen(String idImagen) throws Exception{
        return cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
    }
    @Override
    public File convertir(MultipartFile imagen) throws IOException {
        File file = File.createTempFile(imagen.getOriginalFilename(), null);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagen.getBytes());
        fos.close();
        return file;
    }
}
