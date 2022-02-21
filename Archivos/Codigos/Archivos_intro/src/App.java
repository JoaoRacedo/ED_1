import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String file_name = sc.nextLine();
        //System.out.println("LLenar archivo");
        //Llenar(sc, file_name);
        System.out.println("Escribir data de archivo en consola");
        Leer(file_name);
        System.out.println("Actualizar info");
        Update_stuff(sc, file_name);
        sc.close();
    }
    public static void Llenar(Scanner sc, String file_name){
        String Id = "";
        String Name = "";
        String Salary = "";
        try{
            FileWriter outFile = new FileWriter("Archivo.txt",false);
            // false = overwrite, true = appending data to the file
            PrintWriter out = new PrintWriter(outFile); //output
            boolean more = false;
            System.out.println("Is there info? true = si , false = no");
            more = Boolean.parseBoolean(sc.nextLine());
            while(more){
                System.out.println("Id");
                Id = sc.nextLine();
                System.out.println("Name");
                Name = sc.nextLine();
                System.out.println("Salary");
                Salary = sc.nextLine();

                if(!Id.isEmpty() && !Name.isEmpty() && !Salary.isEmpty())
                    out.println(Id + "\t" + Name + "\t" + Salary);
                System.out.println("More? true = si , false = no");
                more = Boolean.parseBoolean(sc.nextLine());
            }

            out.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }


    public static void Leer(String file_name){

        String Id = "";
        String Name = "";
        double Salary = 0.0;

        try{
            BufferedReader br = new BufferedReader(new FileReader(file_name+".txt"));
            String line = null;

            while((line = br.readLine()) != null){
                String temp[] = line.split("\t");
                Id = temp[0];
                Name = temp[1];
                Salary = Double.parseDouble(temp[2]);
                // Now we can do whatever we want with this information
                System.out.println(Id + "\t" + Name + "\t" + Salary);
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void Update_stuff(Scanner sc, String file_name){
        String Id, Name;
        double Salary;
        int Replenish;
        System.out.print("Enter ID : ");
        String pID = sc.nextLine();
        System.out.print("Enter replenish salary: ");
        Replenish = Integer.parseInt(sc.nextLine());
        try{
            File originalFile = new File(file_name+".txt");
            BufferedReader br = new BufferedReader(new FileReader(originalFile));
            // Construct the new file that will later be renamed to the original
            // filename.
            File tempFile = new File("tempfile.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;
            // Read from the original file and write to the new
            // unless content matches data to be removed/updated.
            while ((line = br.readLine()) != null) {
                if (line.contains(pID)) {
                    String strCurrentSalary = line.substring(line.lastIndexOf("\t"), line.length());
                    if (strCurrentSalary != null || !strCurrentSalary.trim().isEmpty()) {
                        int replenishedSalary = Integer.parseInt(strCurrentSalary.trim()) + Replenish;
                        System.out.println("ReplenishedSalary : " + replenishedSalary);
                        line = line.substring(0,line.lastIndexOf("\t")) + "\t" +replenishedSalary;
                    }

                }
                pw.println(line);
                pw.flush();
            }
            pw.close();
            br.close();

            // Delete the original file
            if (!originalFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(originalFile))
                System.out.println("Could not rename file");

            }catch(IOException e){
                e.printStackTrace();
            }
    }
}
