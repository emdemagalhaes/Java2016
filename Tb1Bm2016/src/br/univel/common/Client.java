package br.univel.common;

import java.rmi.RemoteException;
import java.util.List;

public interface Client {

	//lista os clientes conectados
	public void listaClients(List<String> lista) throws RemoteException;
	
	//recebe a lista de arquivos dos cliente
	public void listaArquivos(String remetente, String mensagem) throws RemoteException;



}
