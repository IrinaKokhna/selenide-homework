package guru.qa.tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import net.lingala.zip4j.ZipFile;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class TxtTest {
    @Test
    void txtTest() throws Exception {
        String result;
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("query.txt")) {
            result = new String(is.readAllBytes(), "UTF-8");
        }
        assertThat(result).contains("classTag");
    }


    @Test
    void pdfTest() throws Exception {
        PDF parsed = new PDF(getClass().getClassLoader().getResourceAsStream("guide.pdf"));
        assertThat(parsed.text).contains("UI Testing of Real World Websites Using WebdriverIO");
    }

    @Test
    void xlsTest() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("tags.xls")) {
            XLS parsed = new XLS(is);
            assertThat(parsed.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue()).
                    isEqualTo("media partner number one");
        }
    }

    @Test
    void zipTest() throws Exception{

        ZipFile zf = new ZipFile("./src/test/resources/fin.zip");
        zf.setPassword("qwerty".toCharArray());
        zf.extractAll("./src/test/resources/unzip");
        try (FileInputStream stream = new FileInputStream("./src/test/resources/unzip/fin.txt")) {
        String result = new String(stream.readAllBytes(), "UTF-8");
        assertThat(result).contains("Ira");
        }
    }
    @Test
    void docFileTest() throws Exception {
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.
                load(new File("./src/test/resources/song.docx"));
        String result = wordMLPackage.getMainDocumentPart().getContent().toString();
        assertThat(result).contains("life");
    }
}

