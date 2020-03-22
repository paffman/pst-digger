package de.mapaco.pstdigger;

import de.mapaco.pstdigger.model.ParseResponse;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;

/**
 * Test cases for digger.
 */
@SuppressWarnings("static-method")
public class OutlookParserTest {

	private static final File TEST_HOME = new File("target/wkp");

	/**
	 * Global test cases init
	 */
	@BeforeClass
	public static void globalInit() {
		FileUtils.deleteQuietly(TEST_HOME);
		Assert.assertTrue(TEST_HOME.mkdirs());
	}

	/**
	 * Test case using case no sensitive without attachments dumping.<br>
	 * One keyword searched
	 *
	 * @throws Exception
	 */
	@Test
	public void testParseAllEmails() throws Exception {
		// Prepare test workspace
		boolean caseSensitive = false;
		boolean dumpAttachments = false;
		String searchedKeyword = "password";
		File pst = new File("src/test/resources/test.pst");
		File output = new File("target/parserTest/outTest02");
		output.mkdirs();
		// Run test
		ParseResponse response = new PstProcessor(caseSensitive, searchedKeyword, pst, output, dumpAttachments).findEmails();
		// Validate test result
		String mailsFoundLog = new String(Files.readAllBytes(new File(output, "interesting-mails.txt").toPath()));
		Assert.assertTrue(response.getEmailCount() == 6);
		Assert.assertTrue(output.listFiles().length == 1);
		Assert.assertTrue(mailsFoundLog.contains("MAIL ID:2097220"));
		Assert.assertTrue(mailsFoundLog.contains("MAIL ID:2097188"));
		Assert.assertTrue(mailsFoundLog.contains("MAIL ID:2097348"));
	}
}
