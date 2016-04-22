package br.univel.common;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Server extends Remote {

	public static final String NOME = "TorrentRMI";

	//Realiza o login no servidor
	public void loginTorrent(String nome, Client cliente) throws RemoteException;

	//Realiza o donwload de um arquivo
	public void download(String remetente, String destinatario, String mensagem) throws RemoteException;

	//Compartilha os arquivos locais
	public void compatilhar(String remetente, String mensagem) throws RemoteException;


	public void logoff(String nome) throws RemoteException;

}
