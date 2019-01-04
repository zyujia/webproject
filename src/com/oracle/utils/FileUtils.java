package com.oracle.utils;

import com.oracle.exception.FileNameException;
import com.oracle.exception.HeadInfoException;

public class FileUtils {
	/**
	 * 获取上传文件名
	 * @param headInfo
	 * @return 文件名
	 * @throws HeadInfoException 当头部信息为空
	 */
	public static String getFileName(String headInfo) throws HeadInfoException{
		if (headInfo==null||"".equals(headInfo)) {
			throw new HeadInfoException("头部信息不能为空");
		}
		String fileName=headInfo.substring(headInfo.lastIndexOf("=")+2, headInfo.length()-1);
		return fileName;
	}
	/**
	 * 获取文件后缀
	 * @param fileName
	 * @return 后缀
	 * @throws FileNameException 当文件名称为空
	 */
	public static String getSuffix(String fileName) throws FileNameException{
		if (fileName==null||"".equals(fileName)) {
			throw new FileNameException("文件名称不能为空");
		}
		String suffix=fileName.substring(fileName.lastIndexOf("."),fileName.length());
		return suffix;
	}

}
