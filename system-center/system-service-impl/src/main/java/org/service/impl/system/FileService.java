package org.service.impl.system;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import zero.commons.basics.helper.CodeHelper;
import zero.commons.basics.result.FileResult;
import zero.commons.basics.result.ResultType;

@Service
public class FileService {

	private static Logger logger = LoggerFactory.getLogger(FileService.class);

	public FileResult upload(HttpServletRequest request, String uploadPath, String uploadUrl) {
		logger.info("文件开始上传--------->");
		FileResult result = new FileResult();
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		if (files == null || files.size() <= 0) {
			result.setCode(ResultType.NULL);
			result.setMessage("上传文件为空");
			return result;
		}
		for (MultipartFile file : files) {
			if (file.isEmpty()) {
				continue;
			}
			String name = file.getOriginalFilename();// 文件名称
			String type = name.substring(name.lastIndexOf("."), name.length());
			name = CodeHelper.getUUID() + type;
			File path = new File(uploadPath);
			if (!path.exists()) {
				path.mkdirs();
			}
			String _path = uploadPath + name;
			File createFile = new File(_path);
			try {
				file.transferTo(createFile);
				String url = uploadUrl + name;
				result.setCode(ResultType.SUCCESS);
				result.setMessage("上传成功");
				result.setPath(_path);
				result.setUrl(url);
				logger.info("文件'" + name + "' 上传成功，访问地址为'" + _path + "'，物理路径为'" + url + "'");
			} catch (Exception e) {
				logger.error("文件上传失败，错误文件名称:" + name);
				logger.error("报错信息为：" + e.getMessage());
				result.setCode(ResultType.ERROR);
				result.setMessage("文件上传报错");
			}
		}
		logger.info("文件上传结束--------->");
		return result;
	}
}
