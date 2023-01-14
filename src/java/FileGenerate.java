package java;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class FileGenerate {

    private static final  String  FILE_data = "res/data_experiment.xml";
    private static String textFileStart = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
            "<voters>";
    private static String textFileFinish = "</voters>";
    private static int fileSize = 1024;


    public static void main(String[] args) {
        long startTimer = System.currentTimeMillis();
        long usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        removeLineFromFile(FILE_data, textFileFinish);


        usage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - usage;
        System.out.println("usage: " + usage + " B");
        System.out.println((System.currentTimeMillis() - startTimer) + " ms");
    }

    static public void removeLineFromFile(String file, String lineToRemove) {

        try {

            File inFile = new File(file);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {

                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
                while (tempFile.length() < fileSize) {
                    StringBuilder builder = new StringBuilder();
                    builder.append("\t<voter name=\"");
                    builder.append(nameGenerate());
                    builder.append("\" birthDay=\"");
                    String birthDay = birthDayGenerate();
                    builder.append(birthDay);
                    builder.append("\">\n\t\t<visit station=\"");
                    builder.append((int) ((Math.random() * (15 - 1)) + 1));
                    builder.append("\" time=\"");
                    builder.append(visitingTimeGenerate(birthDay));
                    builder.append("\"/>\n\t</voter>\n");
                    pw.print(builder);
                }
            pw.print(textFileFinish);
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String nameGenerate(){
        int maxSurnameLength = 15;
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            if (j == 1) {
                builder.append(" ");
            } else {
                for (int i = 1; i < (int) ((Math.random() * (maxSurnameLength - 5)) + 5); i++) {
                    if (i == 1) {
                        builder.append((char) (int) ((Math.random() * (1072 - 1040)) + 1040));
                    } else {
                        int letterInt = (int) ((Math.random() * (1105 - 1072)) + 1072);
                        if (letterInt == 1104) {
                            letterInt = 1105;
                        }
                        builder.append((char) letterInt);
                    }

                }
            }
        }
        return builder.toString();
    }

    private static String birthDayGenerate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate minBirthDay = LocalDate.parse("1910.01.01", formatter);
        int maxDays = (int) minBirthDay.until(LocalDate.now(), ChronoUnit.DAYS);
        int plusDay = (int) ((Math.random() * (maxDays - 2)) + 2);
        LocalDate birthDay = minBirthDay.plusDays(plusDay);
        return formatter.format(birthDay);
    }

    private static String visitingTimeGenerate(String startDayBase){
        String startDaySec = startDayBase.concat( " 00:00:00");
        DateTimeFormatter formatterSec = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        LocalDateTime minBirthDaySec = LocalDateTime.parse(startDaySec, formatterSec);
        long maxSecond = minBirthDaySec.until(LocalDateTime.now(), ChronoUnit.SECONDS);
//        for (int i = 0; i < 100; i++) {
        long plusSecond = (long) ((Math.random() * (maxSecond - 2)) + 2);
        LocalDateTime visitingTime = minBirthDaySec.plusSeconds(plusSecond);
//            System.out.println(maxSecond);
//            System.out.println(formatterSec.format(visitingTime));
//        }
        return formatterSec.format(visitingTime);
    }
}
