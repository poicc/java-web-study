package com.crq.demo;


import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

/**
 * @author crq
 */
@WebServlet(
        name = "ParameterServlet",
        urlPatterns = "/res",
        loadOnStartup = 1,
        initParams = {
                @WebInitParam(name = "site", value = "https://poicc.github.io")
        }
)
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        this.message="poicc";
        String site = this.getInitParameter("site");
        System.out.println(site);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        System.out.println(type);
//        switch (type) {
//            case "html":
//                getHtml(response);
//                break;
//            case "json":
//                getJson(response);
//                break;
//            case "img":
//                getImg(request, response);
//                break;
//            case "zip":
//                getZip(request, response);
//            default:
//                break;
//        }
    }

    private void getHtml(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html lang=\"en\"><body>");
        out.println("<h1>"+message+"</h1>");
        out.println("<img src=\"https://cdn.jsdelivr.net/gh/1802343228/image@main/avatar.3sylmzwhoqi0.png\"/>");
        out.println("</body></html>");
        out.flush();
        out.close();
    }

    private void getJson(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String json = "{\"ClientId\":196401 ,\"ClientName\":\"teller\",\"test\":{\"ClientName\":\"teller\"}}";
        out.println(json);
        out.flush();
        out.close();
    }
    private void getImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        String path = request.getServletContext().getRealPath("");
        System.out.println(path);
        File file = new File(path + "/img/1.jpg");
        InputStream inputStream = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = inputStream.read()) != -1) {
            out.write(read);
        }
        out.flush();
        inputStream.close();
        out.close();
    }
    private void getZip(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/x-zip-compressed");
        String path = request.getServletContext().getRealPath("");
        System.out.println(path);
        File file = new File(path + "/zip/ROOT.zip");
        InputStream inputStream = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = inputStream.read()) != -1) {
            out.write(read);
        }
        out.flush();
        inputStream.close();
        out.close();
    }

}