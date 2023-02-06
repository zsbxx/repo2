package cn.zsb.dao.impl;

import cn.zsb.dao.ItemDao;
import cn.zsb.domain.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 */
public class ItemDaoImpl implements ItemDao {
    @Override
    public List<Item> findAll() throws SQLException, ClassNotFoundException {

        //将结果转成Item对象List集合
        List<Item> list = new ArrayList<Item>();

        Connection connection=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //先获取connection对象
            connection = DriverManager.getConnection("jdbc:mysql:///maven", "root", "wazjl20051022");
            //获取数据操作对象
            pst = connection.prepareCall("select * from items");
            //获取数据
            rs = pst.executeQuery();

            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                list.add(item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(connection != null){
                connection.close();
            }

            if(pst != null){
                pst.close();
            }

            if(rs != null){
                rs.close();
            }

        }
        return list;
    }
}
