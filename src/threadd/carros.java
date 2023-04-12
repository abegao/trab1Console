package threadd;

import java.util.Random;

public class carros extends Thread {
	
	String nome;
	int distanciaTotal;
	int pista;
	
	
	
	int velocidade = 20;
	int distancia;
	int acel;
	
	Random random = new Random();
	
	public void run () {
	
		for(distancia=0;distancia<velocidade;) {
			acel = random.nextInt(50);
			distancia = distancia + acel;
			System.out.println("ferrari percorreu:" + acel + "km" + "percorreu no total" + distancia);
				if(distancia>velocidade) {
					System.out.println("ferrari chegou");
				}
		}
	}
	
	public void setNome(String nome) {
        this.nome = nome;
    }
	
	public void setDistanciaTotal(int total) {
        distanciaTotal = total;
    }
	
	}


