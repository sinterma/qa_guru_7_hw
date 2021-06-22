package tests;

import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.core.ZipFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;


public class ZipFileTests {
    @Test
    void ZipTest() throws IOException, ZipException {
        String zipFilePath= "./src/test/resources/files/1.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip";
        String zipPassword= "123";
        String unzipTxtFilePath = "./src/test/resources/files/unzip/1.txt";
        String expectedData = "hello";

        ZipFile zipFile = new ZipFile(zipFilePath);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(zipPassword);

        }
        zipFile.extractAll(unzipTxtFilePath);

    String actualData = readTextFromPath(unzipTxtFilePath);
    assertThat(actualData, containsString(expectedData));
}
}
