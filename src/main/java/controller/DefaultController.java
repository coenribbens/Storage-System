package controller;

import datalayer.ItemDAO;
import javax.servlet.http.HttpServletRequest;
import model.ItemCreation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("defaultC")
public class DefaultController {

    ItemDAO dao = ItemDAO.getInstance();

    // Index Page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {

        return "index";
    }

    // Index Redirect
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String redirectIndex() {

        return "redirect:/";
    }

    @RequestMapping(value = "/overview", method = RequestMethod.GET)
    public String overview(ModelMap map) {

        map.put("getAllItems", dao.getAllItems());

        return "overview";
    }
//The preparedstatement in the controller//
    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String addItem(ModelMap map, HttpServletRequest request) {

        int id = request.getIntHeader("ID");
        String name = request.getParameter("name");
        String dop = request.getParameter("dop");
        float price = Float.parseFloat(request.getParameter("price"));
        String notes = request.getParameter("notes");

          ItemCreation i = new ItemCreation(id, name, dop, price, notes);
          dao.addItem(i);
          
          return "addItem";
    }
} 
