package im.dadoo.teak.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import im.dadoo.teak.mvc.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

	@Autowired
	private FileService fs;
	
	@RequestMapping(value = "/upload/image", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> uploadImage(@RequestParam MultipartFile filedata, 
			HttpSession session) throws IllegalStateException, IOException {
		Map<String, Object> result = new HashMap<String, Object>();
		if (filedata != null && filedata.getSize() > 0) {
			String root = session.getServletContext().getRealPath("/");
			String path = this.fs.save(filedata, root);
			result.put("msg", path);
			result.put("err", "");
		}
		else {
			result.put("err", "请勿上传空文件");
		}
		return result;
	}
}
