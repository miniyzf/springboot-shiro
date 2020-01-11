package com.yzf.example.dao;

/**
 * Dao
 *
 * @author Administrator
 * @since 2020-01-06 17:01:58
 */
public interface Dao {
	/**
	 * 保存对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object save(String str, Object obj) throws Exception;
	
	/**
	 * 修改对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object update(String str, Object obj) throws Exception;
	
	/**
	 * 删除对象 
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object delete(String str, Object obj) throws Exception;

	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findForObject(String str, Object obj) throws Exception;

	/**
	 * 查找对象list
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findForList(String str, Object obj) throws Exception;

    /**
     * 查找对象封装成Map
     * @param sql
     * @param obj
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
	public Object findForMap(String sql, Object obj, String key, String value) throws Exception;
	
}