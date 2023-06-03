import com.omdbapi.service.MovieService;
import com.omdbapi.service.SeriesService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao = "";
        String titulo = "";

        while (!opcao.equals("sair")) {
            System.out.println("Digite filme ou serie para realizar uma busca, ou digite sair para finalizar:");
            opcao = scanner.nextLine().toLowerCase();

            switch (opcao) {
                case "filme":
                    System.out.println("Digite o nome do filme que voce quer buscar em ingles:");
                    titulo = scanner.nextLine();
                    MovieService movieService = new MovieService();
                    movieService.getMovie(titulo);
                    break;
                case "serie":
                    System.out.println("Digite o nome da serie que voce quer buscar em ingles:");
                    titulo = scanner.nextLine();
                    SeriesService seriesService = new SeriesService();
                    seriesService.getSeries(titulo);
                    break;
                case "sair":
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opção invalida!");
                    System.out.println("Digite filme ou serie ou digite sair para finalizar!");
                    break;
            }
        }
    }
}
