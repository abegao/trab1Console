import java.util.Random;

//carro herda runnable (recebe td da classe runnable)
class Carro implements Runnable {
    
	//declarando variaveis
	private String nome;
    private int distanciaPercorrida;
    private int distanciaTotal;
    private Random random;

    //inicializando os atributos do objeto
    public Carro(String nome, int distanciaTotal) {
        this.nome = nome; //nome dos carros (numero no caso)
        this.distanciaPercorrida = 0; //distancia inicializa em zero
        this.distanciaTotal = distanciaTotal; //distancia total que o carro precisa percorrer
        this.random = new Random(); 
    }

    //aplica uma aceleracao aleatoria aos carros
    private void acelerar() {
        int aceleracao = random.nextInt(11) + 5; //aceleracao aleatoria entre 5 e 15
        distanciaPercorrida += aceleracao;
    }

    //verificacao se o carro chegou ao final da corrida ou nao
    private boolean chegouLinhaChegada() {
        return distanciaPercorrida >= distanciaTotal;
    }

    //carros comecam a correr e a todo momento eh verificado se o carro chegou a linha de chegada
    //a cada atualizacao de um carro, ele dorme por 1 segundo pra que haja a atualizacao de outro carro
    //sobrescrevendo o metodo run de runnable
    @Override
    public void run() {
        try {
            while (!chegouLinhaChegada()) {
                acelerar();
                Thread.sleep(1000); //espera por 1 segundo
                System.out.println("O " + nome + " andou " + distanciaPercorrida + "m\t e já percorreu " + distanciaPercorrida + "m");
            }
            System.out.println(nome + " alcançou a linha de chegada!");
        } catch (InterruptedException e) { //permitir que a thread do carro seja corretamente
        	//interrompida e finalizada de forma adequada quando ocorrer uma interrupcao.
            System.out.println("A thread do " + nome + " foi interrompida."); //caso de ruim
        }
    }

    public static void main(String[] args) {
        //criacao das threads para cada carro
    	Thread[] carros = new Thread[5]; 
    	
    	for (int i = 0; i < 5; i++) {
    		Thread carro = new Thread(new Carro("[Carro_" + String.valueOf(i) + "]", 200));
    		carros[i] = carro;
    	}
    	
        //inicia as threads dos carros
    	for (Thread t:carros) {
    		t.start();
    	}
        
        //seja o que deus quiser
    }
}