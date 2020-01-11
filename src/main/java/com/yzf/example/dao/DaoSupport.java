package com.yzf.example.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DaoSupport
 *
 * @author Administrator
 * @since 2020-01-06 17:01:59
 */
@Repository("daoSupport")
public class DaoSupport implements Dao {
        /*<!-- 添加mybatis/spring整合包依赖 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.3.1</version>
        </dependency>*/
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	/*public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}*/

	@Override
	public Object save(String str, Object obj) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert(str, obj);
	}

	@Override
	public Object update(String str, Object obj) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update(str, obj);
	}

	@Override
	public Object delete(String str, Object obj) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete(str, obj);
	}

	@Override
	public Object findForObject(String str, Object obj) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(str, obj);
	}

	@Override
	public Object findForList(String str, Object obj) throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(str, obj);
	}

	@Override
	public Object findForMap(String sql, Object obj, String key, String value) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}