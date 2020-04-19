package rmi.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ContaBancariaImpl extends UnicastRemoteObject implements ContaBancaria {
	private static final long serialVersionUID = 1L;
	
	private double saldo;
	
	protected ContaBancariaImpl() throws RemoteException {
	}
	
	public void sacar(double valor) throws RemoteException {
		this.saldo -= valor;
	}
	
	public void depositar(double valor) throws RemoteException {
		this.saldo += valor;
	}
	
	public void transferir(double valor, ContaBancaria outraConta) throws RemoteException {
		sacar(valor);
		outraConta.depositar(valor);
	}
	
	public double getSaldo() throws RemoteException {
		return saldo;
	}
}
