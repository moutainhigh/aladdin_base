package com.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map工具类
 * 
 * @author JSC
 *
 */
public class MapUtil {
	private static Map<String, Object> dataInstance = new HashMap<>();
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static Set<String> BASE_TYPE = new HashSet<>();

	static {
		BASE_TYPE.add("byte");
		BASE_TYPE.add("short");
		BASE_TYPE.add("int");
		BASE_TYPE.add("long");
		BASE_TYPE.add("float");
		BASE_TYPE.add("double");
		BASE_TYPE.add("boolean");
		BASE_TYPE.add("char");
		BASE_TYPE.add("java.lang.Byte");
		BASE_TYPE.add("java.lang.Short");
		BASE_TYPE.add("java.lang.Integer");
		BASE_TYPE.add("java.lang.Long");
		BASE_TYPE.add("java.lang.Float");
		BASE_TYPE.add("java.lang.Double");
		BASE_TYPE.add("java.lang.Boolean");
		BASE_TYPE.add("java.lang.Character");
		BASE_TYPE.add("java.lang.String");
	}

	/**
	 * 将实体对象转换为map,不支持Map和数组
	 * 
	 * @param obj
	 *            对象
	 * @return map
	 */
	public static Map<String, Object> toMap(Object obj) throws Exception {
		if (obj == null) {
			return null;
		}
		Map<String, Object> data = new HashMap<>();
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String typeName = field.getType().getTypeName();
			String name = field.getName();
			Object val = field.get(obj);
			if (BASE_TYPE.contains(typeName)) {// 不需要转换的类型
				data.put(name, val);
			} else if ("java.util.Date".equals(typeName)) {// 日期类型
				String date = null;
				try {
					date = sdf.format((Date) val);
				} catch (Exception e) {
				}
				data.put(name, date);
			} else if (val instanceof Collection<?>) {// 集合
				List<Object> list = new ArrayList<>();
				Collection<?> c = (Collection<?>) val;
				for (Object object : c) {
					list.add(toMap(object));
				}
				data.put(name, list);
			} else {// 其他自定义类型
				data.put(name, toMap(val));
			}
		}
		return data;
	}

	/**
	 * 将集合对象转换为map集合
	 * 
	 * @param obj
	 *            对象
	 * @return json
	 */
	public static List<Map<String, Object>> toMap(Collection<?> c) throws Exception {
		List<Map<String, Object>> data = new ArrayList<>();
		for (Object obj : c) {
			data.add(toMap(obj));
		}
		return data;
	}

	/**
	 * 获取MapData实例
	 * 
	 * @param data
	 *            map数据
	 * @return
	 */
	public static MapData newInstance(Map<String, Object> data) {
		return new MapData(data);
	};

	/**
	 * 获得Map<String,Object>类型
	 * 
	 * @return
	 */
	public static Class<?> getDataType() {
		return dataInstance.getClass();
	}

	/**
	 * Map<String,Object>操作类
	 * 
	 * @author JSC
	 *
	 */
	public static class MapData {
		/**
		 * 数据
		 */
		private Map<String, Object> data;

		public Map<String, Object> getData() {
			return data;
		}

		public void setData(Map<String, Object> data) {
			this.data = data;
		}

		private MapData(Map<String, Object> data) {
			this.data = data;
		}

		/**
		 * 获得String值
		 * 
		 * @param key
		 *            键
		 * @return
		 */
		public String getString(String key) {
			try {
				Object value = data.get(key);
				if (value == null) {
					return null;
				}
				return String.valueOf(value);
			} catch (Exception e) {
				return null;
			}
		}

		/**
		 * 获得Boolean值
		 * 
		 * @param key
		 *            键
		 * @return
		 */
		public Boolean getBoolean(String key) {
			try {
				return Boolean.valueOf(getString(key));
			} catch (Exception e) {
				return null;
			}
		}

		/**
		 * 获得Integer值
		 * 
		 * @param key
		 *            键
		 * @return
		 */
		public Integer getInteger(String key) {
			try {
				return Integer.valueOf(getString(key));
			} catch (Exception e) {
				return null;
			}
		}

		/**
		 * 获得Integer值
		 * 
		 * @param key
		 *            键
		 * @return
		 */
		public Long getLong(String key) {
			try {
				return Long.valueOf(getString(key));
			} catch (Exception e) {
				return null;
			}
		}

		/**
		 * 获得Object值
		 * 
		 * @param key
		 *            键
		 * @return
		 */
		public Object getObject(String key) {
			return data.get("key");
		}

		/**
		 * 获取错误描述
		 * 
		 * @return
		 */
		public String errorString() {
			return getString("method") + " {errcode:" + getString("errcode") + ",errmsg:" + getString("errmsg") + "}";
		}
	}
}
