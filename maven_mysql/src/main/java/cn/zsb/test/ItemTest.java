package cn.zsb.test;

import cn.zsb.dao.ItemDao;
import cn.zsb.dao.impl.ItemDaoImpl;
import cn.zsb.domain.Item;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Admin
 */
public class ItemTest {

    @Test
    public void findAll() throws SQLException, ClassNotFoundException {
        ItemDao dao=new ItemDaoImpl();
        List<Item> list=dao.findAll();
        for (Item item : list) {
            System.out.println(item.getId()+"--->"+item.getName());
        }
    }
}
