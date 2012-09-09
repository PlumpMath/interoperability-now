package com.globalsight.tip;

import org.junit.*;

import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class TestTIPManifest {

	@Test
	public void testEmptyManifest() throws Exception {
		Manifest manifest = Manifest.newManifest(null);
		assertNotNull(manifest.getCreator());
		assertNotNull(manifest.getCreator().getTool());
		assertNotNull(manifest.getObjectSections());
	}
	
    @Test
    public void testManifest() throws Exception {
        Manifest manifest = new Manifest(null);
        TIPPLoadStatus status = new TIPPLoadStatus();
        manifest.loadFromStream(getClass().getResourceAsStream(
                "data/peanut_butter.xml"), status);
        assertEquals(0, status.getAllErrors().size());
        verifyRequestManifest(manifest);
    }

    @Test
    public void testManifestSave() throws Exception {
        Manifest manifest = new Manifest(null);
        TIPPLoadStatus status = new TIPPLoadStatus();
        manifest.loadFromStream(getClass().getResourceAsStream(
                "data/peanut_butter.xml"), status);
        assertEquals(0, status.getAllErrors().size());
        status = new TIPPLoadStatus();
        Manifest roundtrip = roundtripManifest(manifest, status);
        assertEquals(0, status.getAllErrors().size());
        verifyRequestManifest(roundtrip);
    }

    @Test
    public void testResponseManifest() throws Exception {
        Manifest manifest = new Manifest(null);
        TIPPLoadStatus status = new TIPPLoadStatus();
        manifest.loadFromStream(getClass().getResourceAsStream(
                "data/peanut_butter_response.xml"), status);
        assertEquals(0, status.getAllErrors().size());
        verifySampleResponseManifest(manifest);
        status = new TIPPLoadStatus();
        Manifest roundtrip = roundtripManifest(manifest, status);
        assertEquals(0, status.getAllErrors().size());
        verifySampleResponseManifest(roundtrip);
    }

    @Test
    public void testResponseCreationFromRequest() throws Exception {
        TIPPLoadStatus status = new TIPPLoadStatus();
    	TIPP requestPackage = getSamplePackage("data/test_package.zip", status);
    	assertEquals(0, status.getAllErrors().size());
        Manifest responseManifest = Manifest.newResponseManifest(null, requestPackage);
        assertFalse(responseManifest.isRequest());
        assertEquals(StandardTaskType.TRANSLATE_STRICT_BITEXT.getType(), 
   		 	 responseManifest.getTask().getTaskType());
        assertEquals("en-US", responseManifest.getTask().getSourceLocale());
        assertEquals("fr-FR", responseManifest.getTask().getTargetLocale());
        // Make sure the internal object was set correctly
        assertEquals(StandardTaskType.TRANSLATE_STRICT_BITEXT, 
        			 responseManifest.getTaskType());
        TIPPTaskResponse taskResponse = 
        		(TIPPTaskResponse)responseManifest.getTask();
        assertEquals(requestPackage.getCreator(), taskResponse.getRequestCreator());
        assertEquals(requestPackage.getPackageId(), taskResponse.getRequestPackageId());
    }
    
    @Test
    public void testNewManifest() throws Exception {
        Manifest manifest = Manifest.newRequestManifest(null, 
        						StandardTaskType.TRANSLATE_STRICT_BITEXT);
        manifest.setPackageId("urn:uuid:12345");
        manifest.setCreator(new TIPPCreator("Test", "Test Testerson", getDate(
                2011, 3, 14, 6, 55, 11), new TIPPTool("TestTool", "urn:test",
                "1.0")));
        manifest.getTask().setSourceLocale("en-US");
        manifest.getTask().setTargetLocale("jp-JP");
        // Add a section
        final TIPPObjectFile file = 
                new TIPPObjectFile("test.xlf", "test.xlf");
        TIPPObjectSection section = manifest.addObjectSection("bilingual",
                StandardTaskTypeConstants.TranslateStrictBitext.BILINGUAL);
        section.addObject(file);
        TIPPLoadStatus status = new TIPPLoadStatus();
        Manifest roundtrip = roundtripManifest(manifest, status);
        assertEquals(0, status.getAllErrors().size());
        assertEquals("urn:uuid:12345", roundtrip.getPackageId());
        assertEquals(manifest.getCreator(), roundtrip.getCreator());
        assertEquals(manifest.getTask(), roundtrip.getTask());
        expectObjectSection(roundtrip, 
        		StandardTaskTypeConstants.TranslateStrictBitext.BILINGUAL,
                Collections.singletonList(file));
    }

    private Manifest roundtripManifest(Manifest src, TIPPLoadStatus status) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        src.saveToStream(output);
        Manifest roundtrip = new Manifest(null);
        roundtrip
                .loadFromStream(new ByteArrayInputStream(output.toByteArray()), status);
        return roundtrip;
    }

    static void verifyRequestManifest(Manifest manifest) {
        verifySampleManifest(manifest, "urn:uuid:12345-abc-6789-aslkjd-19193la-as9911");
    }

    static void verifyResponseManifest(Manifest manifest) {
        verifySampleManifest(manifest, "urn:uuid:84983-zzz-0091-alpppq-184903b-aj1239");
    }

    @SuppressWarnings("serial")
    static void verifySampleManifest(Manifest manifest, String packageId) {
        assertEquals(packageId, manifest.getPackageId());
        assertEquals(new TIPPCreator("Test Company", "http://127.0.0.1/test",
                getDate(2011, 4, 9, 22, 45, 0), new TIPPTool("TestTool",
                        "http://interoperability-now.org/", "1.0")),
                manifest.getCreator());
        assertEquals(new TIPPTaskRequest(StandardTaskTypeConstants.TRANSLATE_STRICT_BITEXT_URI,
                "en-US", "fr-FR"), manifest.getTask());

        // XXX This test is cheating by assuming a particular order,
        // which is not guaranteed
        expectObjectSection(manifest, StandardTaskTypeConstants.TranslateStrictBitext.BILINGUAL,
                Collections.singletonList(
                        new TIPPObjectFile("Peanut_Butter.xlf")));
        expectObjectSection(manifest, StandardTaskTypeConstants.TranslateStrictBitext.PREVIEW,
                new ArrayList<TIPPObjectFile>() {
                    {
                        add(new TIPPObjectFile(
                                "Peanut_Butter.html.skl", 1));
                        add(new TIPPObjectFile(
                                "resources/20px-Padlock-silver.svg.png", 2));
                        add(new TIPPObjectFile("resources/load.php", 3));
                        add(new TIPPObjectFile(
                                "resources/290px-PeanutButter.jpg", 4));
                        add(new TIPPObjectFile(
                                "resources/load(1).php", 5));
                        add(new TIPPObjectFile(
                                "resources/magnify-clip.png", 6));
                    }
                });
    }

    static void verifySampleResponseManifest(Manifest manifest) {
        assertEquals("urn:uuid:84983-zzz-0091-alpppq-184903b-aj1239", 
                     manifest.getPackageId());
        assertEquals(new TIPPCreator("Test Testerson", "http://interoperability-now.org",
                getDate(2011, 4, 18, 19, 03, 15), new TIPPTool("Test Workbench",
                        "http://interoperability-now.org", "2.0")),
                manifest.getCreator());
        // Then verify the response
        assertNotNull(manifest.getTask());
        assertTrue(manifest.getTask() instanceof TIPPTaskResponse);
        assertEquals(new TIPPTaskResponse(
        				StandardTaskTypeConstants.TRANSLATE_STRICT_BITEXT_URI,
                        "en-US", 
                        "fr-FR",
                        "urn:uuid:12345-abc-6789-aslkjd-19193la-as9911",
                        new TIPPCreator("Test Company",
                                        "http://127.0.0.1/test",
                                        getDate(2011, 4, 9, 22, 45, 0),
                                        new TIPPTool("TestTool", "http://interoperability-now.org/", "1.0")),
                        TIPPResponseMessage.Success, ""),
                     manifest.getTask());
        assertEquals(new TIPPCreator("Test Testerson", 
                                "http://interoperability-now.org", 
                                getDate(2011, 4, 18, 19, 3, 15), 
                                new TIPPTool("Test Workbench", 
                                        "http://interoperability-now.org", "2.0")),
                     manifest.getCreator());
        TIPPTaskResponse response = ((TIPPTaskResponse)manifest.getTask());
        assertEquals(TIPPResponseMessage.Success, 
                response.getMessage());
        assertEquals("", response.getComment());
        // TODO: verify response
    }

    /**
     * This follows the Calendar.set() parameter conventions. Note that month is
     * zero-indexed!
     */
    static Date getDate(int y, int mon, int d, int h, int min, int s) {
        Calendar c = GregorianCalendar.getInstance();
        c.setTimeInMillis(0); // Zero out the ms field or comparison may fail!
        c.set(y, mon, d, h, min, s); // note 0-indexed month
        return c.getTime();
    }

    private static void expectObjectSection(Manifest manifest,
            String type, List<TIPPObjectFile> files) {
        TIPPObjectSection section = manifest.getObjectSection(type);
        assertNotNull(section);
        assertEquals(type, section.getType());
        assertEquals(files,
                new ArrayList<TIPPObjectFile>(section.getObjectFiles()));
    }
    
    private TIPP getSamplePackage(String path, TIPPLoadStatus status) throws Exception {
        InputStream is = 
            getClass().getResourceAsStream(path);
        return TIPPFactory.openFromStream(is, status);
    }

}
