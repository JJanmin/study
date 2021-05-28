package upload.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class SpringFileWriter {
	FileOutputStream fos;
	
	public String writeFile(MultipartFile file, String path)
	{
		//저장할 파일명 구하는데 예를 들어 a.jpg
		//file1234_a.jpg 이런 식으로 저장
		long time=new Date().getTime(); //시간을 초르 환산해서 숫자로 반환
		//저장할 파일명
		String fileName="file"+time+"_"+file.getOriginalFilename();
		
		//path 폴더에 저장
		try {
			byte [] fileData=file.getBytes(); //이미지는 저장할때 byte로 바꿔야함
			fos=new FileOutputStream(path+"\\"+fileName);
			fos.write(fileData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fos!=null)
				try {
					fos.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
		}
		return fileName; //업로드된 파일명을 컨트롤러로 보낸다
	}
}
