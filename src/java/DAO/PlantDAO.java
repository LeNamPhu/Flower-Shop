/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Plant;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class PlantDAO {

    public static ArrayList<Plant> getPlants(String keyword, String searchby) {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null && searchby != null) {
                String sql = ("select PID,PName,price,imgPath,description,status,p.CateID as 'CateID', CateName\n"
                        + "from Categories c join PLants p on c.CateID = p.CateID\n");

                if (searchby.equalsIgnoreCase("byname")) {
                    sql = sql + "where p.Pname like ?";
                } else {
                    sql = sql + "where c.Catename like ?";
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                keyword = "%" + keyword + "%";
                pst.setString(1, keyword);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("PID");
                        String name = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgPath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateid = rs.getInt("CateID");
                        String catename = rs.getString("CateName");
                        Plant plant = new Plant(id, name, price, imgpath, description, status, cateid, catename);
                        list.add(plant);

                    }
                }

            }
        } catch (Exception e) {

        }
        return list;
    }

    public static Plant getPlant(int pid) {
        Plant p = null;
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = ("select PID,PName,price,imgPath,description,status,p.CateID as 'CateID', CateName\n"
                        + "from Categories c join PLants p on c.CateID = p.CateID\n"
                        + "where PID=?");
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, pid);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int id = rs.getInt("PID");
                    String name = rs.getString("PName");
                    int price = rs.getInt("price");
                    String imgpath = rs.getString("imgPath");
                    String description = rs.getString("description");
                    int status = rs.getInt("status");
                    int cateid = rs.getInt("CateID");
                    String catename = rs.getString("CateName");
                    p = new Plant(id, name, price, imgpath, description, status, cateid, catename);

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
        return p;
    }

    public static ArrayList<Plant> getPlants() {
        ArrayList<Plant> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = ("select PID,PName,price,imgPath,description,status,p.CateID as 'CateID', CateName\n"
                        + "from Categories c join PLants p on c.CateID = p.CateID\n");

                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("PID");
                        String name = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgPath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateid = rs.getInt("CateID");
                        String catename = rs.getString("CateName");
                        Plant plant = new Plant(id, name, price, imgpath, description, status, cateid, catename);
                        list.add(plant);

                    }
                }

            }
        } catch (Exception e) {

        }
        return list;
    }

    public static void addPlant(String name, int price, String imgpath, String desc, int cateID) {
        Connection cn = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = ("insert into Plants\n"
                        + "values (?,?,?,?,1,?)");

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setInt(2, price);
                pst.setString(3, imgpath);
                pst.setString(4, desc);
                pst.setInt(5, cateID);
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
