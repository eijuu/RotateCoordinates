import java.awt.geom.Point2D;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileWithCoordinates {

    private List<String> allFile;

    public FileWithCoordinates(String pathToFile) {
        try {
            allFile = Files.lines(Paths.get(pathToFile), StandardCharsets.UTF_8)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public String[] getHeader(boolean headerExist, String separator) {
        assert allFile != null : "not file";
        String[] res;
        try {
            res = allFile.get(0).split(separator);
        } catch (Exception e) {
            res = new String[] { allFile.get(0) };
        }
        if (!headerExist) {
            for (int i = 0; i < res.length; i++) {
                res[i] = String.valueOf(i);
            }
        }
        return res;
    }

    public List<String[]> getData(boolean headerExist, String separator, int maxRows) {
        assert allFile != null : "not file";

        List<String[]> res;
        try {
            if (maxRows == 0) {
                res = allFile.stream()
                        .map(s -> s.split(separator))
                        .collect(Collectors.toList());
            } else {
                res = allFile.stream()
                        .map(s -> s.split(separator))
                        .limit(maxRows)
                        .collect(Collectors.toList());
            }
        } catch (Exception e) {
            res = allFile.stream()
                    .map(s -> s.split(""))
                    .limit(maxRows)
                    .collect(Collectors.toList());
        }

        if (headerExist) {
            res.remove(0);
        }
        return res;
    }

    public List<String[]> getData(boolean columnExist, String separator) {
        return getData(columnExist, separator, 0);
    }

    public Point2D.Double[] getXY(int xColumn, int yColumn, boolean columnExist, String separator) {
        assert allFile != null : "not file";

        ArrayList<String[]> temp = (ArrayList<String[]>) getData(columnExist, separator);
        Point2D.Double[] pointRes = new Point2D.Double[temp.size()];
        try {
            for (int i = 0; i < pointRes.length; i++) {
                pointRes[i].setLocation(Double.parseDouble(temp.get(i)[xColumn]),
                        Double.parseDouble(temp.get(i)[yColumn]));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return pointRes;
    }

}
