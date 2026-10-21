module ni.edu.uam.actividadpracticaventas {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.actividadpracticaventas to javafx.fxml;
    exports ni.edu.uam.actividadpracticaventas;
}