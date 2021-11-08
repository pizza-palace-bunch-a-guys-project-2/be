package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.log.ItemLog;
import com.revature.models.Order;
import com.revature.models.User;
import com.revature.repositories.OrderRepository;
import com.revature.repositories.UserRepository;
import com.revature.utils.EmailSender;

@Service
public class OrderService {
	
	private EmailSender email;
	
	private OrderRepository oRepo;
	
	private UserRepository uRepo;
	
	private final ItemLog log = new ItemLog();
	
	public OrderService() {}
		
	
	
	
	
	@Autowired
	public OrderService(OrderRepository oRepo, UserRepository uRepo, EmailSender email) {
		super();
		this.oRepo=oRepo;
		this.uRepo=uRepo;
		this.email = email;
	}
	
	
	public void insertOrder(Order order) {
		oRepo.save(order);
		log.infoLogger("oServ insertOrder");
		log.infoLogger(order.toString());
		User umod = uRepo.findByUserId(order.getUserId());
		if(umod != null) {
			
			String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
					+ "<html\r\n"
					+ "  xmlns=\"http://www.w3.org/1999/xhtml\"\r\n"
					+ "  xmlns:o=\"urn:schemas-microsoft-com:office:office\"\r\n"
					+ "  xmlns:v=\"urn:schemas-microsoft-com:vml\"\r\n"
					+ "  lang=\"en\"\r\n"
					+ ">\r\n"
					+ "  <head>\r\n"
					+ "    <link\r\n"
					+ "      rel=\"stylesheet\"\r\n"
					+ "      type=\"text/css\"\r\n"
					+ "      hs-webfonts=\"true\"\r\n"
					+ "      href=\"https://fonts.googleapis.com/css?family=Lato|Lato:i,b,bi\"\r\n"
					+ "    />\r\n"
					+ "    <title>Email template</title>\r\n"
					+ "    <meta property=\"og:title\" content=\"Email template\" />\r\n"
					+ "\r\n"
					+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n"
					+ "\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n"
					+ "\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n"
					+ "\r\n"
					+ "    <style type=\"text/css\">\r\n"
					+ "      a {\r\n"
					+ "        text-decoration: underline;\r\n"
					+ "        color: inherit;\r\n"
					+ "        font-weight: bold;\r\n"
					+ "        color: #253342;\r\n"
					+ "      }\r\n"
					+ "\r\n"
					+ "      h1 {\r\n"
					+ "        font-size: 56px;\r\n"
					+ "      }\r\n"
					+ "\r\n"
					+ "      h2 {\r\n"
					+ "        font-size: 28px;\r\n"
					+ "        font-weight: 900;\r\n"
					+ "      }\r\n"
					+ "\r\n"
					+ "      p {\r\n"
					+ "        font-weight: 100;\r\n"
					+ "      }\r\n"
					+ "\r\n"
					+ "      td {\r\n"
					+ "        vertical-align: top;\r\n"
					+ "      }\r\n"
					+ "\r\n"
					+ "      #email {\r\n"
					+ "        margin: auto;\r\n"
					+ "        width: 600px;\r\n"
					+ "        background-color: white;\r\n"
					+ "      }\r\n"
					+ "\r\n"
					+ "      button {\r\n"
					+ "        font: inherit;\r\n"
					+ "        background-color: #ff7a59;\r\n"
					+ "        border: none;\r\n"
					+ "        padding: 10px;\r\n"
					+ "        text-transform: uppercase;\r\n"
					+ "        letter-spacing: 2px;\r\n"
					+ "        font-weight: 900;\r\n"
					+ "        color: white;\r\n"
					+ "        border-radius: 5px;\r\n"
					+ "        box-shadow: 3px 3px #d94c53;\r\n"
					+ "      }\r\n"
					+ "\r\n"
					+ "      .subtle-link {\r\n"
					+ "        font-size: 9px;\r\n"
					+ "        text-transform: uppercase;\r\n"
					+ "        letter-spacing: 1px;\r\n"
					+ "        color: #cbd6e2;\r\n"
					+ "      }\r\n"
					+ "    </style>\r\n"
					+ "  </head>\r\n"
					+ "\r\n"
					+ "  <body\r\n"
					+ "    bgcolor=\"#F5F8FA\"\r\n"
					+ "    style=\"\r\n"
					+ "      width: 100%;\r\n"
					+ "      margin: auto 0;\r\n"
					+ "      padding: 0;\r\n"
					+ "      font-family: Lato, sans-serif;\r\n"
					+ "      font-size: 18px;\r\n"
					+ "      color: #33475b;\r\n"
					+ "      word-break: break-word;\r\n"
					+ "    \"\r\n"
					+ "  >\r\n"
					+ "    <div id=\"email\">\r\n"
					+ "      <table align=\"right\" role=\"presentation\">\r\n"
					+ "        <tr>\r\n"
					+ "          <td>\r\n"
					+ "            <a class=\"subtle-link\" href=\"#\">View in Browser</a>\r\n"
					+ "          </td>\r\n"
					+ "        </tr>\r\n"
					+ "\r\n"
					+ "        <tr></tr>\r\n"
					+ "      </table>\r\n"
					+ "\r\n"
					+ "      <table role=\"presentation\" width=\"100%\">\r\n"
					+ "        <tr>\r\n"
					+ "          <td bgcolor=\"#B41A1A\" align=\"center\" style=\"color: white\">\r\n"
					+ "            <img\r\n"
					+ "              alt=\"Flower\"\r\n"
					+ "              src=\"https://menuitembucket.s3.us-east-2.amazonaws.com/menuitempizza1.jpg\"\r\n"
					+ "              width=\"400px\"\r\n"
					+ "              align=\"middle\"\r\n"
					+ "            />\r\n"
					+ "\r\n"
					+ "            <h1>Pizza Palace</h1>\r\n"
					+ "          </td>\r\n"
					+ "        </tr>\r\n"
					+ "      </table>\r\n"
					+ "\r\n"
					+ "      <table\r\n"
					+ "        role=\"presentation\"\r\n"
					+ "        border=\"0\"\r\n"
					+ "        cellpadding=\"0\"\r\n"
					+ "        cellspacing=\"10px\"\r\n"
					+ "        style=\"padding: 30px 30px 30px 60px\"\r\n"
					+ "      >\r\n"
					+ "        <tr>\r\n"
					+ "          <td>\r\n"
					+ "            <h2>Thank you for your order!</h2>\r\n"
					+ "            <p>"+ "<strong>Order ID:</strong> " + order.getOrderId() + "<br>"   
									   + "<strong>Delivery Address:</strong> " + umod.getUserAddress() + "<br>" 
									   + "<strong>Total:</strong> " + order.getTotal() + "<br>"
									   + "<strong>Items:</strong> " + order.getItems() + "<br>"
									
								+"</p>\r\n"
					+ "          </td>\r\n"
					+ "        </tr>\r\n"
					+ "      </table>\r\n"
					+ "\r\n"
					+ "      <table\r\n"
					+ "        role=\"presentation\"\r\n"
					+ "        bgcolor=\"#EAF0F6\"\r\n"
					+ "        width=\"100%\"\r\n"
					+ "        style=\"margin-top: 50px\"\r\n"
					+ "      >\r\n"
					+ "        <tr>\r\n"
					+ "          <td align=\"center\" style=\"padding: 30px 30px\"></td>\r\n"
					+ "        </tr>\r\n"
					+ "      </table>\r\n"
					+ "    </div>\r\n"
					+ "  </body>\r\n"
					+ "</html>\r\n"
					+ "";
			
			email.sendHTMLEmail(umod.getUserEmail(), "Order Confirmation", html);
			
//			email.sendEmail(
//						umod.getUserEmail(), 
//						"Order Confirmation", 
//						order.toStringEmail()
//					);
		}else {
			System.out.println(umod);
			System.out.println(order);
		}
		
	}
	
	public List<Order> getAllOrders(){
		log.infoLogger("oServ getAllOrders");
		return oRepo.findAll();
	}
	
	public Order getOrderById(int id) {
		log.infoLogger("oServ getOrderById");
		return oRepo.findByOrderId(id);
	}
	
	public List<Order> getOrdersByUserId(int id) {
		log.infoLogger("oServ getOrderByUserId");
		return oRepo.findByUserId(id);
	}
	
	public void deleteOrder(Order order) {
		log.infoLogger("oServ deleteOrder");
		oRepo.delete(order);
	}
	
	
	
}
