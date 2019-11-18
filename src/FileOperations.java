
/**
 * Deals with file operations like reading and writing.
 * 
 * @author Eduardo Andrade
 * @author Marcelo Heredia
 */
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class FileOperations {
	/**
	 * Read all lines from a file as a String.
	 * 
	 * @param filePath the path to the file
	 * @return the whole file content as a single String
	 * @throws IOException if an I/O error occurs while trying to open the file
	 */
	public static String ReadFileToString(Path filePath) throws IOException, NoSuchFileException {
		return Files.lines(filePath, StandardCharsets.US_ASCII).collect(Collectors.joining("\n"));
	}

	/**
	 * Write file
	 * 
	 * @param filePath path to the file
	 * @param text     text to write
	 * @return success or failure
	 * @throws IOException
	 */
	public static boolean WriteStringToFile(Path filePath, String text) throws IOException {
		try {
			Files.write(filePath, text.getBytes());
			return true;
		}
		catch (Exception ex) {
			return false;
		}
	}
}
