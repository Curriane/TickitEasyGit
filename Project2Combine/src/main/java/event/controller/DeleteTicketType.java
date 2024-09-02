package event.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import event.dao.TicketTypesDAO;

@WebServlet("/event/DeleteTicketType")
public class DeleteTicketType extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public DeleteTicketType() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Integer ticketTypeID = Integer.valueOf(request.getParameter("ticketTypeID"));
    	TicketTypesDAO ticketTypesDAO = new TicketTypesDAO();
    	
		Boolean result = ticketTypesDAO.deleteTicketTypeById(ticketTypeID);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/event/DeleteTicketTypeResult.jsp").forward(request, response);
	}

}
