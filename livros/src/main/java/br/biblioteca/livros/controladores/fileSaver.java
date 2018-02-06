package br.biblioteca.livros.controladores;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileSaver {
	public static String write(String baseFolder, MultipartFile file) {
		String realPath = "C:\\Users\\lukas\\eclipse-workspace\\livros\\src\\main\\resources\\uploads\\" + baseFolder;
		// se for mac, verificar corretamenteo path da pasta, por exemplo
		// String realPath = "/Volumes/Arquivos/FIB/POS/workspace/livros/" + baseFolder;
		File folder = new File(realPath);
		if(!folder.exists()){
		folder.mkdirs();
		}
		try {
		String path = realPath + "/" + file.getOriginalFilename();
		file.transferTo(new File(path));
		return baseFolder + "/" + file.getOriginalFilename();
		} catch (IOException e) {
		throw new RuntimeException(e);
		}
		}

}
