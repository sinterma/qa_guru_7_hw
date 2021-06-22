package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;


import java.io.IOException;


import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getXLS;



public class XlsFileTests {
    @Test
    void xlsTest() throws IOException {
            String xlsFilePath = "./src/test/resources/files/1.xls";
            String expectedData = "hello";

            XLS xls = getXLS (xlsFilePath);
        assertThat(xls, XLS.containsText(expectedData));
        }
    }

