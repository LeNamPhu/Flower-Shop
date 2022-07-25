/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Order;
import DTO.OrderDetail;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author admin
 */
public class OrderDAO {

    public static ArrayList<Order> getOrders(String email) {
        Connection cn = null;
        ArrayList<Order> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select OrderID, OrdDate, shipdate, o.status as status, o.AccID as AccID\n"
                        + "from Orders o join Accounts a on o.AccID = a.accID\n"
                        + "where a.email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {

                        int orderID = rs.getInt("OrderID");
                        String orderDate = rs.getString("OrdDate");
                        String shipDate = rs.getString("shipdate");
                        int status = rs.getInt("status");
                        int accID = rs.getInt("AccID");

                        Order order = new Order(orderID, orderDate, shipDate, status, accID);
                        list.add(order);
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

    public static ArrayList<OrderDetail> getOrderDetails(int orderID) {
        Connection cn = null;
        ArrayList<OrderDetail> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select DetailId, OrderID, PID, PName, price, imgPath, quantity\n"
                        + "from OrderDetails o join Plants p on o.FID = p.PID\n"
                        + "where OrderID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, orderID);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int detailID = rs.getInt("DetailId");
                        int pID = rs.getInt("PID");
                        String pName = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgPath = rs.getString("imgPath");
                        int quantity = rs.getInt("quantity");

                        OrderDetail detail = new OrderDetail(detailID, orderID, pID, pName, price, imgPath, quantity);
                        list.add(detail);
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

    public static boolean insertOrder(String email, HashMap<String, Integer> cart) {
        Connection cn = null;
        Boolean result = false;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                int accid = 0, orderid = 0;
                cn.setAutoCommit(false);

                String sql = "select accID\n"
                        + "from Accounts\n"
                        + "where email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    accid = rs.getInt("accID");
                }
                System.out.println("accountid:" + accid);
                Date d = new Date(System.currentTimeMillis());
                System.out.println("order date:" + d);
                sql = "insert Orders (OrdDate, status, AccID) values(?,?,?)";
                pst = cn.prepareStatement(sql);
                pst.setDate(1, d);
                pst.setInt(2, 1);
                pst.setInt(3, accid);
                pst.executeUpdate();
                sql = "select top 1 orderID\n"
                        + "from Orders\n"
                        + "order by orderId desc";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    orderid = rs.getInt("orderID");
                }
                System.out.println("orderid:" + orderid);
                Set<String> pids = cart.keySet();
                for (String pid : pids) {
                    sql = "insert OrderDetails values(?,?,?)";
                    pst = cn.prepareStatement(sql);
                    pst.setInt(1, orderid);
                    pst.setInt(2, Integer.parseInt(pid.trim()));
                    pst.setInt(3, cart.get(pid));
                    pst.executeUpdate();
                    cn.commit();
                    cn.setAutoCommit(true);
                }
                return true;
            } else {
                System.out.println("cant insert order");
            }
        } catch (Exception e) {
            try {
                if (cn != null) {
                    cn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            result = false;
        } finally {

            try {
                if (cn != null) {
                    cn.close();
                }

                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    
    public static ArrayList<Order> getOrders() {
        Connection cn = null;
        ArrayList<Order> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select OrderID, OrdDate, shipdate, o.status as status, o.AccID as AccID\n"
                        + "from Orders o join Accounts a on o.AccID = a.accID\n";
                PreparedStatement pst = cn.prepareStatement(sql);

                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {

                        int orderID = rs.getInt("OrderID");
                        String orderDate = rs.getString("OrdDate");
                        String shipDate = rs.getString("shipdate");
                        int status = rs.getInt("status");
                        int accID = rs.getInt("AccID");

                        Order order = new Order(orderID, orderDate, shipDate, status, accID);
                        list.add(order);
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
    public static ArrayList<Order> getCompletedOrders( int stat, String email) {
        Connection cn = null;
        ArrayList<Order> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select OrderID, OrdDate, shipdate, o.status as status, o.AccID as AccID\n"
                        + "from Orders o join Accounts a on o.AccID = a.accID\n"
                        + "where a.email = ? and o.status = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setInt(2, stat);

                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {

                        int orderID = rs.getInt("OrderID");
                        String orderDate = rs.getString("OrdDate");
                        String shipDate = rs.getString("shipdate");
                        int status = rs.getInt("status");
                        int accID = rs.getInt("AccID");

                        Order order = new Order(orderID, orderDate, shipDate, status, accID);
                        list.add(order);
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
     public static ArrayList<Order> getOrdersByDate( String email, Date from, Date to) {
        Connection cn = null;
        ArrayList<Order> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select OrderID, OrdDate, shipdate, o.status as status, o.AccID as AccID\n"
                        + "from Orders o join Accounts a on o.AccID = a.accID\n"
                        + "where o.OrdDate <= ? and o.OrdDate >= ? and email=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                
                pst.setDate(1, to);
                pst.setDate(2, from);
                pst.setString(3, email);

                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {

                        int orderID = rs.getInt("OrderID");
                        String orderDate = rs.getString("OrdDate");
                        String shipDate = rs.getString("shipdate");
                        int status = rs.getInt("status");
                        int accID = rs.getInt("AccID");

                        Order order = new Order(orderID, orderDate, shipDate, status, accID);
                        list.add(order);
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
    

    public static void updateOrder(int ordID, int status) {
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update Orders\n"
                        + "set status = ?\n"
                        + "where OrderID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, status);
                pst.setInt(2, ordID);

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

    public static ArrayList<Order> getOrders(int ordID) {
        Connection cn = null;
        ArrayList<Order> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select OrderID, OrdDate, shipdate, o.status as status, o.AccID as AccID\n"
                        + "from Orders o join Accounts a on o.AccID = a.accID\n"
                        + "where OrderID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, ordID);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {

                        int orderID = rs.getInt("OrderID");
                        String orderDate = rs.getString("OrdDate");
                        String shipDate = rs.getString("shipdate");
                        int status = rs.getInt("status");
                        int accID = rs.getInt("AccID");

                        Order order = new Order(orderID, orderDate, shipDate, status, accID);
                        list.add(order);
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

    public static Order findOrders(int ordID) {
        Connection cn = null;
        Order order = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select OrderID, OrdDate, shipdate, o.status as status, o.AccID as AccID\n"
                        + "from Orders o join Accounts a on o.AccID = a.accID\n"
                        + "where OrderID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, ordID);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {

                        int orderID = rs.getInt("OrderID");
                        String orderDate = rs.getString("OrdDate");
                        String shipDate = rs.getString("shipdate");
                        int status = rs.getInt("status");
                        int accID = rs.getInt("AccID");

                        order = new Order(orderID, orderDate, shipDate, status, accID);

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
        return order;
    }

    public static void updateOrder(int ordID, String ordDate, String shipDate, int status) {
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update Orders\n"
                        + "set OrdDate = ?, shipdate = ?, status = ?\n"
                        + "where OrderID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, ordDate);
                pst.setString(2, shipDate);
                pst.setInt(3, status);
                pst.setInt(4, ordID);

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
