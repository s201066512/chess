module com.example.c_h_e_s_s {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.c_h_e_s_s to javafx.fxml;
    exports com.example.c_h_e_s_s;
}