/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package componente;

import componente.clases.CitaPersona;
import componente.clases.DiagnosticoPersona;
import componente.clases.RegistroMedicamento;
import componente.clases.RegistroPersona;
import componente.clases.TratamientoPersona;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * Leslie y Nayha
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private UserDatabase userDatabase;
    private Color customColorBG = new Color(102, 153, 255); // Color de fondo personalizado
    private Color customColorOriginal = new Color(51, 153, 255); // Color original
    private Font boldFont; // Fuente en negrita
    private Font originalFont; // Fuente original
    private boolean isEditar = false; // Validacion para modificar entradas
    private String nombre;
    private String apellido;
    private String email;
    private String especialidad;
    private String telefono;
    private long fechaNacimiento;

    private DefaultTableModel tablaPanel2 = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private DefaultTableModel tablaPanel3 = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private DefaultTableModel tablaPanel4 = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private DefaultTableModel tablaPanel5 = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private DefaultTableModel tablaPanel6 = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        originalFont = btnCuentaUser.getFont(); // Obtiene la fuente original del botón
        // Si la fuente original es nula, asigna una fuente predeterminada y establece el botón con esta fuente
        if (originalFont == null) {
            originalFont = new Font("Arial", Font.PLAIN, 12);
            btnCuentaUser.setFont(originalFont);
        }

        boldFont = originalFont.deriveFont(Font.BOLD); // Crea una fuente en negrita basada en la fuente original
        btnCuentaUser.setFocusPainted(false); // Evita que el botón tenga un efecto de pintura cuando recibe foco
        btnClose.setFocusPainted(false); // Evita que el botón "Cerrar" tenga un efecto de pintura cuando recibe foco

        habilitarCampos(false);

        tablaPanel2.addColumn("Nombre Completo");
        tablaPanel2.addColumn("Genero");
        tablaPanel2.addColumn("Edad");
        tablaPanel2.addColumn("DNI/Pasaporte");
        tablaPanel2.addColumn("Nacionalidad");
        tablaPanel2.addColumn("Telefono");
        tablaPanel2.addColumn("Correo Electronico");
        tablaPanel2.addColumn("Estado Civil");

        tablaPanel3.addColumn("Nombre Completo");
        tablaPanel3.addColumn("Nombre del Tratamiento");
        tablaPanel3.addColumn("Fecha inicio");
        tablaPanel3.addColumn("Fecha final");
        tablaPanel3.addColumn("Duracion");
        tablaPanel3.addColumn("Dosis");
        tablaPanel3.addColumn("Frecuencia");
        tablaPanel3.addColumn("Estado del Tratamiento");
        tablaPanel3.addColumn("Médico Encargado");
        tablaPanel3.addColumn("Observaciones");

        tablaPanel4.addColumn("Nombre");
        tablaPanel4.addColumn("Apellido Paterno");
        tablaPanel4.addColumn("Apellido Materno");
        tablaPanel4.addColumn("Edad");
        tablaPanel4.addColumn("Télefono");
        tablaPanel4.addColumn("Fecha");
        tablaPanel4.addColumn("Hora");

        tablaPanel5.addColumn("Nombre Completo");
        tablaPanel5.addColumn("Fecha");
        tablaPanel5.addColumn("Tipo de Diagnóstico");
        tablaPanel5.addColumn("Resultado Diagnóstico");
        tablaPanel5.addColumn("Médico Encargado");
        tablaPanel5.addColumn("Observacion");

        tablaPanel6.addColumn("Nombre Científico");
        tablaPanel6.addColumn("Marca Comercial");
        tablaPanel6.addColumn("Forma Farmacéutica");
        tablaPanel6.addColumn("Dosis");
        tablaPanel6.addColumn("Fecha Caducida");
        tablaPanel6.addColumn("Lote de Fabricación");
        tablaPanel6.addColumn("Número de Registro Sanitario");
        tablaPanel6.addColumn("Cantidad Disponible");

        refrescarTabla();
        inicializarCamposVaciosTabla2();
        inicializarCamposVaciosTabla3();
        inicializarCamposVaciosTabla4();
        inicializarCamposVaciosTabla5();
        inicializarCamposVaciosTabla6();
    }

    private void refrescarTabla() {
        tablaCitaProgramada.setModel(tablaPanel4);
        tablaDiag.setModel(tablaPanel5);
        tablaRegistro.setModel(tablaPanel6);
        tablaTratamiento.setModel(tablaPanel3);
        registroTabla.setModel(tablaPanel2);
    }

    private void habilitarCampos(boolean habilitar) {
        inputNombre.setEnabled(habilitar);
        inputApellido.setEnabled(habilitar);
        inputDate.setEnabled(habilitar);
        inputEmail.setEnabled(habilitar);
        inputEspecialidad.setEnabled(habilitar);
        inputTelefono.setEnabled(habilitar);

        if (!habilitar) {
            inputNombre.setText(nombre);
            inputApellido.setText(apellido);
            inputEmail.setText(email);
            inputEspecialidad.setText(especialidad);
            inputTelefono.setText(telefono);
        }
    }

    private void cambiarColorFuenteCampos(Color color) {
        inputNombre.setForeground(color);
        inputApellido.setForeground(color);
        inputDate.setForeground(color);
        inputEmail.setForeground(color);
        inputEspecialidad.setForeground(color);
        inputTelefono.setForeground(color);
    }

    private boolean camposEstanLlenosCita() {
        return !inputNombrePaciente.getText().isEmpty()
                && !inputApellidoPaternoCita.getText().isEmpty()
                && !inputApellidoMaternoCita.getText().isEmpty()
                && !inputCitaEdad.getText().isEmpty()
                && !inputTelefonoCita.getText().isEmpty()
                && inputFechaCita.getDate() != null
                && inputHora.getSelectedItem() != null;
    }

    private boolean camposEstanLlenosDiag() {
        return !inputNombreDiag.getText().isEmpty()
                && inputDateDiag.getDate() != null
                && inputTipoDiag.getSelectedItem() != null
                && !inputResultDiag.getText().isEmpty()
                && !inputMedDiag.getText().isEmpty()
                && !inputObsDiag.getText().isEmpty();
    }

    private boolean camposEstanLlenosReg() {
        return !inputNombreRegist.getText().isEmpty()
                && !inputMarcaRegist.getText().isEmpty()
                && !inputFormaRegist.getText().isEmpty()
                && !inputDosisRegist.getText().isEmpty()
                && inputDateRegist.getDate() != null
                && !inputLoteRegist.getText().isEmpty()
                && !inputRegistroSani.getText().isEmpty()
                && !inputCantidadRegist.getText().isEmpty();
    }

    private boolean camposEstanLlenosTratamiento() {
        return !inputNombreCompletoTrat.getText().isEmpty()
                && !inputNombreTrata.getText().isEmpty()
                && dateInicioTrat.getDate() != null
                && dateFechaFinalTrata.getDate() != null
                && !inputDuracionTrata.getText().isEmpty()
                && !inputDosisTrata.getText().isEmpty()
                && inputFrecuenciaTrata.getSelectedItem() != null
                && inputEstadoTrata.getSelectedItem() != null
                && !inputMedicoTrata.getText().isEmpty()
                && !inputObsTrata.getText().isEmpty();
    }

    private boolean camposEstanLlenosRegistro() {
        return !inputRegistroNombre.getText().isEmpty()
                && inputBoxGenero.getSelectedItem() != null
                && !inputEdadRegistro.getText().isEmpty()
                && !inputDNIRegistro.getText().isEmpty()
                && !inputRegistroPais.getText().isEmpty()
                && !inputRegistroTele.getText().isEmpty()
                && !inputEmailRegistro.getText().isEmpty()
                && inputBoxEstado.getSelectedItem() != null;
    }

    private void inicializarCamposVaciosTabla3() {
        inputNombreCompletoTrat.setText("");
        inputNombreTrata.setText("");
        dateInicioTrat.setDate(null);
        dateFechaFinalTrata.setDate(null);
        inputDuracionTrata.setText("");
        inputDosisTrata.setText("");
        inputFrecuenciaTrata.setSelectedIndex(0);
        inputEstadoTrata.setSelectedIndex(0);
        inputMedicoTrata.setText("");
        inputObsTrata.setText("");
    }

    private void inicializarCamposVaciosTabla4() {
        inputNombrePaciente.setText("");
        inputApellidoPaternoCita.setText("");
        inputApellidoMaternoCita.setText("");
        inputCitaEdad.setText("");
        inputTelefonoCita.setText("");
        inputFechaCita.setDate(null);
        inputHora.setSelectedIndex(0);
    }

    private void inicializarCamposVaciosTabla5() {
        inputNombreDiag.setText("");
        inputDateDiag.setDate(null);
        inputTipoDiag.setSelectedIndex(0);
        inputResultDiag.setText("");
        inputMedDiag.setText("");
        inputObsDiag.setText("");
    }

    private void inicializarCamposVaciosTabla6() {
        inputNombreRegist.setText("");
        inputMarcaRegist.setText("");
        inputFormaRegist.setText("");
        inputDosisRegist.setText("");
        inputDateRegist.setDate(null);
        inputLoteRegist.setText("");
        inputRegistroSani.setText("");
        inputCantidadRegist.setText("");
    }

    public void inicializarCamposVaciosTabla2() {
        inputRegistroNombre.setText("");
        inputBoxGenero.setSelectedIndex(0);
        inputEdadRegistro.setText("");
        inputDNIRegistro.setText("");
        inputRegistroPais.setText("");
        inputRegistroTele.setText("");
        inputEmailRegistro.setText("");
        inputBoxEstado.setSelectedIndex(0);
    }

    private void almacenarInformacion() {
        nombre = inputNombre.getText();
        apellido = inputApellido.getText();
        email = inputEmail.getText();
        especialidad = inputEspecialidad.getText();
        telefono = inputTelefono.getText();

        Date fechaInput = inputDate.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fechaNacimiento = fechaInput.getTime();
        textName.setText(nombre);
        textEspecialidad.setText(especialidad);
        textHappyBirthday.setText(sdf.format(inputDate.getCalendar().getTime()));
    }

    public RegistroPersona obtenerPersonaRegistro() {
        String nombreCompleto = inputRegistroNombre.getText();
        String genero = (String) inputBoxGenero.getSelectedItem();
        String edad = inputEdadRegistro.getText();
        String dni = inputDNIRegistro.getText();
        String nacionalidad = inputRegistroPais.getText();
        String telefono = inputRegistroTele.getText();
        String email = inputEmailRegistro.getText();
        String estadoCivil = (String) inputBoxEstado.getSelectedItem();

        return new RegistroPersona(nombreCompleto, genero, edad, dni, nacionalidad, telefono, email, estadoCivil);
    }

    public TratamientoPersona obtenerDatosTratamiento() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String nombreCompleto = inputNombreCompletoTrat.getText();
        String nombreTratamiento = inputNombreTrata.getText();
        String fechaInicial = sdf.format(dateInicioTrat.getCalendar().getTime());
        String fechaFinal = sdf.format(dateFechaFinalTrata.getCalendar().getTime());
        String duracion = inputDuracionTrata.getText();
        String dosis = inputDosisTrata.getText();
        String frecuencia = (String) inputFrecuenciaTrata.getSelectedItem();
        String estadoTratamiento = (String) inputEstadoTrata.getSelectedItem();
        String medicoEncargado = inputMedicoTrata.getText();
        String observacion = inputObsTrata.getText();

        return new TratamientoPersona(nombreCompleto, nombreTratamiento, fechaInicial, fechaFinal, duracion, dosis, frecuencia, estadoTratamiento, medicoEncargado, observacion);
    }

    public CitaPersona obtenerDatosCita() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String nombreCita = inputNombrePaciente.getText();
        String apellidoPaternoCita = inputApellidoPaternoCita.getText();
        String apellidoMaternoCita = inputApellidoMaternoCita.getText();
        String edadPacienteCita = inputCitaEdad.getText();
        String telefonoCita = inputTelefonoCita.getText();
        Date fechaCita = inputFechaCita.getDate();
        String fechaCitaPaciente = sdf.format(inputFechaCita.getCalendar().getTime());
        String horaCita = (String) inputHora.getSelectedItem();

        return new CitaPersona(nombreCita, apellidoPaternoCita, apellidoMaternoCita, edadPacienteCita, telefonoCita, fechaCitaPaciente, horaCita);
    }

    public DiagnosticoPersona obtenerDatosDiag() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String nombreDiag = inputNombreDiag.getText();
        Date fechaDiag = inputDateDiag.getDate();
        String fechaPacienteDiag = sdf.format(inputDateDiag.getCalendar().getTime());
        String tipoResultadoDiag = (String) inputTipoDiag.getSelectedItem();
        String resultadoDiag = inputResultDiag.getText();
        String medicoEnc = inputMedDiag.getText();
        String obsDiag = inputObsDiag.getText();

        return new DiagnosticoPersona(nombreDiag, fechaPacienteDiag, tipoResultadoDiag, resultadoDiag, medicoEnc, obsDiag);
    }

    public RegistroMedicamento obtenerDatosReg() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String nombreCientifico = inputNombreRegist.getText();
        String marcaComercial = inputMarcaRegist.getText();
        String formaFarmaceutica = inputFormaRegist.getText();
        String dosisRegistro = inputDosisRegist.getText();
        String fechaCaducida = sdf.format(inputDateRegist.getCalendar().getTime());
        String loteFabricacion = inputLoteRegist.getText();
        String numeroRegistro = inputRegistroSani.getText();
        String cantidadDisponible = inputCantidadRegist.getText();

        return new RegistroMedicamento(nombreCientifico, marcaComercial, formaFarmaceutica, dosisRegistro, fechaCaducida, loteFabricacion, numeroRegistro, cantidadDisponible);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        textName = new javax.swing.JLabel();
        textHappyBirthday = new javax.swing.JLabel();
        textEspecialidad = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnCuentaUser = new javax.swing.JButton();
        btnRegistroPacientes = new javax.swing.JButton();
        btnRegistroMedicamentos = new javax.swing.JButton();
        btnCitasProgramadas = new javax.swing.JButton();
        btnRegistroDiagnosticos = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnRegistroTratamientos = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        panelMenu = new javax.swing.JTabbedPane();
        panelCuentaUsuario = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        inputNombre = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        inputApellido = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        inputEspecialidad = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        inputTelefono = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        inputDate = new com.toedter.calendar.JDateChooser();
        panelRegistroPaciente = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        inputRegistroNombre = new javax.swing.JTextField();
        inputBoxGenero = new javax.swing.JComboBox<>();
        inputEdadRegistro = new javax.swing.JTextField();
        inputDNIRegistro = new javax.swing.JTextField();
        inputRegistroPais = new javax.swing.JTextField();
        inputRegistroTele = new javax.swing.JTextField();
        inputEmailRegistro = new javax.swing.JTextField();
        inputBoxEstado = new javax.swing.JComboBox<>();
        btnRegistroAgregar = new javax.swing.JButton();
        btnRegistroEditar = new javax.swing.JButton();
        btnRegistroEliminar = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        registroTabla = new javax.swing.JTable();
        panelRegistroMedicamentos = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaRegistro = new javax.swing.JTable();
        btnAgregarRegistro = new javax.swing.JButton();
        btnEditarRegistro = new javax.swing.JButton();
        btnEliminarRegistro = new javax.swing.JButton();
        inputNombreRegist = new javax.swing.JTextField();
        inputMarcaRegist = new javax.swing.JTextField();
        inputFormaRegist = new javax.swing.JTextField();
        inputDosisRegist = new javax.swing.JTextField();
        inputDateRegist = new com.toedter.calendar.JDateChooser();
        inputLoteRegist = new javax.swing.JTextField();
        inputRegistroSani = new javax.swing.JTextField();
        inputCantidadRegist = new javax.swing.JTextField();
        panelCitasProgramadas = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        textNamePaciente = new javax.swing.JLabel();
        inputNombrePaciente = new javax.swing.JTextField();
        textApellidoPaciente = new javax.swing.JLabel();
        inputApellidoPaternoCita = new javax.swing.JTextField();
        textApellidoPaciente2 = new javax.swing.JLabel();
        inputApellidoMaternoCita = new javax.swing.JTextField();
        textEdadPaciente = new javax.swing.JLabel();
        inputCitaEdad = new javax.swing.JTextField();
        textTelefonoPaciente = new javax.swing.JLabel();
        inputTelefonoCita = new javax.swing.JTextField();
        textTelefonoPaciente1 = new javax.swing.JLabel();
        inputFechaCita = new com.toedter.calendar.JDateChooser();
        textTelefonoPaciente2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitaProgramada = new javax.swing.JTable();
        btnAgregarCitas = new javax.swing.JButton();
        btnEliminarCitas = new javax.swing.JButton();
        btnEditarCitas = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        inputHora = new javax.swing.JComboBox<>();
        panelDiagnosticos = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        textNombreDiag = new javax.swing.JLabel();
        dateDiag = new javax.swing.JLabel();
        textTipoDiag = new javax.swing.JLabel();
        textResultDiag = new javax.swing.JLabel();
        textMedicoEncDiag = new javax.swing.JLabel();
        textObsDiag = new javax.swing.JLabel();
        btnAgregarDiag = new javax.swing.JButton();
        btnEditarDiag = new javax.swing.JButton();
        btnEliminarDiag = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDiag = new javax.swing.JTable();
        inputNombreDiag = new javax.swing.JTextField();
        inputDateDiag = new com.toedter.calendar.JDateChooser();
        inputTipoDiag = new javax.swing.JComboBox<>();
        inputResultDiag = new javax.swing.JTextField();
        inputMedDiag = new javax.swing.JTextField();
        inputObsDiag = new javax.swing.JTextField();
        panelTratamientos = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        inputNombreCompletoTrat = new javax.swing.JTextField();
        inputNombreTrata = new javax.swing.JTextField();
        dateInicioTrat = new com.toedter.calendar.JDateChooser();
        dateFechaFinalTrata = new com.toedter.calendar.JDateChooser();
        inputDuracionTrata = new javax.swing.JTextField();
        inputDosisTrata = new javax.swing.JTextField();
        inputFrecuenciaTrata = new javax.swing.JComboBox<>();
        inputEstadoTrata = new javax.swing.JComboBox<>();
        inputMedicoTrata = new javax.swing.JTextField();
        inputObsTrata = new javax.swing.JTextField();
        btnAgregarTrata = new javax.swing.JButton();
        btnEliminarTrata = new javax.swing.JButton();
        btnEditarTrata = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaTratamiento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/md-del-usuario (1).png"))); // NOI18N

        textName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textName.setForeground(new java.awt.Color(255, 255, 255));
        textName.setText("Nombre medico");

        textHappyBirthday.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textHappyBirthday.setForeground(new java.awt.Color(255, 255, 255));
        textHappyBirthday.setText("Cumpleaños (Edad)");

        textEspecialidad.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textEspecialidad.setForeground(new java.awt.Color(255, 255, 255));
        textEspecialidad.setText("Especialidad");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/usuario.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/usuario-del-portapapeles.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/medicamento.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/calendario-corazon.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/lista-del-portapapeles.png"))); // NOI18N
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        btnCuentaUser.setBackground(new java.awt.Color(51, 153, 255));
        btnCuentaUser.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCuentaUser.setForeground(new java.awt.Color(255, 255, 255));
        btnCuentaUser.setText("Cuenta de Usuario");
        btnCuentaUser.setBorder(null);
        btnCuentaUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCuentaUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCuentaUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCuentaUserMouseExited(evt);
            }
        });
        btnCuentaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaUserActionPerformed(evt);
            }
        });

        btnRegistroPacientes.setBackground(new java.awt.Color(51, 153, 255));
        btnRegistroPacientes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnRegistroPacientes.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistroPacientes.setText("Registro Pacientes");
        btnRegistroPacientes.setBorder(null);
        btnRegistroPacientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistroPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistroPacientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistroPacientesMouseExited(evt);
            }
        });
        btnRegistroPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroPacientesActionPerformed(evt);
            }
        });

        btnRegistroMedicamentos.setBackground(new java.awt.Color(51, 153, 255));
        btnRegistroMedicamentos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnRegistroMedicamentos.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistroMedicamentos.setText("Registro Medicamentos");
        btnRegistroMedicamentos.setBorder(null);
        btnRegistroMedicamentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistroMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroMedicamentosActionPerformed(evt);
            }
        });

        btnCitasProgramadas.setBackground(new java.awt.Color(51, 153, 255));
        btnCitasProgramadas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCitasProgramadas.setForeground(new java.awt.Color(255, 255, 255));
        btnCitasProgramadas.setText("Citas Programadas");
        btnCitasProgramadas.setBorder(null);
        btnCitasProgramadas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCitasProgramadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasProgramadasActionPerformed(evt);
            }
        });

        btnRegistroDiagnosticos.setBackground(new java.awt.Color(51, 153, 255));
        btnRegistroDiagnosticos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnRegistroDiagnosticos.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistroDiagnosticos.setText("Registro Diagnósticos");
        btnRegistroDiagnosticos.setBorder(null);
        btnRegistroDiagnosticos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistroDiagnosticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroDiagnosticosActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/usuario-del-hospital.png"))); // NOI18N

        btnRegistroTratamientos.setBackground(new java.awt.Color(51, 153, 255));
        btnRegistroTratamientos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnRegistroTratamientos.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistroTratamientos.setText("Registro Tratamientos");
        btnRegistroTratamientos.setBorder(null);
        btnRegistroTratamientos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistroTratamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroTratamientosActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/dejar (1).png"))); // NOI18N

        btnClose.setBackground(new java.awt.Color(51, 153, 255));
        btnClose.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Cerrar Sesión");
        btnClose.setBorder(null);
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textName)
                            .addComponent(textHappyBirthday)
                            .addComponent(textEspecialidad))
                        .addGap(0, 43, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistroPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCuentaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnClose, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCitasProgramadas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistroTratamientos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistroDiagnosticos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistroMedicamentos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textHappyBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(textEspecialidad)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCuentaUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistroPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistroMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCitasProgramadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnRegistroDiagnosticos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnRegistroTratamientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 590));

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        panelCuentaUsuario.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Cuenta de Usuario");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Nombre Completo");

        inputNombre.setBackground(new java.awt.Color(255, 255, 255));
        inputNombre.setForeground(new java.awt.Color(204, 204, 204));
        inputNombre.setText("Ingresa tu nombre");
        inputNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        inputNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombreActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Apellido Completo");

        inputApellido.setBackground(new java.awt.Color(255, 255, 255));
        inputApellido.setText("Ingresa tu apellido");
        inputApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        inputApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputApellidoActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Fecha de Nacimiento");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Correo Electronico");

        inputEmail.setBackground(new java.awt.Color(255, 255, 255));
        inputEmail.setText("Ingresa tu correo electronico");
        inputEmail.setToolTipText("");
        inputEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        inputEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEmailActionPerformed(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Especialidad Médica");

        inputEspecialidad.setBackground(new java.awt.Color(255, 255, 255));
        inputEspecialidad.setText("Ingresa tu especialidad médica");
        inputEspecialidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        inputEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEspecialidadActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Telefono");

        inputTelefono.setBackground(new java.awt.Color(255, 255, 255));
        inputTelefono.setText("Ingresa tu número telefonico");
        inputTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        inputTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTelefonoActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 0));
        btnEditar.setText("Editar");
        btnEditar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        inputDate.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelCuentaUsuarioLayout = new javax.swing.GroupLayout(panelCuentaUsuario);
        panelCuentaUsuario.setLayout(panelCuentaUsuarioLayout);
        panelCuentaUsuarioLayout.setHorizontalGroup(
            panelCuentaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuentaUsuarioLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addGroup(panelCuentaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuentaUsuarioLayout.createSequentialGroup()
                        .addGroup(panelCuentaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(panelCuentaUsuarioLayout.createSequentialGroup()
                        .addGroup(panelCuentaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCuentaUsuarioLayout.createSequentialGroup()
                                .addGroup(panelCuentaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputEspecialidad)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel22)
                                    .addComponent(inputNombre)
                                    .addComponent(inputDate, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                                .addGap(87, 87, 87)
                                .addGroup(panelCuentaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel19)
                                    .addComponent(inputApellido)
                                    .addComponent(inputEmail))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelCuentaUsuarioLayout.setVerticalGroup(
            panelCuentaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCuentaUsuarioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(panelCuentaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCuentaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputApellido))
                .addGap(12, 12, 12)
                .addGroup(panelCuentaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCuentaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCuentaUsuarioLayout.createSequentialGroup()
                        .addComponent(inputDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCuentaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCuentaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        panelMenu.addTab("tab1", panelCuentaUsuario);

        panelRegistroPaciente.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Registro de Pacientes");

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Detalles del Paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Nombre Completo");
        jPanel6.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel40.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("Genero");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Edad");
        jPanel6.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Nacionalidad");
        jPanel6.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Telefono");
        jPanel6.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Correo Electronica");
        jPanel6.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Estado Civil");
        jPanel6.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel46.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("DNI/Pasaporte");
        jPanel6.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        inputRegistroNombre.setText("jTextField1");
        jPanel6.add(inputRegistroNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 390, -1));

        inputBoxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Otro" }));
        jPanel6.add(inputBoxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 390, -1));

        inputEdadRegistro.setText("jTextField2");
        jPanel6.add(inputEdadRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 390, -1));

        inputDNIRegistro.setText("jTextField3");
        jPanel6.add(inputDNIRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 390, -1));

        inputRegistroPais.setText("jTextField4");
        jPanel6.add(inputRegistroPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 390, -1));

        inputRegistroTele.setText("jTextField5");
        jPanel6.add(inputRegistroTele, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 390, -1));

        inputEmailRegistro.setText("jTextField6");
        jPanel6.add(inputEmailRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 390, -1));

        inputBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero(a)", "Casado(a)", "Divorciado(a)", "Viudo(a)" }));
        jPanel6.add(inputBoxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 390, -1));

        jScrollPane6.setViewportView(jPanel6);

        btnRegistroAgregar.setText("Agregar");
        btnRegistroAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroAgregarActionPerformed(evt);
            }
        });

        btnRegistroEditar.setText("Editar");
        btnRegistroEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroEditarActionPerformed(evt);
            }
        });

        btnRegistroEliminar.setText("Eliminar");
        btnRegistroEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroEliminarActionPerformed(evt);
            }
        });

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Registro de Pacientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        registroTabla.setBackground(new java.awt.Color(255, 255, 255));
        registroTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        registroTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registroTablaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(registroTabla);

        javax.swing.GroupLayout panelRegistroPacienteLayout = new javax.swing.GroupLayout(panelRegistroPaciente);
        panelRegistroPaciente.setLayout(panelRegistroPacienteLayout);
        panelRegistroPacienteLayout.setHorizontalGroup(
            panelRegistroPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroPacienteLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addGroup(panelRegistroPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelRegistroPacienteLayout.createSequentialGroup()
                        .addComponent(btnRegistroAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistroEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistroEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        panelRegistroPacienteLayout.setVerticalGroup(
            panelRegistroPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroPacienteLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistroAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistroEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistroEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMenu.addTab("tab2", panelRegistroPaciente);

        panelRegistroMedicamentos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Registro de Medicamentos");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre Científico");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Marca Comercial");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Forma Farmacéutica ");

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Dosis");

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Fecha Caducida");

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Lote de Fabricación");

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Número de Registro Sanitario");

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Cantidad Disponible");

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Registro de Medicamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablaRegistro.setBackground(new java.awt.Color(255, 255, 255));
        tablaRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRegistroMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaRegistro);

        btnAgregarRegistro.setText("Agregar");
        btnAgregarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRegistroActionPerformed(evt);
            }
        });

        btnEditarRegistro.setText("Editar");
        btnEditarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarRegistroActionPerformed(evt);
            }
        });

        btnEliminarRegistro.setText("Eliminar");
        btnEliminarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRegistroActionPerformed(evt);
            }
        });

        inputNombreRegist.setText("jTextField1");

        inputMarcaRegist.setText("jTextField1");

        inputFormaRegist.setText("jTextField1");

        inputDosisRegist.setText("jTextField1");

        inputLoteRegist.setText("jTextField1");

        inputRegistroSani.setText("jTextField1");

        inputCantidadRegist.setText("jTextField1");

        javax.swing.GroupLayout panelRegistroMedicamentosLayout = new javax.swing.GroupLayout(panelRegistroMedicamentos);
        panelRegistroMedicamentos.setLayout(panelRegistroMedicamentosLayout);
        panelRegistroMedicamentosLayout.setHorizontalGroup(
            panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroMedicamentosLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addGroup(panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroMedicamentosLayout.createSequentialGroup()
                        .addGroup(panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                            .addComponent(jSeparator10)
                            .addComponent(jScrollPane3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroMedicamentosLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputCantidadRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroMedicamentosLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputRegistroSani, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroMedicamentosLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputLoteRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroMedicamentosLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputFormaRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroMedicamentosLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputMarcaRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroMedicamentosLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputNombreRegist, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroMedicamentosLayout.createSequentialGroup()
                                .addGroup(panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputDosisRegist, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                    .addComponent(inputDateRegist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(panelRegistroMedicamentosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );
        panelRegistroMedicamentosLayout.setVerticalGroup(
            panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroMedicamentosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputNombreRegist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputMarcaRegist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputFormaRegist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(inputDosisRegist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(inputDateRegist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(inputLoteRegist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(inputRegistroSani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(inputCantidadRegist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRegistroMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditarRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRegistroMedicamentosLayout.createSequentialGroup()
                        .addComponent(btnAgregarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnEliminarRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMenu.addTab("tab3", panelRegistroMedicamentos);

        panelCitasProgramadas.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Citas médicas programadas");

        textNamePaciente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textNamePaciente.setForeground(new java.awt.Color(0, 0, 0));
        textNamePaciente.setText("Nombre del Paciente:");

        inputNombrePaciente.setText("jTextField1");

        textApellidoPaciente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textApellidoPaciente.setForeground(new java.awt.Color(0, 0, 0));
        textApellidoPaciente.setText("Apellido Paterno:");

        inputApellidoPaternoCita.setText("jTextField1");

        textApellidoPaciente2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textApellidoPaciente2.setForeground(new java.awt.Color(0, 0, 0));
        textApellidoPaciente2.setText("Apellido Materno:");

        inputApellidoMaternoCita.setText("jTextField1");

        textEdadPaciente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textEdadPaciente.setForeground(new java.awt.Color(0, 0, 0));
        textEdadPaciente.setText("Edad del Paciente:");

        inputCitaEdad.setText("jTextField1");

        textTelefonoPaciente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textTelefonoPaciente.setForeground(new java.awt.Color(0, 0, 0));
        textTelefonoPaciente.setText("Télefono del Paciente:");

        inputTelefonoCita.setText("jTextField1");

        textTelefonoPaciente1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textTelefonoPaciente1.setForeground(new java.awt.Color(0, 0, 0));
        textTelefonoPaciente1.setText("Fecha:");

        textTelefonoPaciente2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textTelefonoPaciente2.setForeground(new java.awt.Color(0, 0, 0));
        textTelefonoPaciente2.setText("Hora:");

        jScrollPane1.setBackground(new java.awt.Color(240, 240, 240));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Citas Programadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablaCitaProgramada.setBackground(new java.awt.Color(255, 255, 255));
        tablaCitaProgramada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaCitaProgramada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCitaProgramadaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCitaProgramada);

        btnAgregarCitas.setText("Agregar");
        btnAgregarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCitasActionPerformed(evt);
            }
        });

        btnEliminarCitas.setText("Eliminar");
        btnEliminarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCitasActionPerformed(evt);
            }
        });

        btnEditarCitas.setText("Editar");
        btnEditarCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarCitasMouseClicked(evt);
            }
        });
        btnEditarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCitasActionPerformed(evt);
            }
        });

        inputHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0:00", "1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));

        javax.swing.GroupLayout panelCitasProgramadasLayout = new javax.swing.GroupLayout(panelCitasProgramadas);
        panelCitasProgramadas.setLayout(panelCitasProgramadasLayout);
        panelCitasProgramadasLayout.setHorizontalGroup(
            panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCitasProgramadasLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addGroup(panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCitasProgramadasLayout.createSequentialGroup()
                        .addGroup(panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNamePaciente)
                            .addComponent(textApellidoPaciente)
                            .addComponent(textApellidoPaciente2)
                            .addComponent(textEdadPaciente)
                            .addComponent(textTelefonoPaciente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(inputTelefonoCita, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                                .addComponent(inputCitaEdad)
                                .addComponent(inputApellidoMaternoCita)
                                .addComponent(inputApellidoPaternoCita))
                            .addComponent(inputNombrePaciente))
                        .addGap(28, 28, 28))
                    .addComponent(jSeparator8)
                    .addComponent(jScrollPane1)
                    .addGroup(panelCitasProgramadasLayout.createSequentialGroup()
                        .addComponent(textTelefonoPaciente1)
                        .addGap(18, 18, 18)
                        .addComponent(inputFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textTelefonoPaciente2)
                        .addGap(18, 18, 18)
                        .addComponent(inputHora, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnAgregarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelCitasProgramadasLayout.setVerticalGroup(
            panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCitasProgramadasLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCitasProgramadasLayout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textNamePaciente)
                            .addComponent(inputNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textApellidoPaciente)
                            .addComponent(inputApellidoPaternoCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textApellidoPaciente2)
                            .addComponent(inputApellidoMaternoCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textEdadPaciente)
                            .addComponent(inputCitaEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textTelefonoPaciente)
                            .addComponent(inputTelefonoCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textTelefonoPaciente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textTelefonoPaciente2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelCitasProgramadasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelCitasProgramadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMenu.addTab("tab4", panelCitasProgramadas);

        panelDiagnosticos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Registro de Diagnósticos");

        textNombreDiag.setBackground(new java.awt.Color(0, 0, 0));
        textNombreDiag.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textNombreDiag.setForeground(new java.awt.Color(0, 0, 0));
        textNombreDiag.setText("Nombre Completo");

        dateDiag.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dateDiag.setForeground(new java.awt.Color(0, 0, 0));
        dateDiag.setText("Fecha");

        textTipoDiag.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textTipoDiag.setForeground(new java.awt.Color(0, 0, 0));
        textTipoDiag.setText("Tipo de Diagnóstico");

        textResultDiag.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textResultDiag.setForeground(new java.awt.Color(0, 0, 0));
        textResultDiag.setText("Resultado del Diagnóstico");

        textMedicoEncDiag.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textMedicoEncDiag.setForeground(new java.awt.Color(0, 0, 0));
        textMedicoEncDiag.setText("Médico Encargado");

        textObsDiag.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textObsDiag.setForeground(new java.awt.Color(0, 0, 0));
        textObsDiag.setText("Observación");

        btnAgregarDiag.setText("Agregar");
        btnAgregarDiag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDiagActionPerformed(evt);
            }
        });

        btnEditarDiag.setText("Editar");
        btnEditarDiag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDiagActionPerformed(evt);
            }
        });

        btnEliminarDiag.setText("Eliminar");
        btnEliminarDiag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDiagActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Registro de Diagnósticos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablaDiag.setBackground(new java.awt.Color(255, 255, 255));
        tablaDiag.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaDiag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDiagMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaDiag);

        inputNombreDiag.setText("jTextField1");

        inputTipoDiag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diagnóstico Clínico", "Diagnóstico por Imagen", "Diagnóstico de Laboratorio", "Diagnóstico Histopatológico", "Diagnóstico Molecular", "Diagnóstico Funcional", "Diagnóstico Diferencial" }));

        inputResultDiag.setText("jTextField2");

        inputMedDiag.setText("jTextField3");

        inputObsDiag.setText("jTextField4");

        javax.swing.GroupLayout panelDiagnosticosLayout = new javax.swing.GroupLayout(panelDiagnosticos);
        panelDiagnosticos.setLayout(panelDiagnosticosLayout);
        panelDiagnosticosLayout.setHorizontalGroup(
            panelDiagnosticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDiagnosticosLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addGroup(panelDiagnosticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDiagnosticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelDiagnosticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17)
                            .addComponent(jSeparator7)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDiagnosticosLayout.createSequentialGroup()
                                .addGroup(panelDiagnosticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNombreDiag)
                                    .addComponent(dateDiag)
                                    .addComponent(textTipoDiag)
                                    .addComponent(textResultDiag)
                                    .addComponent(textMedicoEncDiag)
                                    .addComponent(textObsDiag))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelDiagnosticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputDateDiag, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                    .addComponent(inputNombreDiag)
                                    .addComponent(inputTipoDiag, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputResultDiag)
                                    .addComponent(inputMedDiag)
                                    .addComponent(inputObsDiag))
                                .addGap(124, 124, 124))
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDiagnosticosLayout.createSequentialGroup()
                        .addComponent(btnAgregarDiag, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarDiag, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarDiag, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelDiagnosticosLayout.setVerticalGroup(
            panelDiagnosticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDiagnosticosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDiagnosticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNombreDiag)
                    .addComponent(inputNombreDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDiagnosticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateDiag)
                    .addComponent(inputDateDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDiagnosticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textTipoDiag)
                    .addComponent(inputTipoDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDiagnosticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textResultDiag)
                    .addComponent(inputResultDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDiagnosticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textMedicoEncDiag)
                    .addComponent(inputMedDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDiagnosticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textObsDiag)
                    .addComponent(inputObsDiag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDiagnosticosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarDiag, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarDiag, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarDiag, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMenu.addTab("tab5", panelDiagnosticos);

        panelTratamientos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Registro de Tratamientos");

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Solicitamiento de Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Nombre Completo");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Nombre del Tratamiento");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Fecha inicio");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Fecha final");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Duración");
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel34.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Dosis");
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel35.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Frecuencia");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Estado del Tratamiento");
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel37.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Médico Encargado");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel38.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Observaciones");
        jPanel5.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        inputNombreCompletoTrat.setText("jTextField1");
        jPanel5.add(inputNombreCompletoTrat, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 370, -1));

        inputNombreTrata.setText("jTextField1");
        jPanel5.add(inputNombreTrata, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 370, -1));
        jPanel5.add(dateInicioTrat, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 370, -1));
        jPanel5.add(dateFechaFinalTrata, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 370, -1));

        inputDuracionTrata.setText("jTextField1");
        jPanel5.add(inputDuracionTrata, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 370, -1));

        inputDosisTrata.setText("jTextField1");
        jPanel5.add(inputDosisTrata, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 370, -1));

        inputFrecuenciaTrata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diario", "Semanal", "Mensual" }));
        jPanel5.add(inputFrecuenciaTrata, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 370, -1));

        inputEstadoTrata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Incompleto", "Completado", "En Curso", "Cancelado" }));
        jPanel5.add(inputEstadoTrata, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 370, -1));

        inputMedicoTrata.setText("jTextField1");
        jPanel5.add(inputMedicoTrata, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 370, -1));

        inputObsTrata.setText("jTextField2");
        jPanel5.add(inputObsTrata, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 370, -1));

        jScrollPane4.setViewportView(jPanel5);

        btnAgregarTrata.setText("Agregar");
        btnAgregarTrata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTrataActionPerformed(evt);
            }
        });

        btnEliminarTrata.setText("Eliminar");
        btnEliminarTrata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTrataActionPerformed(evt);
            }
        });

        btnEditarTrata.setText("Editar");
        btnEditarTrata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTrataActionPerformed(evt);
            }
        });

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Registro de Tratamientos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablaTratamiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaTratamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTratamientoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaTratamiento);

        javax.swing.GroupLayout panelTratamientosLayout = new javax.swing.GroupLayout(panelTratamientos);
        panelTratamientos.setLayout(panelTratamientosLayout);
        panelTratamientosLayout.setHorizontalGroup(
            panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTratamientosLayout.createSequentialGroup()
                .addContainerGap(540, Short.MAX_VALUE)
                .addComponent(btnAgregarTrata, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarTrata, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarTrata, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addGroup(panelTratamientosLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addGroup(panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane5))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelTratamientosLayout.setVerticalGroup(
            panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTratamientosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarTrata, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAgregarTrata, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditarTrata, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMenu.addTab("tab7", panelTratamientos);

        jPanel1.add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -10, 970, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCuentaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentaUserActionPerformed
        // Selecciona el índice 0 en el panel `panelTable` y muestra el panel 
        panelMenu.setSelectedIndex(0);
    }//GEN-LAST:event_btnCuentaUserActionPerformed

    private void btnRegistroPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroPacientesActionPerformed
        // Selecciona el índice 1 en el panel `panelTable` y muestra el panel
        panelMenu.setSelectedIndex(1);
    }//GEN-LAST:event_btnRegistroPacientesActionPerformed

    private void btnCuentaUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuentaUserMouseEntered
        if (btnCuentaUser.getFont() == null) {
            btnCuentaUser.setFont(new Font("Arial", Font.PLAIN, 12));
        }

        btnCuentaUser.setFont(boldFont);
    }//GEN-LAST:event_btnCuentaUserMouseEntered

    private void btnCuentaUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCuentaUserMouseExited
        if (originalFont == null) {
            originalFont = new Font("Arial", Font.PLAIN, 12);
        }

        btnCuentaUser.setFont(originalFont);
    }//GEN-LAST:event_btnCuentaUserMouseExited

    private void btnRegistroDiagnosticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroDiagnosticosActionPerformed
        // Selecciona el índice 4 en el panel `panelTable` y muestra el panel
        panelMenu.setSelectedIndex(4);
    }//GEN-LAST:event_btnRegistroDiagnosticosActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // Define el mensaje a mostrar en el cuadro de diálogo de confirmación
        String mensaje = "¿Seguro que quieres salir?\nTendrás que iniciar sesión nuevamente para continuar.";

        // Muestra un cuadro de diálogo de confirmación con opciones "Sí" y "No"
        int seleccion = JOptionPane.showOptionDialog(
                this,
                mensaje,
                "Confirmar cierre del programa",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                new Object[]{"Sí", "No"}, // Opciones mostradas al usuario
                "No" // Opción predeterminada seleccionada
        );

        // Verifica si el usuario seleccionó "Sí" en el cuadro de diálogo de confirmación
        if (seleccion == JOptionPane.YES_OPTION) {
            // Muestra un mensaje de despedida
            JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa, ¡vuelve pronto!");

            // Abre la ventana de inicio de sesión y cierra la ventana actual
            Login loginFrame = new Login(userDatabase);
            loginFrame.setVisible(true);
            loginFrame.setLocationRelativeTo(null);
            this.dispose(); // Cierra la ventana actual
        }

    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        if (btnClose.getFont() == null) {
            btnClose.setFont(new Font("Arial", Font.PLAIN, 12));
        }

        btnClose.setFont(boldFont);    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        if (originalFont == null) {
            originalFont = new Font("Arial", Font.PLAIN, 12);
        }

        btnClose.setFont(originalFont);    }//GEN-LAST:event_btnCloseMouseExited

    private void btnRegistroMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroMedicamentosActionPerformed
        // Selecciona el índice 2 en el panel `panelTable` y muestra el panel
        panelMenu.setSelectedIndex(2);
    }//GEN-LAST:event_btnRegistroMedicamentosActionPerformed

    private void btnCitasProgramadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasProgramadasActionPerformed
        // Selecciona el índice 3 en el panel `panelTable` y muestra el panel
        panelMenu.setSelectedIndex(3);
    }//GEN-LAST:event_btnCitasProgramadasActionPerformed

    private void btnRegistroTratamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroTratamientosActionPerformed
        // Selecciona el índice 5 en el panel `panelTable` y muestra el panel
        panelMenu.setSelectedIndex(5);
    }//GEN-LAST:event_btnRegistroTratamientosActionPerformed

    private void btnRegistroPacientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroPacientesMouseEntered
        if (btnRegistroPacientes.getFont() == null) {
            btnRegistroPacientes.setFont(new Font("Arial", Font.PLAIN, 12));
        }

        btnRegistroPacientes.setFont(boldFont);
    }//GEN-LAST:event_btnRegistroPacientesMouseEntered

    private void btnRegistroPacientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroPacientesMouseExited
        if (originalFont == null) {
            originalFont = new Font("Arial", Font.PLAIN, 12);
        }

        btnRegistroPacientes.setFont(originalFont);
    }//GEN-LAST:event_btnRegistroPacientesMouseExited

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (!isEditar) {

            habilitarCampos(true);
            btnEditar.setText("Guardar");
            cambiarColorFuenteCampos(Color.BLACK); // Cambia a color negro para editar

        } else {
            // Modo Guardar
            almacenarInformacion();
            habilitarCampos(false);
            btnEditar.setText("Editar");
            cambiarColorFuenteCampos(Color.GRAY); // Cambia a color gris para guardar
        }
        isEditar = !isEditar;
    }//GEN-LAST:event_btnEditarActionPerformed

    private void inputNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombreActionPerformed

    }//GEN-LAST:event_inputNombreActionPerformed

    private void inputApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputApellidoActionPerformed

    private void inputEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEmailActionPerformed

    private void inputEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEspecialidadActionPerformed

    private void inputTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTelefonoActionPerformed

    private void btnAgregarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCitasActionPerformed
        if (camposEstanLlenosCita()) {
            CitaPersona nuevoPaciente = obtenerDatosCita();
            tablaPanel4.addRow(nuevoPaciente.toArray());
            inicializarCamposVaciosTabla4();
            JOptionPane.showMessageDialog(null, "Cita registrada correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarCitasActionPerformed

    private void btnEditarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCitasActionPerformed
        if (tablaCitaProgramada.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (camposEstanLlenosCita()) {
            int fila = tablaCitaProgramada.getSelectedRow();
            CitaPersona nuevoPaciente = obtenerDatosCita();
            tablaPanel4.setValueAt(nuevoPaciente.getNombre(), fila, 0);
            tablaPanel4.setValueAt(nuevoPaciente.getApellidoPaterno(), fila, 1);
            tablaPanel4.setValueAt(nuevoPaciente.getApellidoMaterno(), fila, 2);
            tablaPanel4.setValueAt(nuevoPaciente.getEdadPaciente(), fila, 3);
            tablaPanel4.setValueAt(nuevoPaciente.getTelefonoPaciente(), fila, 4);
            tablaPanel4.setValueAt(nuevoPaciente.getFecha(), fila, 5);
            tablaPanel4.setValueAt(nuevoPaciente.getHora(), fila, 6);

            inicializarCamposVaciosTabla4();
            JOptionPane.showMessageDialog(null, "Cita editada correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarCitasActionPerformed

    private void btnEditarCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarCitasMouseClicked

    }//GEN-LAST:event_btnEditarCitasMouseClicked

    private void tablaCitaProgramadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCitaProgramadaMouseClicked
        if (evt.getClickCount() == 2) { // Verifica si es un doble clic
            int fila = tablaCitaProgramada.getSelectedRow(); // Obtén la fila seleccionada

            if (fila != -1) { // Verifica que se haya seleccionado una fila válida
                String nombreCita = (String) tablaPanel4.getValueAt(fila, 0);
                String apellidoPaternoCita = (String) tablaPanel4.getValueAt(fila, 1);
                String apellidoMaternoCita = (String) tablaPanel4.getValueAt(fila, 2);
                String edadPacienteCita = (String) tablaPanel4.getValueAt(fila, 3);
                String telefonoCita = (String) tablaPanel4.getValueAt(fila, 4);
                String fechaCitaStr = (String) tablaPanel4.getValueAt(fila, 5);
                String horaCita = (String) tablaPanel4.getValueAt(fila, 6);

                // Convierte la cadena de fecha a un objeto Date usando SimpleDateFormat
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaCitaPaciente = null;
                try {
                    fechaCitaPaciente = sdf.parse(fechaCitaStr);
                } catch (ParseException e) {
                    e.printStackTrace(); // Maneja la excepción apropiadamente
                }

                // Asigna los valores a los campos de entrada correspondientes
                inputNombrePaciente.setText(nombreCita);
                inputApellidoPaternoCita.setText(apellidoPaternoCita);
                inputApellidoMaternoCita.setText(apellidoMaternoCita);
                inputCitaEdad.setText(edadPacienteCita);
                inputTelefonoCita.setText(telefonoCita);
                inputFechaCita.setDate(fechaCitaPaciente); // Asegúrate de manejar posibles valores nulos
                inputHora.setSelectedItem(horaCita);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para editar.");
            }
        }
    }//GEN-LAST:event_tablaCitaProgramadaMouseClicked

    private void btnEliminarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCitasActionPerformed
        if (tablaCitaProgramada.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int fila = tablaCitaProgramada.getSelectedRow();
        tablaPanel4.removeRow(fila);
        JOptionPane.showMessageDialog(null, "Cita eliminada correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnEliminarCitasActionPerformed

    private void btnAgregarDiagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDiagActionPerformed
        if (camposEstanLlenosDiag()) {
            DiagnosticoPersona nuevoDiagnostico = obtenerDatosDiag();
            tablaPanel5.addRow(nuevoDiagnostico.toArray());
            inicializarCamposVaciosTabla5();
            JOptionPane.showMessageDialog(null, "Diagnóstico registrado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarDiagActionPerformed

    private void btnEditarDiagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDiagActionPerformed
        if (tablaDiag.getSelectedRow() != 1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (camposEstanLlenosDiag()) {
            int fila = tablaDiag.getSelectedRow();
            DiagnosticoPersona nuevoDiagnostico = obtenerDatosDiag();
            tablaPanel5.setValueAt(nuevoDiagnostico.getNombre(), fila, 0);
            tablaPanel5.setValueAt(nuevoDiagnostico.getFecha(), fila, 1);
            tablaPanel5.setValueAt(nuevoDiagnostico.getTipoDiag(), fila, 2);
            tablaPanel5.setValueAt(nuevoDiagnostico.getResultadoDiag(), fila, 3);
            tablaPanel5.setValueAt(nuevoDiagnostico.getMedicoEnc(), fila, 4);
            tablaPanel5.setValueAt(nuevoDiagnostico.getObsDiag(), fila, 5);

            inicializarCamposVaciosTabla5();
            JOptionPane.showMessageDialog(null, "Diagnóstico editado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarDiagActionPerformed

    private void tablaDiagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDiagMouseClicked
        if (evt.getClickCount() == 2) {
            int fila = tablaDiag.getSelectedRow();

            if (fila != -1) {
                String nombre = (String) tablaPanel5.getValueAt(fila, 0);
                String fecha = (String) tablaPanel5.getValueAt(fila, 1);
                String tipoDiag = (String) tablaPanel5.getValueAt(fila, 2);
                String resultDiag = (String) tablaPanel5.getValueAt(fila, 3);
                String medicoEnc = (String) tablaPanel5.getValueAt(fila, 4);
                String obsDiag = (String) tablaPanel5.getValueAt(fila, 5);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaDiag = null;

                try {
                    fechaDiag = sdf.parse(fecha);
                } catch (ParseException e) {
                    e.printStackTrace(); // Maneja la excepción apropiadamente
                }

                inputNombreDiag.setText(nombre);
                inputDateDiag.setDate(fechaDiag);
                inputTipoDiag.setSelectedItem(tipoDiag);
                inputResultDiag.setText(resultDiag);
                inputMedDiag.setText(medicoEnc);
                inputObsDiag.setText(obsDiag);

            }
        }
    }//GEN-LAST:event_tablaDiagMouseClicked

    private void btnEliminarDiagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDiagActionPerformed
        if (tablaDiag.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int fila = tablaDiag.getSelectedRow();
        tablaPanel5.removeRow(fila);
        JOptionPane.showMessageDialog(null, "Diagnóstico eliminado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnEliminarDiagActionPerformed

    private void btnAgregarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRegistroActionPerformed
        if (camposEstanLlenosReg()) {
            RegistroMedicamento registroMedicamento = obtenerDatosReg();
            tablaPanel6.addRow(registroMedicamento.toArray());
            inicializarCamposVaciosTabla6();
            JOptionPane.showMessageDialog(null, "Registro de medicamento agregado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarRegistroActionPerformed

    private void btnEditarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarRegistroActionPerformed
        if (tablaRegistro.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (camposEstanLlenosReg()) {
            int fila = tablaRegistro.getSelectedRow();
            RegistroMedicamento registroMedicamento = obtenerDatosReg();

            tablaPanel6.setValueAt(registroMedicamento.getNombreCientifico(), fila, 0);
            tablaPanel6.setValueAt(registroMedicamento.getMarcaComercial(), fila, 1);
            tablaPanel6.setValueAt(registroMedicamento.getFormaFarmaceutica(), fila, 2);
            tablaPanel6.setValueAt(registroMedicamento.getDosis(), fila, 3);
            tablaPanel6.setValueAt(registroMedicamento.getFechaCaducada(), fila, 4);
            tablaPanel6.setValueAt(registroMedicamento.getLoteFabricada(), fila, 5);
            tablaPanel6.setValueAt(registroMedicamento.getNumeroRegistros(), fila, 6);
            tablaPanel6.setValueAt(registroMedicamento.getCantidadDisponible(), fila, 7);

            JOptionPane.showMessageDialog(null, "Registro de medicamento editado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarRegistroActionPerformed

    private void tablaRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRegistroMouseClicked
        if (evt.getClickCount() == 2) {
            int fila = tablaRegistro.getSelectedRow();

            if (fila != -1) {
                String nombreCientifico = (String) tablaPanel6.getValueAt(fila, 0);
                String marcaComercial = (String) tablaPanel6.getValueAt(fila, 1);
                String formaFarmaceutica = (String) tablaPanel6.getValueAt(fila, 2);
                String dosisRegistro = (String) tablaPanel6.getValueAt(fila, 3);
                String fechaCaducada = (String) tablaPanel6.getValueAt(fila, 4);
                String loteFabricada = (String) tablaPanel6.getValueAt(fila, 5);
                String numeroRegistro = (String) tablaPanel6.getValueAt(fila, 6);
                String cantidadDisponible = (String) tablaPanel6.getValueAt(fila, 7);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaRegistro = null;

                try {
                    fechaRegistro = sdf.parse(fechaCaducada);
                } catch (ParseException e) {
                    e.printStackTrace(); // Maneja la excepción apropiadamente
                }

                inputNombreRegist.setText(nombreCientifico);
                inputMarcaRegist.setText(marcaComercial);
                inputFormaRegist.setText(formaFarmaceutica);
                inputDosisRegist.setText(dosisRegistro);
                inputDateRegist.setDate(fechaRegistro);
                inputLoteRegist.setText(loteFabricada);
                inputRegistroSani.setText(numeroRegistro);
                inputCantidadRegist.setText(cantidadDisponible);
            }

        }
    }//GEN-LAST:event_tablaRegistroMouseClicked

    private void btnEliminarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRegistroActionPerformed
        if (tablaRegistro.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int fila = tablaRegistro.getSelectedRow();
        tablaPanel6.removeRow(fila);
        JOptionPane.showMessageDialog(null, "Registro de medicamento eliminado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnEliminarRegistroActionPerformed

    private void btnAgregarTrataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTrataActionPerformed
        if (camposEstanLlenosTratamiento()) {
            TratamientoPersona tratamientoPersona = obtenerDatosTratamiento();
            tablaPanel3.addRow(tratamientoPersona.toArray());
            inicializarCamposVaciosTabla3();
            JOptionPane.showMessageDialog(null, "Tratamiento registrado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarTrataActionPerformed

    private void btnEditarTrataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTrataActionPerformed
        if (tablaTratamiento.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (camposEstanLlenosTratamiento()) {
            int fila = tablaTratamiento.getSelectedRow();
            TratamientoPersona tratamientoPersona = obtenerDatosTratamiento();

            tablaPanel3.setValueAt(tratamientoPersona.getNombreCompleto(), fila, 0);
            tablaPanel3.setValueAt(tratamientoPersona.getNombreTratamiento(), fila, 1);
            tablaPanel3.setValueAt(tratamientoPersona.getFechaInicial(), fila, 2);
            tablaPanel3.setValueAt(tratamientoPersona.getFechaFinal(), fila, 3);
            tablaPanel3.setValueAt(tratamientoPersona.getDuracion(), fila, 4);
            tablaPanel3.setValueAt(tratamientoPersona.getDosis(), fila, 5);
            tablaPanel3.setValueAt(tratamientoPersona.getFrecuencia(), fila, 6);
            tablaPanel3.setValueAt(tratamientoPersona.getEstadoTratamiento(), fila, 7);
            tablaPanel3.setValueAt(tratamientoPersona.getMedicoEncargado(), fila, 8);
            tablaPanel3.setValueAt(tratamientoPersona.getObservacion(), fila, 9);

            inicializarCamposVaciosTabla3();
            JOptionPane.showMessageDialog(null, "Tratamiento editado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarTrataActionPerformed

    private void tablaTratamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTratamientoMouseClicked
        if (evt.getClickCount() == 2) {
            int fila = tablaTratamiento.getSelectedRow();

            if (fila != -1) {
                String nombreCompleto = (String) tablaPanel3.getValueAt(fila, 0);
                String nombreTratamiento = (String) tablaPanel3.getValueAt(fila, 1);
                String fechaInicial = (String) tablaPanel3.getValueAt(fila, 2);
                String fechaFinal = (String) tablaPanel3.getValueAt(fila, 3);
                String duracion = (String) tablaPanel3.getValueAt(fila, 4);
                String dosis = (String) tablaPanel3.getValueAt(fila, 5);
                String frecuencia = (String) tablaPanel3.getValueAt(fila, 6);
                String estadoTratamiento = (String) tablaPanel3.getValueAt(fila, 7);
                String medicoEncargado = (String) tablaPanel3.getValueAt(fila, 8);
                String observacion = (String) tablaPanel3.getValueAt(fila, 9);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaInicioTrata = null;
                Date fechaFinalTrata = null;

                try {
                    fechaInicioTrata = sdf.parse(fechaInicial);
                    fechaFinalTrata = sdf.parse(fechaFinal);
                } catch (ParseException e) {
                    e.printStackTrace(); // Maneja la excepción apropiadamente
                }

                inputNombreCompletoTrat.setText(nombreCompleto);
                inputNombreTrata.setText(nombreTratamiento);
                dateInicioTrat.setDate(fechaInicioTrata);
                dateFechaFinalTrata.setDate(fechaFinalTrata);
                inputDuracionTrata.setText(duracion);
                inputDosisTrata.setText(dosis);
                inputFrecuenciaTrata.setSelectedItem(frecuencia);
                inputEstadoTrata.setSelectedItem(estadoTratamiento);
                inputMedicoTrata.setText(medicoEncargado);
                inputObsTrata.setText(observacion);
            }

        }
    }//GEN-LAST:event_tablaTratamientoMouseClicked

    private void btnEliminarTrataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTrataActionPerformed
        if (tablaTratamiento.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int fila = tablaTratamiento.getSelectedRow();
        tablaPanel3.removeRow(fila);
        JOptionPane.showMessageDialog(null, "Tratamiento eliminado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnEliminarTrataActionPerformed

    private void btnRegistroAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroAgregarActionPerformed
        if (camposEstanLlenosRegistro()) {
            RegistroPersona registroPersona = obtenerPersonaRegistro();
            tablaPanel2.addRow(registroPersona.toArray());
            inicializarCamposVaciosTabla2();
            JOptionPane.showMessageDialog(null, "Registro de persona agregado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistroAgregarActionPerformed

    private void btnRegistroEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroEditarActionPerformed
        if (registroTabla.getSelectedRow() != 1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (camposEstanLlenosRegistro()) {
            int fila = registroTabla.getSelectedRow();
            RegistroPersona registroPersona = obtenerPersonaRegistro();

            tablaPanel2.setValueAt(registroPersona.getNombreCompleto(), fila, 0);
            tablaPanel2.setValueAt(registroPersona.getGenero(), fila, 1);
            tablaPanel2.setValueAt(registroPersona.getEdad(), fila, 2);
            tablaPanel2.setValueAt(registroPersona.getDni(), fila, 3);
            tablaPanel2.setValueAt(registroPersona.getNacionalidad(), fila, 4);
            tablaPanel2.setValueAt(registroPersona.getTelefono(), fila, 5);
            tablaPanel2.setValueAt(registroPersona.getEmail(), fila, 6);
            tablaPanel2.setValueAt(registroPersona.getEstadoCivil(), fila, 7);

            JOptionPane.showMessageDialog(null, "Registro de persona editado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistroEditarActionPerformed

    private void registroTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registroTablaMouseClicked
        if (evt.getClickCount() == 2) {
            int fila = registroTabla.getSelectedRow();

            if (fila != -1) {
                String nombreCompleto = (String) tablaPanel2.getValueAt(fila, 0);
                String genero = (String) tablaPanel2.getValueAt(fila, 1);
                String edad = (String) tablaPanel2.getValueAt(fila, 2);
                String dni = (String) tablaPanel2.getValueAt(fila, 3);
                String nacionalidad = (String) tablaPanel2.getValueAt(fila, 4);
                String telefono = (String) tablaPanel2.getValueAt(fila, 5);
                String email = (String) tablaPanel2.getValueAt(fila, 6);
                String estadoCivil = (String) tablaPanel2.getValueAt(fila, 7);

                inputRegistroNombre.setText(nombreCompleto);
                inputBoxGenero.setSelectedItem(genero);
                inputEdadRegistro.setText(edad);
                inputDNIRegistro.setText(dni);
                inputRegistroPais.setText(nacionalidad);
                inputRegistroTele.setText(telefono);
                inputEmailRegistro.setText(email);
                inputBoxEstado.setSelectedItem(estadoCivil);

            }

        }
    }//GEN-LAST:event_registroTablaMouseClicked

    private void btnRegistroEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroEliminarActionPerformed
        if (registroTabla.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int fila = registroTabla.getSelectedRow();
        tablaPanel2.removeRow(fila);
        JOptionPane.showMessageDialog(null, "Registro de persona eliminado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRegistroEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCitas;
    private javax.swing.JButton btnAgregarDiag;
    private javax.swing.JButton btnAgregarRegistro;
    private javax.swing.JButton btnAgregarTrata;
    private javax.swing.JButton btnCitasProgramadas;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCuentaUser;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditarCitas;
    private javax.swing.JButton btnEditarDiag;
    private javax.swing.JButton btnEditarRegistro;
    private javax.swing.JButton btnEditarTrata;
    private javax.swing.JButton btnEliminarCitas;
    private javax.swing.JButton btnEliminarDiag;
    private javax.swing.JButton btnEliminarRegistro;
    private javax.swing.JButton btnEliminarTrata;
    private javax.swing.JButton btnRegistroAgregar;
    private javax.swing.JButton btnRegistroDiagnosticos;
    private javax.swing.JButton btnRegistroEditar;
    private javax.swing.JButton btnRegistroEliminar;
    private javax.swing.JButton btnRegistroMedicamentos;
    private javax.swing.JButton btnRegistroPacientes;
    private javax.swing.JButton btnRegistroTratamientos;
    private javax.swing.JLabel dateDiag;
    private com.toedter.calendar.JDateChooser dateFechaFinalTrata;
    private com.toedter.calendar.JDateChooser dateInicioTrat;
    private javax.swing.JTextField inputApellido;
    private javax.swing.JTextField inputApellidoMaternoCita;
    private javax.swing.JTextField inputApellidoPaternoCita;
    private javax.swing.JComboBox<String> inputBoxEstado;
    private javax.swing.JComboBox<String> inputBoxGenero;
    private javax.swing.JTextField inputCantidadRegist;
    private javax.swing.JTextField inputCitaEdad;
    private javax.swing.JTextField inputDNIRegistro;
    private com.toedter.calendar.JDateChooser inputDate;
    private com.toedter.calendar.JDateChooser inputDateDiag;
    private com.toedter.calendar.JDateChooser inputDateRegist;
    private javax.swing.JTextField inputDosisRegist;
    private javax.swing.JTextField inputDosisTrata;
    private javax.swing.JTextField inputDuracionTrata;
    private javax.swing.JTextField inputEdadRegistro;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JTextField inputEmailRegistro;
    private javax.swing.JTextField inputEspecialidad;
    private javax.swing.JComboBox<String> inputEstadoTrata;
    private com.toedter.calendar.JDateChooser inputFechaCita;
    private javax.swing.JTextField inputFormaRegist;
    private javax.swing.JComboBox<String> inputFrecuenciaTrata;
    private javax.swing.JComboBox<String> inputHora;
    private javax.swing.JTextField inputLoteRegist;
    private javax.swing.JTextField inputMarcaRegist;
    private javax.swing.JTextField inputMedDiag;
    private javax.swing.JTextField inputMedicoTrata;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTextField inputNombreCompletoTrat;
    private javax.swing.JTextField inputNombreDiag;
    private javax.swing.JTextField inputNombrePaciente;
    private javax.swing.JTextField inputNombreRegist;
    private javax.swing.JTextField inputNombreTrata;
    private javax.swing.JTextField inputObsDiag;
    private javax.swing.JTextField inputObsTrata;
    private javax.swing.JTextField inputRegistroNombre;
    private javax.swing.JTextField inputRegistroPais;
    private javax.swing.JTextField inputRegistroSani;
    private javax.swing.JTextField inputRegistroTele;
    private javax.swing.JTextField inputResultDiag;
    private javax.swing.JTextField inputTelefono;
    private javax.swing.JTextField inputTelefonoCita;
    private javax.swing.JComboBox<String> inputTipoDiag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel panelCitasProgramadas;
    private javax.swing.JPanel panelCuentaUsuario;
    private javax.swing.JPanel panelDiagnosticos;
    private javax.swing.JTabbedPane panelMenu;
    private javax.swing.JPanel panelRegistroMedicamentos;
    private javax.swing.JPanel panelRegistroPaciente;
    private javax.swing.JPanel panelTratamientos;
    private javax.swing.JTable registroTabla;
    private javax.swing.JTable tablaCitaProgramada;
    private javax.swing.JTable tablaDiag;
    private javax.swing.JTable tablaRegistro;
    private javax.swing.JTable tablaTratamiento;
    private javax.swing.JLabel textApellidoPaciente;
    private javax.swing.JLabel textApellidoPaciente2;
    private javax.swing.JLabel textEdadPaciente;
    private javax.swing.JLabel textEspecialidad;
    private javax.swing.JLabel textHappyBirthday;
    private javax.swing.JLabel textMedicoEncDiag;
    private javax.swing.JLabel textName;
    private javax.swing.JLabel textNamePaciente;
    private javax.swing.JLabel textNombreDiag;
    private javax.swing.JLabel textObsDiag;
    private javax.swing.JLabel textResultDiag;
    private javax.swing.JLabel textTelefonoPaciente;
    private javax.swing.JLabel textTelefonoPaciente1;
    private javax.swing.JLabel textTelefonoPaciente2;
    private javax.swing.JLabel textTipoDiag;
    // End of variables declaration//GEN-END:variables

}
