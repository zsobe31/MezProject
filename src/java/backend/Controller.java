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
public class Controller extends HttpServlet {

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
            
            if(request.getParameter("task").equals("bemutatB")){
                List<Bemutatkozas> bemutatok = Bemutatkozas.getAllBemutatkozasById(em);
                JSONArray valasz = new JSONArray();
                for(Bemutatkozas b : bemutatok){
                    JSONObject o = new JSONObject();
                    o.put("kep", b.getKep());
                    o.put("leiras", b.getLeiras());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("ismertetok")){
                List<Ismerteto> ismerteto = Ismerteto.getAllIsmertetoById(em);
                JSONArray valasz = new JSONArray();
                for(Ismerteto i : ismerteto){
                    JSONObject o = new JSONObject();
                    o.put("logo", i.getLogo());
                    o.put("leirt", i.getLeirt());
                    o.put("leiras", i.getLeiras());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("termekekT")){
                List<Meztermek> mezek = Meztermek.getAllMeztermekByNev(em);
                JSONArray valasz = new JSONArray();
                for(Meztermek m : mezek){
                    JSONObject o = new JSONObject();
                    o.put("id", m.getId());
                    o.put("nev", m.getNev());
                    o.put("mennyiseg", m.getMennyiseg());
                    o.put("ar", m.getAr());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("termekekD")){
                List<Diszcsomag> diszek = Diszcsomag.getAllDiszcsomagById(em);
                JSONArray valasz = new JSONArray();
                for(Diszcsomag d : diszek){
                    JSONObject o = new JSONObject();
                    o.put("id", d.getId());
                    o.put("nev", d.getNev());
                    o.put("mennyiseg", d.getMennyiseg());
                    o.put("ar", d.getAr());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("velemenyekV")){
                List<Velemeny> velem = Velemeny.getAllVelemenyById(em);
                JSONArray valasz = new JSONArray();
                for(Velemeny v : velem){
                    JSONObject o = new JSONObject();
                    o.put("leiras", v.getLeiras());
                    o.put("szerzo", v.getSzerzo());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("partnerekP")){
                List<Partner> par = Partner.getAllPartnerById(em);
                JSONArray valasz = new JSONArray();
                for(Partner p : par){
                    JSONObject o = new JSONObject();
                    o.put("url", p.getUrl());
                    o.put("icon", p.getIcon());
                    o.put("nev", p.getNev());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("taskEler")){
                List<Elerhetoseg> elem = Elerhetoseg.getAllElerhetosegById(em);
                JSONArray valasz = new JSONArray();
                for(Elerhetoseg e : elem){
                    JSONObject o = new JSONObject();
                    o.put("url", e.getUrl());
                    o.put("icon", e.getIcon());
                    o.put("nev", e.getNev());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("taskTermek")){
                List<Termekek> elem = Termekek.getAllTermekekById(em);
                JSONArray valasz = new JSONArray();
                for(Termekek e : elem){
                    JSONObject o = new JSONObject();
                    o.put("nev", e.getNev());
                    o.put("leiras", e.getLeiras());
                    o.put("kep", e.getKep());
                    valasz.put(o);
                }
                out.print(valasz.toString());
            }
            
            if(request.getParameter("task").equals("login") && request.getParameter("captcha").equals("")){
                String user = request.getParameter("username");
                String passwd = request.getParameter("password");
                Felhasznalo f = Felhasznalo.login(em, user, passwd);
                if(f != null){
                    request.getSession().setAttribute("user", f);
                    // request.getSession().getAttribute("user"); -> ezt követően így érjük el a sessont
                    JSONObject j = new JSONObject();
                    j.put("result", "Üdvözlünk kedves " + f.getFelhasznalonev());
                    j.put("success", "1");
                    out.print(j.toString());
                }
                else{
                    JSONObject j = new JSONObject();
                    j.put("result", "Hibás felhasználónév vagy jelszó!");
                    j.put("success", "0");
                    out.print(j.toString());
                }
            }
            
            // if(request.getParameter....task equals userdata)
            if(request.getParameter("task").equals("userdata")){
                JSONObject vissza = new JSONObject();
                if(request.getSession().getAttribute("user") != null){
                    Felhasznalo f = (Felhasznalo)request.getSession().getAttribute("user");
                    vissza.put("success", "1");
                    vissza.put("nev", f.getFelhasznalonev());
                }
                else{
                    vissza.put("success", "0");
                }
                out.print(vissza.toString());
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
