/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Account;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class AccountDAO {

    public static Account getAccount(String email, String password) {

        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accID,email,password,fullname,phone,status,role\n"
                        + "from dbo.Accounts\n"
                        + "where status=1 and email= ? and password = ? COLLATE Latin1_General_CS_AS";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role);

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
        return acc;

    }

    public static boolean insertAccount(String newEmail, String newPassword, String newFullname, String newPhone, int newStatus, int newRole) {
        Connection cn = null;
        int check = 0;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "insert into Accounts([email],[password],[fullname],[phone],[status],[role])\n"
                        + "values('" + newEmail + "','" + newPassword + "','" + newFullname + "','" + newPhone + "','" + newStatus + "','" + newRole + "');";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.execute();
                check = 1;

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return (check == 1);
    }

    public static void updateToken(String token, String email) {
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update Accounts\n"
                        + "set token = ?\n"
                        + "where email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, token);
                pst.setString(2, email);

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

    public static Account getAccount(String token) {

        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accID,email,password,fullname,phone,status,role\n"
                        + "from dbo.Accounts\n"
                        + "where status=1 and token= ? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, token);

                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role);

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
        return acc;

    }

    public static ArrayList<Account> getAccount() {
        ArrayList<Account> list = new ArrayList<>();
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accID,email,password,fullname,phone,status,role\n"
                        + "from dbo.Accounts\n";

                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int AccID = rs.getInt("accID");
                        String Email = rs.getString("email");
                        String Password = rs.getString("password");
                        String Fullname = rs.getString("fullname");
                        String Phone = rs.getString("phone");
                        int Status = rs.getInt("status");
                        int Role = rs.getInt("role");
                        Account acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role);
                        list.add(acc);
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

    public static void updateAccountStatus(String email, int status) {
        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update Accounts\n"
                        + "set status = ?\n"
                        + "where email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, status);
                pst.setString(2, email);
                pst.executeQuery();
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

    public static boolean updateAccount(String email, String newPassword, String newFullname, String newPhone) {
        Connection cn = null;
        int check = 0;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "update Accounts\n"
                        + "set password=? , fullname=? , phone=?  \n"
                        + "where email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, newPassword);
                pst.setString(2, newFullname);
                pst.setString(3, newPhone);
                pst.setString(4, email);

                pst.execute();
                check = 1;
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
        return (check == 1);
    }

    public static ArrayList<Account> searchAccount(String email) {

        Connection cn = null;

        ArrayList<Account> list = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accID,email,password,fullname,phone,status,role\n"
                        + "from dbo.Accounts\n"
                        + "where status=1 and email like ? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                email = "%" + email + "%";
                pst.setString(1, email);

                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int AccID = rs.getInt("accID");
                        String Email = rs.getString("email");
                        String Password = rs.getString("password");
                        String Fullname = rs.getString("fullname");
                        String Phone = rs.getString("phone");
                        int Status = rs.getInt("status");
                        int Role = rs.getInt("role");
                        Account acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role);
                        list.add(acc);
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

    public static Account takeAccount(String email) {

        Connection cn = null;
        Account acc = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accID,email,password,fullname,phone,status,role\n"
                        + "from dbo.Accounts\n"
                        + "where status=1 and email= ?  COLLATE Latin1_General_CS_AS";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);

                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    acc = new Account(AccID, Email, Password, Fullname, Status, Phone, Role);

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
        return acc;

    }

    public static void editAccount(String email) {

        Connection cn = null;

        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accID,email,password,fullname,phone,status,role\n"
                        + "from dbo.Accounts\n"
                        + "where status=1 and email= ?  COLLATE Latin1_General_CS_AS";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
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