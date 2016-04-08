package com.mi360.aladdin.vertical.distribution.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 纵向分销引擎
 * 
 * @author JSC
 *
 */
public interface VerticalDistributionService {

	/**
	 * 根据用户id查找用户的等级编号
	 * 
	 * @param requestId
	 *            请求标识
	 * @param distributionUserId
	 *            麦圈用户id
	 * @return
	 */
	Map<String, Object> findLevelnoBydistributionUserId(String requestId, String distributionUserId);

	/**
	 * 根据等级编号集合查找用户和所有上线id
	 * 
	 * @param requestId
	 *            请求标识
	 * @param levelNos
	 *            等级编号集合
	 * @return
	 */
	Map<String, Object> findDistributionUserIdsByLeveNos(String requestId, List<String> levelNos);

	/**
	 * 查找直接下级
	 * 
	 * @param requestId
	 *            请求标识
	 * @param mqId
	 *            麦圈用户id
	 * @param page
	 *            页数
	 * @param pageSize
	 *            每页数量
	 * @return
	 */
	Map<String, Object> findMemberByLevelNum(String requestId, String mqId, int levelNum, int page, int pageSize);

	/**
	 * 查询第三级以下会员
	 * 
	 * @param requestId
	 *            请求标识
	 * @param mqId
	 *            麦圈用户id
	 * @param page
	 *            页数
	 * @param pageSize
	 *            每页数量
	 * @return
	 */
	Map<String, Object> findMemberBelowLevelNum(String requestId, String mqId, int levelNum, int page, int pageSize);

	/**
	 * 查找第一层、第二层和第三层以下会员数量
	 * 
	 * @param requestId
	 *            请求标识
	 * @param mqId
	 *            麦圈用户id
	 * @return
	 */
	Map<String, Object> findMemberCount(String requestId, String mqId);

	/**
	 * 根据等级编号查找用户和所有上线id错误代码
	 * 
	 * @author JSC
	 *
	 */
	enum FindDistributionUserIdsByLeveNoErrcode {
		e0(0, "查询成功"), e210601(210601, "查询失败");
		private int code;
		private String msg;
		private String method;

		private FindDistributionUserIdsByLeveNoErrcode(int code, String msg) {
			this.code = code;
			this.msg = msg;
			this.method = "VerticalDistributionService.findDistributionUserIdsByLeveNo";
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		/**
		 * 返回map形式
		 * 
		 * @return
		 */
		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("errcode", code);
			map.put("errmsg", msg);
			map.put("method", method);
			return map;
		}
	}

	/**
	 * 查找第一层、第二层和第三层以下会员数量错误代码
	 */
	enum FindMemberCountErrcode {
		e0(0, "查询成功"), e210601(210601, "查询失败");
		private int code;
		private String msg;
		private String method;

		private FindMemberCountErrcode(int code, String msg) {
			this.code = code;
			this.msg = msg;
			this.method = "VerticalDistributionService.findMemberCount";
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		/**
		 * 返回map形式
		 * 
		 * @return
		 */
		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("errcode", code);
			map.put("errmsg", msg);
			map.put("method", method);
			return map;
		}
	}

	/**
	 * 查找直接下级错误代码
	 * 
	 * @author JSC
	 *
	 */
	enum FindMemberByLevelNumErrcode {
		e0(0, "查询成功"), e210601(210601, "查询失败");
		private int code;
		private String msg;
		private String method;

		private FindMemberByLevelNumErrcode(int code, String msg) {
			this.code = code;
			this.msg = msg;
			this.method = "VerticalDistributionService.findMemberByLevelNum";
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		/**
		 * 返回map形式
		 * 
		 * @return
		 */
		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("errcode", code);
			map.put("errmsg", msg);
			map.put("method", method);
			return map;
		}
	}

