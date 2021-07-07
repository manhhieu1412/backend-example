

import org.rythmengine.utils.F;
import org.rythmengine.utils.S;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
//        String id = req.getParameter("id");
//        System.out.println(id);
//        JsontoString.Person p = HMPerson.get(id);
//        if (p == null) {
//            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            return;
//        }
//        Gson gson = new Gson();
//        String StringPerson = gson.toJson(p);
//        write(resp, StringPerson);
//        resp.setStatus(HttpServletResponse.SC_OK);
        String action = req.getParameter("action");
        if (action.equals("categories")){
            String respString = Factory.getCategori();
            write(resp, respString);
        }
        else if (action.equals("product")){
            String respProduct = Factory.getProduct();
            write(resp, respProduct);
        }
        else if (action.equals("customers")){
            String respCustomer = Factory.getCustomers();
            write(resp, respCustomer);
        }
        else if (action.equals("employees")){
            String respEmployee = Factory.getEmployees();
            write(resp, respEmployee);
        }
        else if (action.equals("orders")){
            String respOrders = Factory.getOrders();
            write(resp, respOrders);
        }
        else if (action.equals("order_details")){
            String respOrder_details = Factory.getOrder_details();
            write(resp,respOrder_details);
        }
        else if (action.equals("shippers")){
            String respShipper = Factory.getShipper();
            write(resp, respShipper);
        }
        else if (action.equals("suppliers")){
            String respSupp = Factory.getSuppliers();
            write(resp, respSupp);
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
