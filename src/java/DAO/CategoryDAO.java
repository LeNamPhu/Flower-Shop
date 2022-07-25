/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Category;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class CategoryDAO {

    public static ArrayList<Category> getCategory() {
        Connection cn = null;
        ArrayList<Category> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select CateID, CateName\n"
                        + "from Categories";
                PreparedStatement pst = cn.prepareStatement(sql);

                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {

                        int cateid = rs.getInt("CateID");
                        String catename = rs.getString("CateName");
                        Category cate = new Category(cateid, catename);
                        list.add(cate);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return list;
    }
    public static int getNextCateID(){
        int result = 0;
        Connection cn = null;
                try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select top 1CateID\n"
                        + "from Categories\n"
                        + " order by CateID desc";
                PreparedStatement pst = cn.prepareStatement(sql);

                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                         result = rs.getInt("CateID");

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
                return (result + 1);
    }
    public static void addCategory( String cateName){
        Connection cn = null;
                try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert into Categories\n"
                       
                        + " values (?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, cateName);
                pst.execute();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
