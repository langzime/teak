package im.dadoo.teak.mvc.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	private static final String ROOT_DIR = "\\WEB-INF\\static\\";
	private static final String FILE_ROOT_URL = "\\static\\";
	
	public String save(MultipartFile file, String rootPath) throws IllegalStateException, IOException {
		if (!file.isEmpty()) {
			String filename = "" + System.currentTimeMillis() + "-" + file.getOriginalFilename();
			String filepath = rootPath + ROOT_DIR + filename;
			File localFile = new File(filepath);
			localFile.mkdirs();
			localFile.createNewFile();
			
			file.transferTo(localFile);
			System.out.println(filepath);
			return FILE_ROOT_URL + filename;
		}
		else {
			return null;
		}
	}
}
