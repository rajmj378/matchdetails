package com.rab3.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LogoService {

	public String uploadLogo(MultipartFile file, String name) throws Exception {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = "/Users/abinash/Documents";
				File dir = new File(rootPath + File.separator + "team-logos");

				// Create the file on server
				String absoluteFileName = dir.getAbsolutePath() + File.separator + name;
				File serverFile = new File(absoluteFileName);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("Server File Location=" + serverFile.getAbsolutePath());
				return absoluteFileName;
			} catch (Exception e) {
				throw e;
			}
		} else {
			throw new Exception("File is empty");
		}
	}
}