	/**
	 * 根据用户id查找用户的等级编号错误代码
	 * 
	 * @author JSC
	 *
	 */
	enum FindLevelnoBydistributionUserIdErrcode {
		/** 查询成功 */
		e0(0, "查询成功"),
		/** 查询失败 */
		e210601(210601, "查询失败");
		private int code;
		private String msg;
		private String method;

		private FindLevelnoBydistributionUserIdErrcode(int code, String msg) {
			this.code = code;
			this.msg = msg;
			this.method = "VerticalDistributionService.findLevelnoBydistributionUserId";
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		/**
		 * 返回map形式
		 * 
		 * @return
		 */
		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("errcode", code);
			map.put("errmsg", msg);
			map.put("method", method);
			return map;
		}
	}

	/**
	 * 查询查找第二下级错误代码
	 * 
	 * @author JSC
	 *
	 */
	enum FindMemberBelowLevelNumErrcode {
		e0(0, "查询成功"), e210601(210601, "查询失败");
		private int code;
		private String msg;
		private String method;

		private FindMemberBelowLevelNumErrcode(int code, String msg) {
			this.code = code;
			this.msg = msg;
			this.method = "VerticalDistributionService.findMemberBelowLevelNum";
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		/**
		 * 返回map形式
		 * 
		 * @return
		 */
		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("errcode", code);
			map.put("errmsg", msg);
			map.put("method", method);
			return map;
		}
	}

	/**
	 * 查询上下级佣金设置接口错误代码
	 * 
	 * @author JSC
	 *
	 */
	enum QueryDistributionSettingErrcode {
		/** 查询上下级佣金设置成功 */
		e0(0, "查询上下级佣金设置成功"),
		/** 查询上下级佣金设置失败，其它错误 */
		e210701(210701, "查询上下级佣金设置失败，其它错误");
		/** 错误代码 */
		private int code;
		/** 错误信息 */
		private String msg;
		private String method;

		private QueryDistributionSettingErrcode(int code, String msg) {
			this.code = code;
			this.msg = msg;
			this.method = "VerticalDistributionService.queryDistributionSetting";
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		/**
		 * 返回map形式
		 * 
		 * @return
		 */
		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("errcode", code);
			map.put("errmsg", msg);
			map.put("method", method);
			return map;
		}
	}

	/**
	 * 查询我的销售错误代码
	 * 
	 * @author JSC
	 *
	 */
	enum FindSalesErrcode {
		/** 查询上下级佣金设置成功 */
		e0(0, "查询我的销售成功"),
		/** 查询上下级佣金设置失败，其它错误 */
		e210701(210701, "查询我的销售失败");
		/** 错误代码 */
		private int code;
		/** 错误信息 */
		private String msg;
		private String method;

		private FindSalesErrcode(int code, String msg) {
			this.code = code;
			this.msg = msg;
			this.method = "VerticalDistributionService.findSales";
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		/**
		 * 返回map形式
		 * 
		 * @return
		 */
		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("errcode", code);
			map.put("errmsg", msg);
			map.put("method", method);
			return map;
		}
	}

	/**
	 * 查询我会员的销售错误代码
	 * 
	 * @author JSC
	 *
	 */
	enum FindMemberSalesErrcode {
		/** 查询我会员的销售成功 */
		e0(0, "查询我会员的销售成功"),
		/** 查询我会员的销售失败 */
		e210701(210701, "查询我会员的销售失败");
		/** 错误代码 */
		private int code;
		/** 错误信息 */
		private String msg;
		private String method;

		private FindMemberSalesErrcode(int code, String msg) {
			this.code = code;
			this.msg = msg;
			this.method = "VerticalDistributionService.findMemberSales";
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		/**
		 * 返回map形式
		 * 
		 * @return
		 */
		public Map<String, Object> toMap() {
			Map<String, Object> map = new HashMap<>();
			map.put("errcode", code);
			map.put("errmsg", msg);
			map.put("method", method);
			return map;
		}
	}
}