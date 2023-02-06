package cn.zsb.dao;

import cn.zsb.domain.Item;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Admin
 */
public interface ItemDao {
    public List<Item> findAll() throws SQLException, ClassNotFoundException;
}
