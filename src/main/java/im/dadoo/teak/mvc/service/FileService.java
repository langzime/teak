package im.dadoo.teak.mvc.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	public String save(MultipartFile file) throws IllegalStateException, IOException {
		if (!file.isEmpty()) {
			String filename = "" + System.currentTimeMillis() + "-" + file.getOriginalFilename();
			String filepath = "static/images/" + filename;
			File localFile = new File(filepath);
			file.transferTo(localFile);
			return localFile.getAbsolutePath();
		}
		else {
			return null;
		}
	}
}
