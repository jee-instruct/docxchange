package com.vamsee.spring.services.impl;

import java.io.InputStream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.vamsee.spring.services.TikkaService;
@Service
@Scope("prototype")
public class TikkaServiceImpl implements TikkaService {
	
	@Override
	public String extractTextFromFile(InputStream stream) throws Exception {
		// TODO Auto-generated method stub
		  BodyContentHandler handler = new BodyContentHandler(Integer.MAX_VALUE);
		  Metadata metadata = new Metadata();
		  AutoDetectParser parser = new AutoDetectParser();
		  parser.parse(stream, handler, metadata);
		return handler.toString();
	}
	
	
	
	
	
	
	
	
	/*
	 * List of Parsers Available to Tikka
	 * 
	 *  org.apache.tika.parser.asm.ClassParser
		org.apache.tika.parser.audio.AudioParser
		org.apache.tika.parser.audio.MidiParser
		org.apache.tika.parser.crypto.Pkcs7Parser
		org.apache.tika.parser.dwg.DWGParser
		org.apache.tika.parser.epub.EpubParser
		org.apache.tika.parser.executable.ExecutableParser
		org.apache.tika.parser.feed.FeedParser
		org.apache.tika.parser.font.AdobeFontMetricParser
		org.apache.tika.parser.font.TrueTypeParser
		org.apache.tika.parser.html.HtmlParser
		org.apache.tika.parser.image.BPGParser
		org.apache.tika.parser.image.ImageParser
		org.apache.tika.parser.image.PSDParser
		org.apache.tika.parser.image.TiffParser
		org.apache.tika.parser.iptc.IptcAnpaParser
		org.apache.tika.parser.iwork.IWorkPackageParser
		org.apache.tika.parser.jpeg.JpegParser
		org.apache.tika.parser.mail.RFC822Parser
		org.apache.tika.parser.mbox.MboxParser
		org.apache.tika.parser.mbox.OutlookPSTParser
		org.apache.tika.parser.microsoft.OfficeParser
		org.apache.tika.parser.microsoft.OldExcelParser
		org.apache.tika.parser.microsoft.TNEFParser
		org.apache.tika.parser.microsoft.ooxml.OOXMLParser
		org.apache.tika.parser.mp3.Mp3Parser
		org.apache.tika.parser.mp4.MP4Parser
		org.apache.tika.parser.hdf.HDFParser
		org.apache.tika.parser.netcdf.NetCDFParser
		org.apache.tika.parser.odf.OpenDocumentParser
		org.apache.tika.parser.pdf.PDFParser
		org.apache.tika.parser.pkg.CompressorParser
		org.apache.tika.parser.pkg.PackageParser
		org.apache.tika.parser.pkg.RarParser
		org.apache.tika.parser.rtf.RTFParser
		org.apache.tika.parser.txt.TXTParser
		org.apache.tika.parser.video.FLVParser
		org.apache.tika.parser.xml.DcXMLParser
		org.apache.tika.parser.xml.FictionBookParser
		org.apache.tika.parser.chm.ChmParser
		org.apache.tika.parser.code.SourceCodeParser
		org.apache.tika.parser.mat.MatParser
		org.apache.tika.parser.ocr.TesseractOCRParser
		org.apache.tika.parser.gdal.GDALParser
		org.apache.tika.parser.grib.GribParser
		org.apache.tika.parser.jdbc.SQLite3Parser
	 */

}
