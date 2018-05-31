package com.hywin.common.constant;

/**
 * @author wuyouyang
 * @time 2017年5月2日10:48:54
 */
public interface Constants {

	/**
	 * OOO系统
	 * OOO△△xxx
	 * 中间三位△△预留，默认为00
	 * 后三位xxx表示错误码
	 * 后三位中xxx，001-099预留为公司统一使用的编码
	 */
	public interface demo{

		// 系统异常（未定义、未捕获、未处理的统一放这里）
		public static final String ERROR_CODE01 = "01000001";
		public static final String ERROR_MSG01 = "系统错误，请联系管理员!";

	}

}
