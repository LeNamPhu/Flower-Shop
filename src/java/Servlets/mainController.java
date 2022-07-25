/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class mainController extends HttpServlet {

    private String url = "errorpage.html";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            if (action == null || action.equals("")) {
                url = "index.jsp";
            } else if (action.equals("Login")) {
                url = "loginServlet";
            } else if (action.equals("Register")) {
                url = "registerServlet";
            } else if (action.equals("logout")) {
                url = "logoutServlet";
            } else if (action.equals("addtocart")) {
                url = "addToCartServlet";
            } else if (action.equals("viewcart")) {
                url = "viewCart.jsp";
            } else if (action.equals("update")) {
                url = "updateCartServlet";
            } else if (action.equals("delete")) {
                url = "deleteCartServlet";
            } else if (action.equals("saveOrder")) {
                url = "saveShoppingCartServlet";
            } else if (action.equals("manageAccount")) {
                url = "manageAccountServlet";
            } else if (action.equals("updateStatusAccount")) {
                url = "updateStatusAccountServlet";
            } else if (action.equals("search")) {
                url = "searchServlet";
            } else if (action.equals("searchAccount")) {
                url = "searchAccountServlet";
            } else if (action.equals("updateOrderStatus")) {
                url = "updateOrderStatusServlet";
            } else if (action.equals("manageOrder")) {
                url = "manageOrderServlet";
            } else if (action.equals("searchOrder")) {
                url = "searchOrderServlet";
            } else if (action.equals("updateOrder")) {
                url = "updateOrderServlet";
            } else if (action.equals("updateOrderInfo")) {
                url = "updateOrderInfoServlet";
            } else if (action.equals("manageCate")) {
                url = "manageCategoryServlet";
            } else if (action.equals("managePlant")) {
                url = "managePlantServlet";
            } else if (action.equals("editProfile")) {
                url = "editProfileServlet";
            } else if (action.equals("viewOrder")) {
                url = "viewOrderServlet";
            } else if (action.equals("viewOrderPage")) {
                url = "viewOrder.jsp";
            } else if (action.equals("searchDate")) {
                url = "searchDateServlet";
            }else if (action.equals("addCategory")) {
                url = "addCategoryServlet";
            }
            else if (action.equals("addPlant")) {
                url = "addPlantServlet";
            }

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
