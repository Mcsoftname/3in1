package com.daoshu.system.web;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.tomcat.util.http.fileupload.FileUploadBase.SizeLimitExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.daoshu.component.exception.BusinessException;
import com.daoshu.component.response.ResponseInfo;

@ControllerAdvice

public class ExceptionProcess {
	
	 private static final Logger logger = LoggerFactory.getLogger(ExceptionProcess.class);
	
	/**
	 * 处理文件过大异常
	 * @throws IOException 
	 * @throws Exception
	 */
	
	 @ExceptionHandler({  FileSizeLimitExceededException.class,SizeLimitExceededException.class })   
	 @ResponseBody  
	 public ResponseInfo handleMaxUploadException(Exception ex,final WebRequest request,final HttpServletResponse response) throws IOException{
		 logger.error("上传文件超过最大限制");	
		 ResponseInfo responseinfo= new ResponseInfo(
					BusinessException.CODE_ILLEGAL_IMAGE_SIZE,"上传文件过大",null);	
		 return responseinfo;
	
	}
	
	 @ExceptionHandler({org.springframework.web.bind.MethodArgumentNotValidException.class,java.lang.IllegalArgumentException.class})   
	 @ResponseBody  
	 public ResponseInfo MethodArgumentNotValidException(Exception ex,final WebRequest request,final HttpServletResponse response) throws IOException{
		 logger.error(ex.getMessage());	
		 ResponseInfo responseinfo= new ResponseInfo(
					BusinessException.CODE_ILLEGAL_PARAMS,"输入参数不合法",null);	
		 return responseinfo;
			
	}
	 
	 @ExceptionHandler(java.lang.Exception.class)   
	 @ResponseBody  
	 public ResponseInfo SystemException(Exception ex,final WebRequest request,final HttpServletResponse response) throws IOException{
		 logger.error(ex.getMessage());	
		 ResponseInfo responseinfo= new ResponseInfo(
				 BusinessException.CODE_GLOCBAL_EXCEPTION,"系统异常，请联系系统管理员处理",null);	
		 return responseinfo; 
		 
	 }
}
