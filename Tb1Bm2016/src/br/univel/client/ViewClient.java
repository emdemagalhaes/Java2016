package br.univel.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.univel.common.Client;
import br.univel.common.Server;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewClient extends JFrame implements Client {

	private JPanel contentPane;
	private JTextField txfIp;
	private JTextField txfPorta;
	private JTextField txfMensagem;
	private JButton buttonDesconectar;
	private JButton buttonConectar;
	private JLabel lblNome;
	private JTextField txfMeuNome;
	private JButton buttonEnviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewClient frame = new ViewClient();
					frame.setVisible(true);

					// =======================================================================================
					frame.configurar(); // Só essa chamada não foi feita pelo
										// Window Builder.
					// =======================================================================================

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the frame.
	 */
	public ViewClient() {
		setTitle("Torrent RMI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));



		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 0;
		panel_1.add(lblNome, gbc_lblNome);

		txfMeuNome = new JTextField();
		GridBagConstraints gbc_txfMeuNome = new GridBagConstraints();
		gbc_txfMeuNome.gridwidth = 3;
		gbc_txfMeuNome.insets = new Insets(0, 0, 5, 5);
		gbc_txfMeuNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfMeuNome.gridx = 1;
		gbc_txfMeuNome.gridy = 0;
		panel_1.add(txfMeuNome, gbc_txfMeuNome);
		txfMeuNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Endereço IP");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		txfIp = new JTextField();
		txfIp.setText("127.0.0.1");
		GridBagConstraints gbc_txfIp = new GridBagConstraints();
		gbc_txfIp.insets = new Insets(0, 0, 0, 5);
		gbc_txfIp.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfIp.gridx = 1;
		gbc_txfIp.gridy = 1;
		panel_1.add(txfIp, gbc_txfIp);
		txfIp.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Porta");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txfPorta = new JTextField();
		txfPorta.setText("1818");
		GridBagConstraints gbc_txfPorta = new GridBagConstraints();
		gbc_txfPorta.insets = new Insets(0, 0, 0, 5);
		gbc_txfPorta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfPorta.gridx = 3;
		gbc_txfPorta.gridy = 1;
		panel_1.add(txfPorta, gbc_txfPorta);
		txfPorta.setColumns(10);

		buttonConectar = new JButton("Conectar");
		GridBagConstraints gbc_buttonConectar = new GridBagConstraints();
		gbc_buttonConectar.insets = new Insets(0, 0, 0, 5);
		gbc_buttonConectar.gridx = 4;
		gbc_buttonConectar.gridy = 1;
		panel_1.add(buttonConectar, gbc_buttonConectar);

		buttonDesconectar = new JButton("Desconectar");
		GridBagConstraints gbc_buttonDesconectar = new GridBagConstraints();
		gbc_buttonDesconectar.gridx = 5;
		gbc_buttonDesconectar.gridy = 1;
		panel_1.add(buttonDesconectar, gbc_buttonDesconectar);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Arquivos", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		
		btnDownlod = new JButton("Downlod");
		panel_3.add(btnDownlod);
		
		
		splitPane = new JSplitPane();
		panel_2.add(splitPane, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);
		
		list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		panel = new JPanel();
		tabbedPane.addTab("Downloads", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.SOUTH);
		
		btnNewButton_2 = new JButton("Iniciar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_4.add(btnNewButton_2);
		
		btnNewButton_1 = new JButton("Pausar");
		panel_4.add(btnNewButton_1);
		
		btnNewButton = new JButton("Cancelar");
		panel_4.add(btnNewButton);
		
		table = new JTable();
		panel.add(table, BorderLayout.CENTER);
		
		
	}
	protected void configurar() {
		// TODO Auto-generated method stub
		
	}

	
	private Server server;

	/**
	 * Referência a esse próprio objeto depois de exportado, passado para o
	 * servidor.
	 */
	private Client client;

	/**
	 * Registo onde o objeto exportado será buscado pelo nome. É o registro que
	 * escuta na porta TCP/IP, aberto no servidor.
	 */
	private Registry registry;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JSplitPane splitPane;
	private JScrollPane scrollPane;
	private JList list;
	private JScrollPane scrollPane_1;
	private JList list_1;
	private JButton btnDownlod;
	private JPanel panel_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTable table;

	@Override
	public void listaClients(List<String> lista) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listaArquivos(String remetente, String mensagem) throws RemoteException {
		// TODO Auto-generated method stub
		
	}





}
