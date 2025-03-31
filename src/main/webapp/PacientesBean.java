import com.mycompany.proyectofinal.dao.PacienteDAO;
import com.mycompany.proyectofinal.constructor.constructorPaciente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Named("pacienteBean") // Nombre EXACTO usado en el XHTML
@ApplicationScoped      // Debe ser al menos ApplicationScoped o RequestScoped
public class PacientesBean {
    
    private List<constructorPaciente> listaPacientes;

    public PacientesBean() {
        cargarPacientes();
    }

    public void cargarPacientes() {
        listaPacientes = new ArrayList<>();

        // Agregar datos de prueba manualmente
        listaPacientes.add(new constructorPaciente(12345678, "Juan Pérez", "Calle 123", 987654321, "2024-01-10", "Consulta general", "Ninguna"));
        listaPacientes.add(new constructorPaciente(87654321, "Ana Gómez", "Av. Principal", 912345678, "2024-02-15", "Control de lentes", "Miopía"));
        listaPacientes.add(new constructorPaciente(11223344, "Carlos Ramírez", "Jr. Secundario", 956789123, "2024-03-20", "Chequeo anual", "Hipermetropía"));
    }

    public List<constructorPaciente> getListaPacientes() {
        return listaPacientes;
    }
}