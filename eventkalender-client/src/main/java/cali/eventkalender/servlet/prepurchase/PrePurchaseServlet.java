package cali.eventkalender.servlet.prepurchase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prepurchase")
public class PrePurchaseServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
       
    public PrePurchaseServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/pages/PrePurchaseOverview.jsp").forward(request, response);
	}
   
}