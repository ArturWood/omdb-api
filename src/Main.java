import com.omdbapi.infra.FileCreator;
import com.omdbapi.model.Movie;
import com.omdbapi.model.Series;
import com.omdbapi.service.MovieService;
import com.omdbapi.service.SeriesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao = "";
        String titulo = "";
        List listTitulos = new ArrayList<>();
        MovieService movieService = new MovieService();
        SeriesService seriesService = new SeriesService();
        FileCreator fileCreator = new FileCreator();

        while (!opcao.equals("sair")) {
            System.out.println("Digite filme ou serie para realizar uma busca, ou digite sair para finalizar:");
            opcao = scanner.nextLine().toLowerCase();

            switch (opcao) {
                case "filme" -> {
                    System.out.println("Digite o nome do filme que voce quer buscar em ingles:");
                    titulo = scanner.nextLine();
                    Movie movie = movieService.getMovie(titulo);
                    if (movie != null) {
                        listTitulos.add(movie);
                    }
                }
                case "serie" -> {
                    System.out.println("Digite o nome da serie que voce quer buscar em ingles:");
                    titulo = scanner.nextLine();
                    Series series = seriesService.getSeries(titulo);
                    if (series != null) {
                        listTitulos.add(series);
                    }
                }
                case "sair" -> System.out.println("Finalizando...");
                default -> {
                    System.out.println("Opção invalida!");
                    System.out.println("Digite filme ou serie ou digite sair para finalizar!");
                }
            }
        }
        System.out.println("Buscas a serem criadas no arquivo JSON: " + listTitulos);
        fileCreator.jsonCreator(listTitulos);
    }
}
