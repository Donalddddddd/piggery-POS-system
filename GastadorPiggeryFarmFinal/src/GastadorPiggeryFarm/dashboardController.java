    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GastadorPiggeryFarm;

import static com.mysql.jdbc.Messages.getString;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import static java.util.Objects.hash;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javax.swing.UIManager.getInt;
import static jdk.nashorn.internal.objects.Global.getDate;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Donald
 */
public class dashboardController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private Label username;

    @FXML
    private Button dashboard_btn;
    
    @FXML
    private Button customerInfo_btn;
    
    @FXML
    private Button addPig_btn;

    @FXML
    private Button purchase_btn;

    @FXML
    private Button logout;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private AreaChart<?, ?> dashboard_chart;

    @FXML
    private Label dashboard_availablePig;

    @FXML
    private Label dashboard_totalIncome;

    @FXML
    private Label dashboard_totalCustomers;

    @FXML
    private AnchorPane addPig_form;

    @FXML
    private TextField addpig_pigID;

    @FXML
    private ComboBox<?> addpig_status;

    @FXML
    private TextField addpig_price;
        
    @FXML
    private TextField addpig_monthOfPig;

    @FXML
    private Button addpig_clearBtn;

    @FXML
    private Button addpig_deleteBtn;

    @FXML
    private Button addpig_addBtn;

    @FXML
    private Button addpigs_updateBtn;

    @FXML
    private TextField addpig_search;
    
    @FXML
    private TableView<pigData> addpig_tableView;

    @FXML
    private TableColumn<pigData, String> addpig_col_pigID;

    @FXML
    private TableColumn<pigData, String> addpig_col_price;

    @FXML
    private TableColumn<pigData, String> addpig_col_status;

    @FXML
    private TableColumn<pigData, String> addpig_col_date;
    
    @FXML
    private TableColumn<pigData, Integer> addpig_col_monthOfPig;
    
    @FXML
    private AnchorPane purchase_form;

    @FXML
    private ComboBox<?> purchase_status;
    
     @FXML
    private TextField purchase_name;

    @FXML
    private TextField purchase_phone;

    @FXML
    private TextField purchase_gender;

    @FXML
    private TextField purchase_age;

    @FXML
    private TextField purchase_address;
    
    @FXML
    private Spinner<Integer> purchase_quantity;

    @FXML
    private ComboBox<?> purchase_pigID;

    @FXML
    private Button purchase_addBtn;

    @FXML
    private Label purchase_total;

    @FXML
    private TextField purchase_amount;

    @FXML
    private Label purchase_balance;

    @FXML
    private Button purchase_payBtn;
    
    @FXML
    private Button purchase_receiptBtn;

    @FXML
    private TableView<customerData> purchase_tableView;

    @FXML
    private TableColumn<customerData, String> purchase_col_pigid;
    
    @FXML
    private TableColumn<customerData, String> purchase_col_name;

    @FXML
    private TableColumn<customerData, String> purchase_col_phone;

    @FXML
    private TableColumn<customerData, String> purchase_col_gender;

    @FXML
    private TableColumn<customerData, String> purchase_col_age;

    @FXML
    private TableColumn<customerData, String> purchase_col_type;

    @FXML
    private TableColumn<customerData, String> purchase_col_qty;

    @FXML
    private TableColumn<customerData, String> purchase_col_price;
    
    @FXML
    private AnchorPane customerInfo_form;
    
     @FXML
    private TableView<customerData> custInfo_tableView;

    @FXML
    private TableColumn<customerData, String> custInfo_col_pigID;

    @FXML
    private TableColumn<customerData, String> custInfo_col_name;

    @FXML
    private TableColumn<customerData, String> custInfo_col_gender;

    @FXML
    private TableColumn<customerData, String> custInfo_col_age;

    @FXML
    private TableColumn<customerData, String> custInfo_col_phone;

    @FXML
    private TableColumn<customerData, String> custInfo_col_address;

    @FXML
    private TableColumn<customerData, String> custInfo_col_quantity;

    @FXML
    private TableColumn<customerData, String> custInfo_col_price;

    @FXML
    private TableColumn<customerData, String> custInfo_col_date;
    
    @FXML
    private TextField custInfo_search;
     
    @FXML
    private Button custInfo_print;

    
    //DATABSE TOOLS 
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    
    
    public void homeChart(){
        
        dashboard_chart.getData().clear();
        
        String sql = " SELECT date, SUM(total) FROM customer_info"
                + " GROUP BY date ORDER BY TIMESTAMP (date) ASC LIMIT 9 ";
        
        connect = database.connectDb();
        
        try{
            
            XYChart.Series chart = new XYChart.Series();
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }
            
            dashboard_chart.getData().add(chart);
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void homeAP(){
        
        String sql = "SELECT COUNT(status) FROM piginfo WHERE status = 'Available' ";
        
        connect = database.connectDb();
        
        int countAP = 0;
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            
            while(result.next()){
                
                countAP = result.getInt("COUNT(status)");
                
            }
            
            dashboard_availablePig.setText(String.valueOf(countAP));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void homeTI()
    {
        
        String sql = " SELECT SUM(total) FROM customer_info ";
        
        connect = database.connectDb();
        
        double totalDisplay = 0;
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while (result.next()){
                
                totalDisplay = result.getDouble("SUM(total)");
                
            }
            
            dashboard_totalIncome.setText("₱" + String.valueOf(totalDisplay));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
 
    public void homeTC(){
        
        String sql = "SELECT COUNT(id) FROM customer_info ";
        
        connect = database.connectDb();
        
        int countTC = 0;
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                countTC = result.getInt("COUNT(id)");
            }
            
            dashboard_totalCustomers.setText(String.valueOf(countTC));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void addPigAdd(){
    
        String sql =    "INSERT INTO piginfo (pig_id, status, price, date, ageOfPig)" + "VALUES( ?, ?, ?, ?, ?)";
        
        connect = database.connectDb();
        
        try{
            
            Alert alert;
            
            if(addpig_pigID.getText().isEmpty()
                    || addpig_status.getSelectionModel().getSelectedItem() == null
                    || addpig_price.getText().isEmpty()
                    || addpig_monthOfPig.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {
                
                String checkData = "SELECT pig_id FROM piginfo WHERE pig_id = '"+addpig_pigID.getText()+"'";
                
                statement = connect.createStatement();
                result = statement.executeQuery(checkData);
                
                if(result.next()){
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Pig ID: " + addpig_pigID.getText() + " was already exist!");
                    alert.showAndWait();
                }else{
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, addpig_pigID.getText());
                    prepare.setString(2, (String)addpig_status.getSelectionModel().getSelectedItem());
                    prepare.setString(3, addpig_price.getText());


                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    prepare.setString(4, String.valueOf(sqlDate));
                    prepare.setString(5, addpig_monthOfPig.getText());
                    
                    prepare.executeUpdate();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    addPigShowListData();
                    addPigReset();

                }
            }
            
        }catch(Exception e){e.printStackTrace();}
    }
    
    public void addPigUpdate(){
        
        
        String sql = "UPDATE piginfo SET status = '"
                +addpig_status.getSelectionModel().getSelectedItem()+"', ageOfPig = '"
                +addpig_monthOfPig.getText()+"', price = '"
                +addpig_price.getText()+"' WHERE pig_id = '"+addpig_pigID.getText()+"' ";
        
        connect = database.connectDb();
        
        try{
            
            Alert alert;
            
            if(addpig_pigID.getText().isEmpty()
                    || addpig_status.getSelectionModel().getSelectedItem() == null
                    || addpig_price.getText().isEmpty()
                    || addpig_monthOfPig.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {
                
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Pig ID:" + addpig_pigID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                    
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                    
                    addPigShowListData();
                    addPigReset();
                    
                }
            }
            
        }catch(Exception e){e.printStackTrace();}
    }
    
    public void addPigDelete(){
        
        String sql = "DELETE FROM piginfo WHERE pig_id = '"+addpig_pigID.getText()+"'";
        
        connect = database.connectDb();
        
        try{
            
            Alert alert;
            
            if(addpig_pigID.getText().isEmpty()
                    || addpig_status.getSelectionModel().getSelectedItem() == null
                    || addpig_price.getText().isEmpty()
                    || addpig_monthOfPig.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {
                
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Pig ID:" + addpig_pigID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                    
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();
                    
                    addPigShowListData();
                    addPigReset();
                    
                }
            }
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void addPigReset(){
        
        addpig_pigID.setText("");
        addpig_price.setText("");
        addpig_monthOfPig.setText("");
        addpig_status.getSelectionModel().clearSelection();
        
    }
    
    private String[] addPigStatus = {"Available", "Sold"};
    public void addPigListStatus(){
        
        List<String> listS = new ArrayList<>();
        
        for(String data: addPigStatus){
            listS.add(data);
        }
        
        ObservableList listData = FXCollections.observableArrayList(listS);
        addpig_status.setItems(listData);
 
    }
    

    
    public ObservableList<pigData> addPigListData(){
        
        String sql = "SELECT * FROM piginfo";
        
        ObservableList<pigData> listData = FXCollections.observableArrayList();
        
        connect = database.connectDb();
         
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            pigData pigData;
            
            while (result.next()){
                pigData = new pigData(result.getInt("pig_id"), 
                        result.getString("status"), result.getDouble("price"), 
                        result.getDate("date"), result.getInt("ageOfPig") ); 
                
                listData.add(pigData);
            }
            
        }catch (Exception e){e.printStackTrace();}
        return listData;
    }
    
    private ObservableList<pigData>addPigList;
    public void addPigShowListData(){
        
        addPigList = addPigListData();
        addpig_col_pigID.setCellValueFactory(new PropertyValueFactory<>("pigId"));
        addpig_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        addpig_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        addpig_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        addpig_col_monthOfPig.setCellValueFactory(new PropertyValueFactory<>("ageOfPig"));
        
        addpig_tableView.setItems(addPigList);
        
    }
    
    public void addPigSearch(){
        
        FilteredList<pigData> filter = new FilteredList<>(addPigList, e-> true);
        
        addpig_search.textProperty().addListener((Obervable, oldValue, newValue)->{
            
            filter.setPredicate(predicatePigData -> {
                
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                String searchKey = newValue.toLowerCase();
                
                if(predicatePigData.getPigId().toString().contains(searchKey)){
                    return true;
                }else if(predicatePigData.getStatus().toLowerCase().contains(searchKey)){
                    return true;
                }else if(predicatePigData.getPrice().toString().contains(searchKey)){
                    return true;
                }else if(predicatePigData.getDate().toString().contains(searchKey)){
                    return true;
                }else return false;
                
            });
            
        });
        
        SortedList<pigData> sortList = new SortedList<>(filter);
        
        sortList.comparatorProperty().bind(addpig_tableView.comparatorProperty());
        addpig_tableView.setItems(sortList);
        
    } 
    
    public void addPigSelect(){
        
        pigData pigData = addpig_tableView.getSelectionModel().getSelectedItem();
        int num = addpig_tableView.getSelectionModel().getSelectedIndex();
        
        if ((num - 1) < - 1){return;}
        
        addpig_pigID.setText(String.valueOf(pigData.getPigId()));
        addpig_price.setText(String.valueOf(pigData.getPrice()));
        addpig_monthOfPig.setText(String.valueOf(pigData.getAgeOfPig()));
        
        
    }
    
    private double totalP;
    public void purchaseAdd(){
        purchaseCustomerId();
        
        String sql = "INSERT INTO customer (customer_id, name, gender, age, phone, address, ageOfPig, pig_id, quantity, price, date)" 
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        connect = database.connectDb();
        
        try{
            
            Alert alert;
            
            if(purchase_status.getSelectionModel().getSelectedItem() == null
                    || purchase_pigID.getSelectionModel().getSelectedItem() == null){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {
                
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, String.valueOf(customerId));
                prepare.setString(2, (String)purchase_name.getText());
                prepare.setString(3, (String)purchase_gender.getText());
                prepare.setString(4, (String)purchase_age.getText());
                prepare.setString(5, (String)purchase_phone.getText());
                prepare.setString(6, (String)purchase_address.getText());
                prepare.setString(7, (String)purchase_status.getSelectionModel().getSelectedItem());
                prepare.setString(8, (String)purchase_pigID.getSelectionModel().getSelectedItem());
                prepare.setString(9, String.valueOf(qty));
                
                String checkData = "SELECT price FROM piginfo WHERE pig_id = '"
                        +purchase_pigID.getSelectionModel().getSelectedItem()+"' ";
                
                statement = connect.createStatement();
                result = statement.executeQuery(checkData);
                
                double priceD = 0;
                if(result.next()){
                     
                    priceD = result.getDouble("price");    
                }
                
                totalP = (priceD * qty);
                
                prepare.setString(10, String.valueOf(totalP));
                
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                prepare.setString(11, String.valueOf(sqlDate));
                
                
                
            prepare.executeUpdate();
            purchaseShowListData();
            purchaseDisplayTotal();
            
            }
            prepare = connect.prepareStatement(sql);
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    private double totalPriceD;
    public void purchaseDisplayTotal(){
        
        String sql = "SELECT SUM(price) FROM customer WHERE customer_id = '"+customerId+"' ";
        
        connect = database.connectDb();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if(result.next()){
                
                totalPriceD = result.getDouble("SUM(price)");
                
            }
            purchase_total.setText("₱" + String.valueOf(totalPriceD));
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    
    private double balance;
    private double amount;
    public void purchasAmount(){
        
        if(purchase_amount.getText().isEmpty() || totalPriceD == 0){
            
            Alert alert = new Alert (AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid");
            alert.showAndWait();
            
        }else{
            
            amount = Double.parseDouble(purchase_amount.getText());
            if(totalPriceD > amount){
                
                purchase_amount.setText("");
                
            }else
            balance = (amount - totalPriceD);
            
            purchase_balance.setText("₱" + String.valueOf(balance));
        }
        
    }
    
    public void purchasePay(){
        purchaseCustomerId();
        
        String sql = " INSERT INTO customer_info (customer_id, total, date) "
                + "VALUES(?,?,?) ";
        
        connect = database.connectDb();
        
        try{
            
            Alert alert;
            
            if(totalPriceD == 0){
                
                alert = new Alert(AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Something wrong");
                alert.showAndWait();
                
            }else{
                
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");
                Optional<ButtonType> option =  alert.showAndWait();
                
                    if(option.get().equals(ButtonType.OK)){
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, String.valueOf(customerId));
                    prepare.setString(2, String.valueOf(totalPriceD));

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(3, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Successful!");
                    alert.showAndWait();
                    
                    purchase_amount.setText("");
                    purchase_balance.setText("₱0.0");
                }
            }
            
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    private SpinnerValueFactory<Integer> spinner;
    public void purchaseShowValue(){
        
        spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20, 0);
        purchase_quantity.setValueFactory(spinner);
        
    }
    
    private int qty;
    public void purchaseQuantity(){
        
        qty = purchase_quantity.getValue();
        
    }
    
    public ObservableList<customerData> purchaseListData(){
        purchaseCustomerId();
        
        String sql = "SELECT * FROM customer WHERE customer_id = '"+customerId+"' ";
        
        ObservableList<customerData> listData = FXCollections.observableArrayList();
        
        connect = database.connectDb();
        
        try{
            customerData customerD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while (result.next()){
                
                customerD = new customerData(result.getInt("customer_id"),result.getString("name"),
                        result.getString("gender"), result.getInt("age"),result.getInt("phone"),
                        result.getString("address"),result.getString("ageOfPig"), result.getInt("pig_id")
                        ,result.getInt("quantity"), result.getDouble("price"), result.getDate("date"));
                
                listData.add(customerD);
            }
            
        }catch(Exception e){e.printStackTrace();}
        return listData;
        
    }
    
    private ObservableList<customerData> purchaseList;
    public void purchaseShowListData(){
        
        purchaseList = purchaseListData();
        
        purchase_col_pigid.setCellValueFactory(new PropertyValueFactory("pigId"));
        purchase_col_name.setCellValueFactory(new PropertyValueFactory("name"));
        purchase_col_phone.setCellValueFactory(new PropertyValueFactory("phone"));
        purchase_col_gender.setCellValueFactory(new PropertyValueFactory("gender"));
        purchase_col_age.setCellValueFactory(new PropertyValueFactory("age"));
        purchase_col_qty.setCellValueFactory(new PropertyValueFactory("quantity"));
        purchase_col_price.setCellValueFactory(new PropertyValueFactory("price"));
        
        purchase_tableView.setItems(purchaseList);
        
    }
    
    public ObservableList<customerData> customerListData(){
        
        String sql = "SELECT * FROM customer";
        
        ObservableList<customerData> listData = FXCollections.observableArrayList();
        
        connect = database.connectDb();
         
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            customerData customerData;
            
            while (result.next()){
                customerData = new customerData(result.getInt("customer_id"),result.getString("name"),
                        result.getString("gender"), result.getInt("age"),result.getInt("phone"),
                        result.getString("address"),result.getString("ageOfPig"), result.getInt("pig_id")
                        ,result.getInt("quantity"), result.getDouble("price"), result.getDate("date")); 
                
                listData.add(customerData);
            }
            
        }catch (Exception e){e.printStackTrace();}
        return listData;
    }
    
    private ObservableList<customerData>customerList;
    public void customerShowListData(){
        
        customerList = customerListData();
        custInfo_col_pigID.setCellValueFactory(new PropertyValueFactory<>("pigId"));
        custInfo_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        custInfo_col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        custInfo_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        custInfo_col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        custInfo_col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        custInfo_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        custInfo_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        custInfo_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        custInfo_tableView.setItems(customerList);
        
    }
    
    public void custInfoSearch(){
        
        FilteredList<customerData> filter = new FilteredList<>(customerList, e-> true);
        
        custInfo_search.textProperty().addListener((Obervable, oldValue, newValue)->{
            
            filter.setPredicate(predicatecustomerData -> {
                
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                
                String searchKey = newValue.toLowerCase();
                
                if(predicatecustomerData.getPigId().toString().contains(searchKey)){
                    return true;
                }else if(predicatecustomerData.getName().toLowerCase().contains(searchKey)){
                    return true;
                }else if(predicatecustomerData.getGender().toLowerCase().contains(searchKey)){
                    return true;
                }else if(predicatecustomerData.getAge().toString().contains(searchKey)){
                    return true;
                }else if(predicatecustomerData.getPhone().toString().contains(searchKey)){
                    return true;
                }else if(predicatecustomerData.getAddress().toLowerCase().contains(searchKey)){
                    return true;
                }else if(predicatecustomerData.getQuantity().toString().contains(searchKey)){
                    return true;
                }else if(predicatecustomerData.getPrice().toString().contains(searchKey)){
                    return true;
                }else if(predicatecustomerData.getDate().toString().contains(searchKey)){
                    return true;
                }else return false;
                
            });
            
        });
        
        SortedList<customerData> sortList = new SortedList<>(filter);
        
        sortList.comparatorProperty().bind(custInfo_tableView.comparatorProperty());
        custInfo_tableView.setItems(sortList);
        
    }
        
    private int cID;
    public void receiptBtn(){
        
            HashMap map = new HashMap();
            
            
            try {
                
                JasperDesign jDesign = JRXmlLoader.load("C:\\Users\\Donald\\OneDrive\\Documents\\NetBeansProjects\\GastadorPiggeryFarmFinal\\src\\GastadorPiggeryFarm\\report1.jrxml");
                JasperReport jReport = JasperCompileManager.compileReport(jDesign);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, map, connect);
                
                JasperViewer.viewReport(jPrint, false);
                
         
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
    }
    
    public void reportBtn(){
        
            HashMap map = new HashMap();
            
            
            try {
                
                JasperDesign jDesign = JRXmlLoader.load("C:\\Users\\Donald\\OneDrive\\Documents\\NetBeansProjects\\GastadorPiggeryFarmFinal\\src\\GastadorPiggeryFarm\\report2.jrxml");
                JasperReport jReport = JasperCompileManager.compileReport(jDesign);
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, map, connect);
                
                JasperViewer.viewReport(jPrint, false);
                
         
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
    }
    
    
    private int customerId;
    public void purchaseCustomerId(){
        
        String sql = " SELECT customer_id FROM customer  ";
        
        connect = database.connectDb();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while (result.next()){
                
                customerId = result.getInt("customer_id");
                
            }
            
            int cID = 0;
            String checkData = "SELECT customer_id FROM customer_info";
            
            statement = connect.createStatement();
            result = statement.executeQuery(checkData);
            
            while(result.next()){
                
                cID = result.getInt("customer_id");
                
            }
            
            if(customerId == 0){
                
                customerId += 1;
            }else if (cID == customerId){
                
                customerId = cID+1;
                
            }
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void purchaseType(){
        
        String sql = "SELECT status FROM piginfo WHERE status = 'Available'";
        
        connect = database.connectDb();
                
                try{
                    
                    ObservableList listData = FXCollections.observableArrayList();
                    
                    
                    prepare = connect.prepareStatement(sql);
                    result = prepare.executeQuery();
                    
                    while(result.next()){
                        listData.add(result.getString("status"));
                    }
                    
                    purchase_status.setItems(listData);
                    
                    purchasePigId();
                    
                }catch (Exception e){e.printStackTrace();}
        
    }
    
    public void purchasePigId(){
        
        String sql = "SELECT * FROM piginfo WHERE status = '"
                +purchase_status.getSelectionModel().getSelectedItem()+"' ";
        
        connect = database.connectDb();
        
        try{
            ObservableList listData = FXCollections.observableArrayList();
            
            prepare = connect.prepareStatement(sql); 
            result = prepare.executeQuery();
            
            while (result.next()){
                listData.add(result.getString("pig_id"));
            }
            
            purchase_pigID.setItems(listData);
            
           
            
        }catch (Exception e){e.printStackTrace();}
        
    }
    
    public void defaultNav(){
        
        dashboard_btn.setStyle("-fx-background-color: #4afcea");
        
    }
    
    public void switchForm(ActionEvent event){
        
        
        if (event.getSource() == dashboard_btn){
            dashboard_form.setVisible(true);
            addPig_form.setVisible(false);
            purchase_form.setVisible(false);
            customerInfo_form.setVisible(false);
            
            dashboard_btn.setStyle("-fx-background-color: #4afcea");
            addPig_btn.setStyle("-fx-background-color: transparent");
            purchase_btn.setStyle("-fx-background-color: transparent");
            customerInfo_btn.setStyle("-fx-background-color: transparent");
            
            homeAP();
            homeTI();
            homeTC();
            homeChart();
            
            
        }else if (event.getSource() == addPig_btn){
            
            dashboard_form.setVisible(false);
            addPig_form.setVisible(true);
            purchase_form.setVisible(false);
            customerInfo_form.setVisible(false);
           
            addPig_btn.setStyle("-fx-background-color: #4afcea");
            dashboard_btn.setStyle("-fx-background-color: transparent");
            purchase_btn.setStyle("-fx-background-color: transparent");
            customerInfo_btn.setStyle("-fx-background-color: transparent");
            
            addPigShowListData();
            addPigListStatus();
            addPigSearch();
            
            
        }else if (event.getSource() == purchase_btn){
            
            dashboard_form.setVisible(false);
            addPig_form.setVisible(false);
            purchase_form.setVisible(true);
            customerInfo_form.setVisible(false);
            
            purchase_btn.setStyle("-fx-background-color: #4afcea");
            dashboard_btn.setStyle("-fx-background-color: transparent");
            addPig_btn.setStyle("-fx-background-color: transparent");
            customerInfo_btn.setStyle("-fx-background-color: transparent");
            
            purchaseType();
            purchasePigId();
            purchaseShowListData();
            purchaseShowValue();
            purchaseDisplayTotal();
            
        }else if (event.getSource() == customerInfo_btn){
            
            dashboard_form.setVisible(false);
            addPig_form.setVisible(false);
            purchase_form.setVisible(false);
            customerInfo_form.setVisible(true);
            
            purchase_btn.setStyle("-fx-background-color: transparent");
            dashboard_btn.setStyle("-fx-background-color: transparent");
            addPig_btn.setStyle("-fx-background-color: transparent");
            customerInfo_btn.setStyle("-fx-background-color: #4afcea");
            
            customerShowListData();
            custInfoSearch();
           
        }
        
    }
    
    public void displayUsername(){
        String user = getData.username;
        
            // BIG LETTER THE FIRST LETTER THEN THE REST ARE SMALL LETTER
        username.setText(user.substring(0,1).toUpperCase() + user.substring(1));
    }

    private double x = 0;
    private double y = 0;

    public void logout() {

        try {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("CONFIRMATION MESSAGE");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                //HIDE THE DASHBOARD FORM
                logout.getScene().getWindow().hide();
                   //LINK OF LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                    root.setOnMousePressed((MouseEvent event) -> {
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });

                    root.setOnMouseDragged((MouseEvent event) -> {
                            stage.setX(event.getScreenX() - x);
                            stage.setY(event.getScreenY() - y);

                            stage.setOpacity(.8);
                        });

                    root.setOnMouseReleased((MouseEvent event) -> {
                        stage.initStyle(StageStyle.TRANSPARENT);

                    });

                        

                        stage.setScene(scene);
                        stage.show();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void close() {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        displayUsername();   
        defaultNav();
        
        homeAP();
        homeTI();
        homeTC();
        homeChart();
        
        addPigShowListData();
        addPigListStatus();
        
        purchaseType();
        purchasePigId();
        purchaseShowListData();
        purchaseShowValue();
        purchaseDisplayTotal();
        
        customerShowListData();
    }

    

}
