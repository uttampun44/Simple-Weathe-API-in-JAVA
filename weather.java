import java.util.Scanner;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

class Weather {

    public void display() {

        try {
            System.out.println("Welcome to the Weather forecast");

            Date d = new Date();
            System.out.println(d);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Your City Name");

            String cityname = sc.nextLine();

            System.out.println(" Your have enter " + cityname);

            var url = "https://nepal-weather-api.herokuapp.com/api/?place=Bhairahawa";
            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            System.out.println(" Today's Weather ");

        } catch (Exception e) {
            // TODO: handle exception

        }
    }

}

class WeatherAPI extends Weather {
    public static void main(String[] args) {
        Weather r = new Weather();
        r.display();
    }
}