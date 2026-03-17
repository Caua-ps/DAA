import java.util.Scanner;

public class exA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]f =  new int[n];
        for(int i=0;i<n;i++){
            f[i]=input.nextInt();
        }

        int t=input.nextInt();
        input.close();

        System.out.println(Resolver(n, f, t));
    }
    public static String Resolver(int n,int []f,int t){
        boolean[] visited = new boolean[n];

        int atual = t;
        int mandrioes = 0;

        while(true){
            int fk = f[atual];

            if(fk < 0||fk >= n){return "POLICIA";}

            if(fk == atual){return "" + mandrioes;}

            if(visited[fk]){return "INCOMPETENTE";}

            visited[atual] = true;
            mandrioes++;
            atual = fk;
        }
    }
}