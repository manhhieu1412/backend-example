

import connection.InnerJoin;
import connection.LeftJoin;
import org.rythmengine.utils.S;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyApplication extends HttpServlet {

    private List<String> names = new ArrayList<>();

    static HashMap<String, JsontoString.Person> HMPerson = new HashMap<>();
    static JsontoString.Address address = new JsontoString.Address("TienCat", "VietTri", "PhuTho");
    static JsontoString.Person Hung = new JsontoString.Person("Hung", 30, "abc@gmail", address);
    static JsontoString.Address address2 = new JsontoString.Address("An Khanh", "Hoai Duc", "Ha Noi");
    static JsontoString.Person Hieu = new JsontoString.Person("Hieu", 32, "bcd@gmail", address2);

    static {
        HMPerson.put("123", Hung);
        HMPerson.put("456", Hieu);


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        String price = req.getParameter("price");
        if (price != null) {
            String respPrice = Factory.getProduct(price);
            write(resp, respPrice);
            return;
        }

        String country = req.getParameter("country");
        if (country != null) {
            String respCountry = Factory.getCountry(country);
            write(resp, respCountry);
            return;
        }


        String shipID = req.getParameter("ShipperID");
        if (shipID != null) {
            String response = Factory.getShipperID(shipID);
            write(resp, response);
            return;
        }

        String categoryId = req.getParameter("categoryId");
        if (categoryId != null) {
            String respString = Factory.getCategoryById(categoryId);
            write(resp, respString);
            return;
        }
        String categoryName = req.getParameter("categoryName");
        if (categoryName != null) {
            String respString = Factory.getCategoryName(categoryName);
            write(resp, respString);
            return;
        }
        String action = req.getParameter("action");
        if (action.equals("categories")) {
            String respString = Factory.getCategori();
            write(resp, respString);
        } else if (action.equals("product")) {
            String respProduct = Factory.getProduct();
            write(resp, respProduct);
        } else if (action.equals("customers")) {
            String respCustomer = Factory.getCustomers();
            write(resp, respCustomer);
        } else if (action.equals("employees")) {
            String respEmployee = Factory.getEmployees();
            write(resp, respEmployee);
        } else if (action.equals("orders")) {
            String respOrders = Factory.getOrders();
            write(resp, respOrders);
        } else if (action.equals("order_details")) {
            String respOrder_details = Factory.getOrderDetails();
            write(resp, respOrder_details);
        } else if (action.equals("shippers")) {
            String respShipper = Factory.getShipper();
            write(resp, respShipper);
        } else if (action.equals("suppliers")) {
            String respSupp = Factory.getSuppliers();
            write(resp, respSupp);
        }
        else if (action.equals("join")){
            String respJoin = InnerJoin.innerJoin();
            write(resp,respJoin);
        }
        else if (action.equals("leftJoin")){
            String respLeft = LeftJoin.Join();
            write(resp,respLeft);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        names.add(req.getParameter("name"));

        write(resp, "added");
    }

    private void write(HttpServletResponse resp, String message) throws IOException {
        resp.getWriter().write(message);
    }
}
