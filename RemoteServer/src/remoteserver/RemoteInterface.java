package remoteserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
    boolean registrarUsuario(String username, String password) throws RemoteException;
    boolean autenticar(String username, String password) throws RemoteException;
}
