package ohtu;

import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;
import java.io.IOException;
import java.nio.charset.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "012345678";
        if( args.length>0) {
            studentNr = args[0];
        }

        String url =  "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";
        String bodyText = Request.Get(url).execute().returnContent().asString();

        String url2 = "https://studies.cs.helsinki.fi/courses/courseinfo";
        String bodyText2 = Request.Get(url2).execute().returnContent().asString();

        //System.out.print("json-muotoinen-data");
        //System.out.print( bodyText);
        //System.out.println();
        //System.out.println();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Submission[] subs2 = mapper.fromJson(bodyText2, Submission[].class);

        for(Submission s : subs2){
            System.out.println(s.getMaksimi(1));
        }

        
        //System.out.print("Oliot:");
        System.out.print("opiskelijanumero " + studentNr + "\n\n");
        for(Submission submission : subs) {
            
            System.out.print(submission.getCourse()+", viikko"+ submission.getWeek());
            System.out.print(" tehtyjä tehtäviä yhteensä "+submission.getMaara());
            System.out.print(" aikaa kului yhteensä " + submission.getHours());
            System.out.print(" tehdyt tehtävät: " + submission.getExercises()+ "\n");
        }
    }
}
