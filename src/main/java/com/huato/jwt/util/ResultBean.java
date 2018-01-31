package com.huato.jwt.util;

import java.util.HashMap;
import java.util.Map;
/**
 * 统一接口数据返回
 * @author dengyu
 */
public class ResultBean {
	
	public static final String ERRORS_KEY = "errors";
	
	private final String message;
	private final int code;
	
	private final Map<String, Object> data = new HashMap<>();
	
	public ResultBean putDataValues(String key,Object value){
		data.put(key, value);
		return this;
	}
	
	
	//私有构造函数 进行初始化
	private ResultBean(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public int getCode() {
		return code;
	}
	public Map<String, Object> getData() {
		return data;
	}
	
	public static ResultBean ok(){
		return new ResultBean(200, "Ok");
	}
	public static ResultBean notFound(){
		return new ResultBean(404, "not Found");
	}
	
	public static ResultBean badRequest() {
		return new ResultBean(400, "Bad Request");
	}
	
	public static ResultBean forbidden() {
		return new ResultBean(403, "Forbidden");
	}
	
	public static ResultBean unauthorized() {
		return new ResultBean(401, "unauthorized");
	}
	
	public static ResultBean serverInternalError() {
		return new ResultBean(500, "Server Internal Error");
	}
	
	public static ResultBean customerError() {
		return new ResultBean(1001, "Customer Error");
	}
	
	
}
