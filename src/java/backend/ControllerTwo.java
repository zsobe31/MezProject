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
public class ControllerTwo extends HttpServlet {

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
            
            if(request.getParameter("task").equals("taskBemutat")){
                List<Bemutatkozas> bemutatok = Bemutatkozas.getAllBemutatkozasById(em);
                JSONArray valasz = new JSONArray();
                for(Bemutatkozas b : bemutatok){
                    JSONObject o = new JSONObject();
                    o.put("id", b.getId());
                    o.put("kep", b.getKep());
                    o.put("leiras", b.getLeiras());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("taskIsmerteto")){
                List<Ismerteto> elem = Ismerteto.getAllIsmertetoById(em);
                JSONArray valasz = new JSONArray();
                for(Ismerteto e : elem){
                    JSONObject o = new JSONObject();
                    o.put("id", e.getId());
                    o.put("logo", e.getLogo());
                    o.put("leirt", e.getLeirt());
                    o.put("leiras", e.getLeiras());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("taskMez")){
                List<Meztermek> elem = Meztermek.getAllMeztermekByNev(em);
                JSONArray valasz = new JSONArray();
                for(Meztermek e : elem){
                    JSONObject o = new JSONObject();
                    o.put("id", e.getId());
                    o.put("nev", e.getNev());
                    o.put("mennyiseg", e.getMennyiseg());
                    o.put("ar", e.getAr());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("taskDisz")){
                List<Diszcsomag> elem = Diszcsomag.getAllDiszcsomagById(em);
                JSONArray valasz = new JSONArray();
                for(Diszcsomag e : elem){
                    JSONObject o = new JSONObject();
                    o.put("id", e.getId());
                    o.put("nev", e.getNev());
                    o.put("mennyiseg", e.getMennyiseg());
                    o.put("ar", e.getAr());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("taskKepIras")){
                List<Termekek> elem = Termekek.getAllTermekekById(em);
                JSONArray valasz = new JSONArray();
                for(Termekek e : elem){
                    JSONObject o = new JSONObject();
                    o.put("id", e.getId());
                    o.put("nev", e.getNev());
                    o.put("leiras", e.getLeiras());
                    o.put("kep", e.getKep());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("taskVelemeny")){
                List<Velemeny> elem = Velemeny.getAllVelemenyById(em);
                JSONArray valasz = new JSONArray();
                for(Velemeny e : elem){
                    JSONObject o = new JSONObject();
                    o.put("id", e.getId());
                    o.put("leiras", e.getLeiras());
                    o.put("szerzo", e.getSzerzo());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("taskPartner")){
                List<Partner> elem = Partner.getAllPartnerById(em);
                JSONArray valasz = new JSONArray();
                for(Partner e : elem){
                    JSONObject o = new JSONObject();
                    o.put("id", e.getId());
                    o.put("nev", e.getNev());
                    o.put("icon", e.getIcon());
                    o.put("url", e.getUrl());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("taskElerheto")){
                List<Elerhetoseg> elem = Elerhetoseg.getAllElerhetosegById(em);
                JSONArray valasz = new JSONArray();
                for(Elerhetoseg e : elem){
                    JSONObject o = new JSONObject();
                    o.put("id", e.getId());
                    o.put("nev", e.getNev());
                    o.put("icon", e.getIcon());
                    o.put("url", e.getUrl());
                    valasz.put(o);
                }
                out.print(valasz.toString());
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
