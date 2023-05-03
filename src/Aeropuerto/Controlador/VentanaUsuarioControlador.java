package Aeropuerto.Controlador;

import Aeropuerto.Vista.VentanaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class VentanaUsuarioControlador{
    private VentanaPrincipalControlador vp;
    private VentanaUsuario vu = new VentanaUsuario();
    private AgregarViajesControlador av = new AgregarViajesControlador();

    
    public void ejecutarVentanaU(Usuario u){
        vu.setTitle("Informacion de Usuario");
        vu.setLocationRelativeTo(null);
        vu.setVisible(true);
        
        asignarVariables(u);
        ejecutarBotonAgregarV(u);
        ejecutarBotonSalir();
    }
    
    public int verificar(){
        int op = JOptionPane.showOptionDialog(null,"¿Realmente Desea Continuar?",
                "Confirme",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
                null,new Object[] {"Si","No"},"Si");
        
        return op;
    }
    public void asignarVariables(Usuario u){
        vu.NombreUsuario.setText(u.getNombreU());
        vu.NoRegistro.setText(u.getNoUsuario());
        vu.Telefono.setText(u.getTelefono());
        vu.Clave.setText(u.getClave());
    }
    public void ejecutarBotonAgregarV(Usuario u){
        vu.AgregarViajes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                av.ejecuarAgregarV(u);
            }
        });
    }
    public void ejecutarBotonSalir(){
        vu.SalirBoton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                vp = new VentanaPrincipalControlador();
                int op = verificar();
                
                if(op==0){
                    vp.ejecutarVentanaP();
                    vu.dispose();
                }
            }
        });
    }
}
