package MONITORAMENTO.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import MONITORAMENTO.LOGICA.Monitoramento;
import MONITORAMENTO.LOGICA.UnidadeLogica;


public class ConsoleUi implements MonitoramentoUi {
	
	private UnidadeLogica mn;
	
	public ConsoleUi() {
	}
	
	@Override
	public void setLogica(UnidadeLogica logica) throws Exception {
		this.mn = logica;
	}
	
	public void run() throws Exception {
		BufferedReader lr = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Selecione uma das opções abaixo");
		System.out.println("1 - Criar Unidade");
		System.out.println("2 - Monitorar");
		int option = Integer.valueOf(lr.readLine());
		System.out.println(option);
		if(option == 1) {
			ciarUn(lr);
		}else if(option == 2) {
			monitorarUns(lr);
		}
	}

	private void monitorarUns(BufferedReader lr) throws IOException, Exception {
		try {
			System.out.println("Digite a abcissa");
			double abcissa = Double.valueOf(lr.readLine());
			System.out.println("Digite a ordenada");
			Double ordenada = Double.valueOf(lr.readLine());
			System.out.println("Ferramentas de monitoramento 1 = Sim / 2 = Não");
			System.out.println("Video");
			boolean video = Integer.valueOf(lr.readLine()) == 1 ? true : false;
			System.out.println("Termometro");
			boolean termometro = Integer.valueOf(lr.readLine()) == 1 ? true : false;
			System.out.println("Co2");
			boolean co2 = Integer.valueOf(lr.readLine()) == 1? true : false;
			System.out.println("Ch4");
			boolean ch4 = Integer.valueOf(lr.readLine()) == 1 ? true : false;
			
			String message = this.mn.monitorar(abcissa, ordenada, video, termometro, co2, ch4);
			System.out.println(message);
			
		} catch(NumberFormatException n) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void ciarUn(BufferedReader lr) {
		try {
			System.out.println("Digite o Id");
			int id = Integer.valueOf(lr.readLine());
			System.out.println("Digite a abcissa");
			double abcissa = Double.valueOf(lr.readLine());
			System.out.println("Digite a ordenada");
			Double ordenada = Double.valueOf(lr.readLine());
			System.out.println("Ferramentas de monitoramento 1 = Sim / 2 = Não");
			System.out.println("Video");
			boolean video = Integer.valueOf(lr.readLine()) == 1 ? true : false;
			System.out.println("Termometro");
			boolean termometro = Integer.valueOf(lr.readLine()) == 1 ? true : false;
			System.out.println("Co2");
			boolean co2 = Integer.valueOf(lr.readLine()) == 1? true : false;
			System.out.println("Ch4");
			boolean ch4 = Integer.valueOf(lr.readLine()) == 1 ? true : false;
			System.out.println("Escolha o tipo da unidade");
			System.out.println("1 - Euclidiana");
			System.out.println("2 - Manhattan");
			int tipo = Integer.valueOf(lr.readLine());
			
			if(tipo == 1) {
				this.mn.addUnidadeEuclidiana(id, abcissa, ordenada, video, termometro, co2, ch4);
				JOptionPane.showMessageDialog(null, "Unidade Euclidiana Criada");
			}else if(tipo == 2) {
				this.mn.addUnidadeManhattan(id, abcissa, ordenada, video, termometro, co2, ch4);
				JOptionPane.showMessageDialog(null, "Unidade Manhattan Criada");
			}
		}catch(NumberFormatException x) {
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
