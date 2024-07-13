package com.realnet.FileUpload.Services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileuploadService {
	@Value("${projectPath}")
	private String projectPath;

	public boolean uploadFile(MultipartFile multipartFile, String addString) {
		boolean f = false;
		String UPLOAD_DIREC = File.separator + "Resources" + File.separator + "Files";
		String originalFilename = multipartFile.getOriginalFilename();

		String filetype = originalFilename.substring(originalFilename.lastIndexOf("."));
		String filename = originalFilename.substring(0, originalFilename.lastIndexOf(".")) + addString;
		String replacedfilename = filename + filetype;

		System.out.println("file name is ..." + replacedfilename);
		String Path1 = projectPath + UPLOAD_DIREC;

		String filepath = Path1 + File.separator + replacedfilename;

		try {

			if (!UPLOAD_DIREC.isEmpty()) {

				File projectdir = new File(Path1);
				if (!projectdir.exists()) {
					boolean mkdir = projectdir.mkdirs();
					System.out.println(Path1 + "  folder create =  " + mkdir);
				}

//				File file = new File(Path1);
//				if (!file.exists()) {
//					file.createNewFile();
//				}

//				System.out.println("\\" + ":" + "\\\\");

//				UPLOAD_DIREC = UPLOAD_DIREC.replaceAll("\\\\", File.separator);
//				UPLOAD_DIREC = UPLOAD_DIREC.replaceAll("//", File.separator);
//				if (!UPLOAD_DIREC.startsWith(File.separator)) {
//					UPLOAD_DIREC = File.separator + UPLOAD_DIREC;
//				}
//				ArrayList<Object> list = new ArrayList<>();
//
//				String liString = UPLOAD_DIREC;
//				String Path1 = projectPath;
//
//				int i = 0;
//				do {
//
//					int lastIndexOf = liString.lastIndexOf(File.separator);
//
//					String substring = liString.substring(lastIndexOf + 1);
//					list.add(substring);
//
//					System.out.println(substring);
//
//					liString = liString.substring(0, lastIndexOf);
//
//					System.out.println("step " + i + " = " + liString);
//					i++;
//
//				} while (liString.contains(File.separator));
//
//				for (int j = list.size() - 1; j >= 0; j--) {
//					Path1 = Path1 + File.separator + list.get(j);
//					File projectdir = new File(Path1);
//					if (!projectdir.exists()) {
//						boolean mkdir = projectdir.mkdirs();
//						System.out.println(Path1 + "  folder create =  " + mkdir);
//					}
//				}
			}
			// reading data
			InputStream is = multipartFile.getInputStream();
			byte data[] = new byte[is.available()];
			is.read(data);

			// writing data

			FileOutputStream fos = new FileOutputStream(filepath);
			fos.write(data);
			fos.close();
			fos.flush();
			f = true;

		} catch (Exception e) {

			log.error(e.getLocalizedMessage());
		}
		return f;
	}

}
