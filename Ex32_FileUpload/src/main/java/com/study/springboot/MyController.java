package com.study.springboot;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

//libs/json-simple-1.1.1.jar 안에 있는 것을 사용
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "FileUpload";
    }

	@RequestMapping("/uploadForm")
	public String uploadForm(){
		
		return "FileUpload/fileForm";
	}

	@RequestMapping("/uploadOk")
	public @ResponseBody String uploadOk(HttpServletRequest request)
	{
		// JSON 객체 변수를 만든다.
		JSONObject obj = new JSONObject();

		try {
			String  filePath = ResourceUtils
					  .getFile("classpath:static/upload/").toPath().toString();
			System.out.println(filePath);
			
			// Retrieves <input type="file" name="files" mutiple="true">
			List<Part> fileParts = request.getParts().stream()
					.filter(part -> "filename".equals(part.getName()) && part.getSize() > 0)
					.collect(Collectors.toList());
			for (Part filePart : fileParts) {
				String fileName = Paths.get(filePart.getSubmittedFileName())
						.getFileName().toString();
				String dst = filePath + "\\" + fileName;
				
				try (BufferedInputStream fin =
						new BufferedInputStream(filePart.getInputStream());
					BufferedOutputStream fout = 
						new BufferedOutputStream(new FileOutputStream(dst)))
				{
					int data;
					while (true)
					{
						data = fin.read();
						if(data== -1)
							break;
						fout.write(data);
					}
				}catch(IOException e)
				{
					e.printStackTrace();
				}
				System.out.println("Uploaded: " + dst + "<br>");
			}
			obj.put("success", "1");
			obj.put("desc", "업로드 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("success","0");
			obj.put("desc", "업로드 실패");
		}

		return obj.toJSONString();
	}
}

