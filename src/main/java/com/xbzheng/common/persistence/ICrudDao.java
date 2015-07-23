package com.xbzheng.common.persistence;

import java.util.List;

/**
 * Created by hun on 2015-07-23.
 */
public interface ICrudDao<T> extends IBaseDao{
    /**
     * ��ȡ��������
     * @param id
     * @return
     */
    public T get(String id);

    /**
     * ��ȡ��������
     * @param entity
     * @return
     */
    public T get(T entity);

    /**
     * ��ѯ�����б�
     * @param entity
     * @return
     */
    public List<T> findList(T entity);

    /**
     * ��ѯ���������б�
     * @param entity
     * @return
     */
    public List<T> findAllList(T entity);

    /**
     * ��������
     * @param entity
     * @return
     */
    public int insert(T entity);

    /**
     * ��������
     * @param entity
     * @return
     */
    public int update(T entity);

    /**
     * ɾ������
     * @param entity
     * @return
     */
    public int delete(T entity);
}
