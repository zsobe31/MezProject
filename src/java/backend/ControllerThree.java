/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author zsobe31
 */
public class ControllerThree extends HttpServlet {

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
        response.setContentType("application/json");
        
        
        // ékezetes probléma megoldása
        request.setCharacterEncoding("UTF-8");
        //request.setCharacterEncoding("Cp1250");
        response.setCharacterEncoding("UTF-8");
        //response.setCharacterEncoding("Cp1250");
        
        try (
            PrintWriter out = response.getWriter()) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("MezProjectPU");
            EntityManager em = emf.createEntityManager();
            
            //MÉZTERMÉKEK MŰVELETEK
            // méztermék felvitel
            if(request.getParameter("task").equals("hozzaadMezTer")){
                String nevC = request.getParameter("nev");
                String mennyisegC = request.getParameter("mennyiseg");
                String arC = request.getParameter("ar");
                
                Meztermek.addNewMeztermek(em, nevC, mennyisegC, arC);
                out.print("minden ok!");
                
            }
            // méztermék törlés
            if(request.getParameter("task").equals("torolMezTer")){
                int idT = Integer.parseInt(request.getParameter("id"));
                Meztermek.deleteMeztermek(em, idT);
                
            }
            
            // méztermék módosítás
            if(request.getParameter("task").equals("modositMezTer")){
                String nevM = request.getParameter("nev");
                String mennyisegM = request.getParameter("mennyiseg");
                String arM = request.getParameter("ar");
                int idM = Integer.parseInt(request.getParameter("id"));
                
                Meztermek.updateMeztermek(em, idM, nevM, mennyisegM, arM);
                out.print("ok");
            }
            
            // DISZCSOMAGOLT TERMÉKEK MŰVELETEK
            // diszcsomag felvitel
            if(request.getParameter("task").equals("hozzaadDisz")){
                String nevC = request.getParameter("nev");
                String mennyisegC = request.getParameter("mennyiseg");
                String arC = request.getParameter("ar");
                
                Diszcsomag.addNewDiszcsomag(em, nevC, mennyisegC, arC);
                out.print("minden ok!");
                
            }
            // diszcsomag törlés
            if(request.getParameter("task").equals("torolDisz")){
                int idT = Integer.parseInt(request.getParameter("id"));
                Diszcsomag.deleteDiszcsomag(em, idT);
                
            }
            
            // diszcsomag módosítás
            if(request.getParameter("task").equals("modositDisz")){
                String nevM = request.getParameter("nev");
                String mennyisegM = request.getParameter("mennyiseg");
                String arM = request.getParameter("ar");
                int idM = Integer.parseInt(request.getParameter("id"));
                
                Diszcsomag.updateDiszcsomag(em, idM, nevM, mennyisegM, arM);
                out.print("ok");
            }
            
            //VÉLEMÉNYEK MŰVELETEK
            // módosítás
            if(request.getParameter("task").equals("modositVelemeny")){
                String leirasM = request.getParameter("leiras");
                String szerzoM = request.getParameter("szerzo");
                int idM = Integer.parseInt(request.getParameter("id"));
                
                Velemeny.updateVelemeny(em, idM, leirasM, szerzoM);
                out.print("ok");
            }
            
            //BEMUTATKOZÁS MŰVELETEK
            // módosítás
            if(request.getParameter("task").equals("modositBemutat")){
                String leirasM = request.getParameter("leiras");
                String kepM = request.getParameter("kep");
                int idM = Integer.parseInt(request.getParameter("id"));
                
                Bemutatkozas.updateBemutatkozas(em, idM, kepM, leirasM);
                out.print("ok");
            }
            
            //ISMERTETŐK MŰVELETEK
            // módosítás
            if(request.getParameter("task").equals("modositIsmer")){
                String logoM = request.getParameter("logo");
                String leirasM = request.getParameter("leiras");
                String leirtM = request.getParameter("leirt");
                int idM = Integer.parseInt(request.getParameter("id"));
                
                Ismerteto.updateIsmerteto(em, idM, logoM, leirtM, leirasM);
                out.print("ok");
            }
            
            // TERMÉKEK MŰVELETEK
            // módosítás
            if(request.getParameter("task").equals("modositTermek")){
                String nevM = request.getParameter("nev");
                String leirasM = request.getParameter("leiras");
                String kepM = request.getParameter("kep");
                int idM = Integer.parseInt(request.getParameter("id"));
                
                Termekek.updateTermekek(em, idM, nevM, leirasM, kepM);
                out.print("ok");
            }
            
            // PARTNEREK MŰVELETEK
            // módosítás
            if(request.getParameter("task").equals("modositPartnerek")){
                String nevM = request.getParameter("nev");
                String iconM = request.getParameter("icon");
                String urlM = request.getParameter("url");
                int idM = Integer.parseInt(request.getParameter("id"));
                
                Partner.updatePartner(em, idM, nevM, iconM, urlM);
                out.print("ok");
            }
            
            //ELÉRHETŐSÉGEK MŰVELETEK
            // módosítás
            if(request.getParameter("task").equals("modositElerhetoseg")){
                String nevM = request.getParameter("nev");
                String iconM = request.getParameter("icon");
                String urlM = request.getParameter("url");
                int idM = Integer.parseInt(request.getParameter("id"));
                
                Elerhetoseg.updateElerhetoseg(em, idM, nevM, iconM, urlM);
                out.print("ok");
            }
            
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
