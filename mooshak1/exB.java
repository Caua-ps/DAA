import java.util.*;

/**
 * Classe principal que simula um sistema de caixa automático.
 *
 * O programa:
 * - Lê a quantidade inicial de moedas disponíveis (2€, 1€, 50c, 20c, 10c, 5c)
 * - Processa várias transações até o valor ser 0
 * - Para cada transação:
 *      - Soma o dinheiro inserido
 *      - Calcula o troco
 *      - Tenta devolver o troco com as moedas disponíveis
 * - Se não conseguir dar troco exato:
 *      - Conta como "stolen" (dinheiro não devolvido)
 *      - Acumula o valor retido
 *
 * No final:
 * - Mostra o valor total retido
 * - Mostra quantas transações falharam (stolen/total)
 */
public class exB {

    public static Scanner input = new Scanner(System.in);

    /**
     * Método principal onde toda a lógica do programa é executada.
     */
    public static void main(String[] args) {

        /**
         * Array que guarda a quantidade de moedas disponíveis:
         * índice 0 → moedas de 2€
         * índice 1 → moedas de 1€
         * índice 2 → moedas de 50c
         * índice 3 → moedas de 20c
         * índice 4 → moedas de 10c
         * índice 5 → moedas de 5c
         */
        int [] coins = new int[6];

        // Lê a quantidade inicial de cada tipo de moeda
        for (int i = 0; i<6; i++){
            coins[i] = input.nextInt();
        }

        /**
         * Lê o valor do produto (euros + cêntimos)
         * Converte tudo para cêntimos para facilitar cálculos
         */
        int value = input.nextInt() * 100 + input.nextInt();

        int stolen = 0;   // Número de transações onde não foi possível dar troco
        int retained = 0; // Total de dinheiro não devolvido (em cêntimos)
        int total = 0;    // Número total de transações

        /**
         * Loop principal: continua enquanto houver valores diferentes de 0
         */
        while (value != 0){

            int sum = 0; // Soma do dinheiro inserido pelo cliente

            /**
             * Lê moedas inseridas até encontrar 0 (fim da inserção)
             */
            int current = input.nextInt();

            while(current != 0){

                /**
                 * Se a moeda for 1€ ou 2€, converte para cêntimos
                 * Caso contrário já está em cêntimos
                 */
                sum += current == 2 || current == 1 ? current * 100 : current;

                /**
                 * Atualiza o número de moedas disponíveis na máquina
                 */
                switch (current){
                    case 2: coins[0]++; break;
                    case 1: coins[1]++; break;
                    case 50: coins[2]++; break;
                    case 20: coins[3]++; break;
                    case 10: coins[4]++; break;
                    case 5: coins[5]++; break;
                }

                current = input.nextInt();
            }

            /**
             * Calcula o troco a devolver
             */
            int change = sum - value;

            total++; // Conta mais uma transação

            /**
             * Tenta devolver o troco usando algoritmo guloso:
             * usa primeiro as moedas de maior valor
             */
            for(int i = 0; i < coins.length; i++){

                if (coins[i] == 0) continue;

                int currentExchange;
                int needed;

                switch (i){

                    case 0: // moedas de 2€
                        if(change < 200) break;

                        currentExchange = coins[i]*200;
                        needed = (change / 200)*200;

                        if(currentExchange >= needed){
                            coins[i] -= change/200;
                            change -= needed;
                        }
                        else{
                            change -= currentExchange;
                            coins[i] = 0;
                        }
                        break;

                    case 1: // moedas de 1€
                        if(change < 100) break;

                        currentExchange = coins[i]*100;
                        needed = (change / 100)*100;

                        if(currentExchange >= needed){
                            coins[i] -= change/100;
                            change -= needed;
                        }
                        else{
                            change -= currentExchange;
                            coins[i] = 0;
                        }
                        break;

                    case 2: // moedas de 50c
                        if(change < 50) break;

                        currentExchange = coins[i]*50;
                        needed = (change / 50)*50;

                        if(currentExchange >= needed){
                            coins[i] -= change/50;
                            change -= needed;
                        }
                        else{
                            change -= currentExchange;
                            coins[i] = 0;
                        }
                        break;

                    case 3: // moedas de 20c
                        if(change < 20) break;

                        currentExchange = coins[i]*20;
                        needed = (change / 20)*20;

                        if(currentExchange >= needed){
                            coins[i] -= change/20;
                            change -= needed;
                        }
                        else{
                            change -= currentExchange;
                            coins[i] = 0;
                        }
                        break;

                    case 4: // moedas de 10c
                        if(change < 10) break;

                        currentExchange = coins[i]*10;
                        needed = (change / 10)*10;

                        if(currentExchange >= needed){
                            coins[i] -= change/10;
                            change -= needed;
                        }
                        else{
                            change -= currentExchange;
                            coins[i] = 0;
                        }
                        break;

                    case 5: // moedas de 5c
                        if(change < 5) break;

                        currentExchange = coins[i]*5;
                        needed = (change / 5)*5;

                        if(currentExchange >= needed){
                            coins[i] -= change/5;
                            change -= needed;
                        }
                        else{
                            change -= currentExchange;
                            coins[i] = 0;
                        }
                        break;
                }
            }

            /**
             * Se ainda restar troco, significa que não foi possível devolver tudo
             */
            if(change != 0){
                stolen++;          // conta falha
                retained += change; // acumula valor não devolvido
            }

            /**
             * Lê o próximo valor do produto
             */
            value = input.nextInt() * 100 + input.nextInt();
        }

        /**
         * Imprime:
         * - valor total retido (em euros e cêntimos)
         * - número de falhas / total de transações
         */
        System.out.println(retained/100 + " " + retained%100);
        System.out.println(stolen + "/" + total);
    }
}